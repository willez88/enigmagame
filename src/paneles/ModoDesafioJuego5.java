package paneles;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import clases.PreguntaJuego5;
import clases.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ModoDesafioJuego5 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5966509488696218514L;
	private ArrayList<PreguntaJuego5> Preguntas;
	private JTextField textField;
	private Final panelFinal;
	/**
	 * Create the panel.
	 * @param personaje 
	 * @param conexion 
	 * @param usuario 
	 */
	public ModoDesafioJuego5(Connection conexion, String personaje, Usuario usuario) {
		setBackground(Color.BLACK);
		setLayout(null);
		//quitar al terminar
		setSize(1366, 768);
		
		Random r= new Random();
        r.setSeed(new Date().getTime());
		Preguntas= new ArrayList<PreguntaJuego5>();
		
		//se cargan todas las preguntas del juego5
		Preguntas= cargarPreguntasJuego5(conexion);
		int num= r.nextInt(Preguntas.size());
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(SeleccionarPersonaje.class.getResource(personaje)));
		btnNewButton.setBounds(65, 40, 200, 160);
		add(btnNewButton);
		
		JButton btnJuego_5 = new JButton("Juego 5");
		btnJuego_5.setEnabled(false);
		btnJuego_5.setBounds(1176, 111, 89, 23);
		add(btnJuego_5);
		
		JLabel labelTitulo = new JLabel("Última Llamada");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTitulo.setForeground(Color.GREEN);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(556, 186, 200, 30);
		add(labelTitulo);
		
		JLabel label_1 = new JLabel(Preguntas.get(num).getPista1());
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(65, 350, 700, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel(Preguntas.get(num).getPista2());
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(65, 400, 700, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel(Preguntas.get(num).getPista3());
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(65, 450, 700, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel(Preguntas.get(num).getPista4());
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(65, 500, 700, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel(Preguntas.get(num).getPista5());
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(65, 550, 700, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel(Preguntas.get(num).getPista6());
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(65, 600, 700, 15);
		add(label_6);
		
		JButton btnJuegoFinalizado = new JButton("Juego Finalizado");
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaskFormatter mascara = null;
				try {
					mascara = new MaskFormatter("#,#,#,#,#,#");
					JFormattedTextField textField_2 = new JFormattedTextField(mascara);
					textField_2.setValue(textField.getText());
					//System.out.println(textField_2.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int g=0;
				String linea[]= textField.getText().split(",");
				if( linea.length==6 )
				{
					if( Integer.parseInt(linea[0])==Preguntas.get(num).getRespuesta1() )
					{
						usuario.setPuntos(usuario.getPuntos()+20);
						actualizarPuntos(conexion, usuario);
						g++;
					}
					
					if( Integer.parseInt(linea[1])==Preguntas.get(num).getRespuesta2() )
					{
						usuario.setPuntos(usuario.getPuntos()+20);
						actualizarPuntos(conexion, usuario);
						g++;
					}
					
					if( Integer.parseInt(linea[2])==Preguntas.get(num).getRespuesta3() )
					{
						usuario.setPuntos(usuario.getPuntos()+20);
						actualizarPuntos(conexion, usuario);
						g++;
					}
					
					if( Integer.parseInt(linea[3])==Preguntas.get(num).getRespuesta4() )
					{
						usuario.setPuntos(usuario.getPuntos()+20);
						actualizarPuntos(conexion, usuario);
						g++;
					}
					
					if( Integer.parseInt(linea[4])==Preguntas.get(num).getRespuesta5() )
					{
						usuario.setPuntos(usuario.getPuntos()+20);
						actualizarPuntos(conexion, usuario);
						g++;
					}
					
					if( Integer.parseInt(linea[5])==Preguntas.get(num).getRespuesta6() )
					{
						usuario.setPuntos(usuario.getPuntos()+20);
						actualizarPuntos(conexion, usuario);
						g++;
					}
					JOptionPane.showMessageDialog(null, "Acertados: "+g+" 20pts c/u\nIncorrectos: "+(6-g));
					textField.setEnabled(false);
					btnJuegoFinalizado.setEnabled(true);
				}
			}
		});
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(465, 670, 200, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_7 = new JLabel("1) "+Preguntas.get(num).getOpcion1());
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(65, 300, 150, 15);
		add(label_7);
		
		JLabel label_8 = new JLabel("2) "+Preguntas.get(num).getOpcion2());
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(265, 300, 150, 15);
		add(label_8);
		
		JLabel label_9 = new JLabel("3) "+Preguntas.get(num).getOpcion3());
		label_9.setForeground(Color.WHITE);
		label_9.setBounds(465, 300, 150, 15);
		add(label_9);
		
		JLabel label_10 = new JLabel("4) "+Preguntas.get(num).getOpcion4());
		label_10.setForeground(Color.WHITE);
		label_10.setBounds(665, 300, 150, 15);
		add(label_10);
		
		JLabel label_11 = new JLabel("5) "+Preguntas.get(num).getOpcion5());
		label_11.setForeground(Color.WHITE);
		label_11.setBounds(865, 300, 150, 15);
		add(label_11);
		
		JLabel label_12 = new JLabel("6) "+Preguntas.get(num).getOpcion6());
		label_12.setForeground(Color.WHITE);
		label_12.setBounds(1065, 300, 150, 15);
		add(label_12);
		
		//JButton btnJuegoFinalizado = new JButton("Juego Finalizado");
		btnJuegoFinalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFinal= new Final(conexion, usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelFinal);
				panelFinal.setLayout(null);
				panelFinal.setSize(getWidth(), getHeight());
			}
		});
		btnJuegoFinalizado.setEnabled(false);
		btnJuegoFinalizado.setBounds(970, 110, 155, 25);
		add(btnJuegoFinalizado);
		
	}
	
	public ArrayList<PreguntaJuego5> cargarPreguntasJuego5(Connection conexion)
	{
		PreguntaJuego5 preguntajuego5;
		ArrayList<PreguntaJuego5> Preguntas= new ArrayList<PreguntaJuego5>();
		ResultSet consulta;
		Statement statement;
		try {
			statement = (Statement) conexion.createStatement();
			consulta= (ResultSet) statement.executeQuery("select * from preguntajuego5");
			while(consulta.next())
			{
				preguntajuego5= new PreguntaJuego5();
				preguntajuego5.setId(Integer.parseInt(consulta.getString("id")));
				preguntajuego5.setOpcion1(consulta.getString("opcion1"));
				preguntajuego5.setOpcion2(consulta.getString("opcion2"));
				preguntajuego5.setOpcion3(consulta.getString("opcion3"));
				preguntajuego5.setOpcion4(consulta.getString("opcion4"));
				preguntajuego5.setOpcion5(consulta.getString("opcion5"));
				preguntajuego5.setOpcion6(consulta.getString("opcion6"));
				preguntajuego5.setPista1(consulta.getString("pista1"));
				preguntajuego5.setPista2(consulta.getString("pista2"));
				preguntajuego5.setPista3(consulta.getString("pista3"));
				preguntajuego5.setPista4(consulta.getString("pista4"));
				preguntajuego5.setPista5(consulta.getString("pista5"));
				preguntajuego5.setPista6(consulta.getString("pista6"));
				preguntajuego5.setRespuesta1(Integer.parseInt(consulta.getString("respuesta1")));
				preguntajuego5.setRespuesta2(Integer.parseInt(consulta.getString("respuesta2")));
				preguntajuego5.setRespuesta3(Integer.parseInt(consulta.getString("respuesta3")));
				preguntajuego5.setRespuesta4(Integer.parseInt(consulta.getString("respuesta4")));
				preguntajuego5.setRespuesta5(Integer.parseInt(consulta.getString("respuesta5")));
				preguntajuego5.setRespuesta6(Integer.parseInt(consulta.getString("respuesta6")));
				Preguntas.add(preguntajuego5);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Preguntas;
	}
	
	public void actualizarPuntos(Connection conexion, Usuario usuario)
	{
		PreparedStatement ps = null;
		//System.out.println("update usuario set puntos="+usuario.getPuntos()+" where nombre='"+usuario.getNombre()+"';");
		try {
			ps = (PreparedStatement) conexion.prepareStatement("update usuario set puntos="+usuario.getPuntos()+" where nombre='"+usuario.getNombre()+"';");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
