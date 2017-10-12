package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import clases.PreguntaJuego3;
import clases.Usuario;

import javax.swing.JTextField;

public class ModoDesafioJuego3 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4129320587162471866L;
	private ModoDesafioJuego4 panelModoDesafioJuego4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private ArrayList<PreguntaJuego3> Preguntas;

	/**
	 * Create the panel.
	 * @param usuario 
	 */
	public ModoDesafioJuego3(Connection conexion, String personaje, Usuario usuario) {
		setBackground(Color.BLACK);
		setLayout(null);
		//quitar al terminar
		setSize(1366, 768);
		
		Random r= new Random();
        r.setSeed(new Date().getTime());
		Preguntas= new ArrayList<PreguntaJuego3>();
		
		//se cargan todas las preguntas del juego3
		Preguntas= cargarPreguntasJuego3(conexion);
		
		//generar 3 numeros aleatorios no repetidos entre [0, Preguntas.size() )
		int vector []=new int [3];
		int num;
		for (int i = 0; i < vector.length; i++)
		{
			num= r.nextInt(Preguntas.size());
			for (int j = 0; j < i; j++)
			{
				if(vector[j]==num)
				{
					num= r.nextInt(Preguntas.size());
					j=-1;
				}
			}
			vector[i]= num;
		}
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(SeleccionarPersonaje.class.getResource(personaje)));
		btnNewButton.setBounds(65, 40, 200, 160);
		add(btnNewButton);
		
		JButton btnJuego_3 = new JButton("Juego 3");
		btnJuego_3.setEnabled(false);
		btnJuego_3.setBounds(756, 111, 89, 23);
		add(btnJuego_3);
		
		JButton btnJuego_4 = new JButton("Juego 4");
		btnJuego_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelModoDesafioJuego4= new ModoDesafioJuego4(conexion, personaje, usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoDesafioJuego4);
				panelModoDesafioJuego4.setLayout(null);
				panelModoDesafioJuego4.setSize(getWidth(), getHeight());
			}
		});
		btnJuego_4.setEnabled(false);
		btnJuego_4.setBounds(954, 111, 89, 23);
		add(btnJuego_4);
		
		JButton btnJuego_5 = new JButton("Juego 5");
		btnJuego_5.setEnabled(false);
		btnJuego_5.setBounds(1176, 111, 89, 23);
		add(btnJuego_5);
		
		JLabel labelTitulo = new JLabel("Note Pases");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTitulo.setForeground(Color.GREEN);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(556, 186, 200, 30);
		add(labelTitulo);
		
		JLabel label_1 = new JLabel("1) "+Preguntas.get(vector[0]).getPregunta());
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(262, 300, 700, 16);
		add(label_1);
		JLabel label_2 = new JLabel("2) "+Preguntas.get(vector[1]).getPregunta());
		JLabel label_3 = new JLabel("3) "+Preguntas.get(vector[2]).getPregunta());
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor= Integer.parseInt(textField_1.getText());
				if( (valor<=Preguntas.get(vector[0]).getRespuesta()) && (valor>=Preguntas.get(vector[0]).getRespuesta()-5) )
				{
					label_2.setVisible(true);
					textField_2.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+100);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 4.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_4.setEnabled(true);
				}
				textField_1.setEnabled(false);
			}
		});
		textField_1.setBounds(262, 340, 100, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		//JLabel label_2 = new JLabel("¿en que año llego el primer automovil a venezuela?");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(262, 400, 700, 16);
		add(label_2);
		label_2.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor= Integer.parseInt(textField_2.getText());
				if( (valor<=Preguntas.get(vector[1]).getRespuesta()) && (valor>=Preguntas.get(vector[1]).getRespuesta()-5) )
				{
					label_3.setVisible(true);
					textField_3.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+100);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 4.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_4.setEnabled(true);
				}
				textField_2.setEnabled(false);
			}
		});
		textField_2.setBounds(262, 440, 100, 19);
		add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		//JLabel label_3 = new JLabel("¿en que año fue fundada la fifa?");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(262, 500, 700, 16);
		add(label_3);
		label_3.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor= Integer.parseInt(textField_3.getText());
				if( (valor<=Preguntas.get(vector[2]).getRespuesta()) && (valor>=Preguntas.get(vector[2]).getRespuesta()-5) )
				{
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+300);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 4.\nPuntos Acumulados: "+usuario.getPuntos());
				}
				textField_3.setEnabled(false);
				btnJuego_4.setEnabled(true);
			}
		});
		textField_3.setBounds(262, 540, 100, 19);
		add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
	}
	
	public ArrayList<PreguntaJuego3> cargarPreguntasJuego3(Connection conexion)
	{
		PreguntaJuego3 preguntajuego3;
		ArrayList<PreguntaJuego3> Preguntas= new ArrayList<PreguntaJuego3>();
		ResultSet consulta;
		Statement statement;
		try {
			statement = (Statement) conexion.createStatement();
			consulta= (ResultSet) statement.executeQuery("select * from preguntajuego3");
			while(consulta.next())
			{
				preguntajuego3= new PreguntaJuego3();
				preguntajuego3.setId(Integer.parseInt(consulta.getString("id")));
				preguntajuego3.setPregunta(consulta.getString("pregunta"));
				preguntajuego3.setRespuesta(Integer.parseInt(consulta.getString("respuesta")));
				Preguntas.add(preguntajuego3);
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
