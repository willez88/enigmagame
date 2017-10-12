package paneles;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import clases.PreguntaJuego2;
import clases.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModoDesafioJuego2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5362708695747579332L;
	private ModoDesafioJuego3 panelModoDesafioJuego3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private ArrayList<PreguntaJuego2> Preguntas;

	/**
	 * Create the panel.
	 * @param personaje 
	 * @param conexion 
	 * @param usuario 
	 */
	public ModoDesafioJuego2(Connection conexion, String personaje, Usuario usuario) {
		setBackground(Color.BLACK);
		setLayout(null);
		//quitar al terminar
		setSize(1366, 768);
		
		Random r= new Random();
        r.setSeed(new Date().getTime());
		Preguntas= new ArrayList<PreguntaJuego2>();
		
		//se cargan todas las preguntas del juego2
		Preguntas= cargarPreguntasJuego2(conexion);
		
		//generar 6 numeros aleatorios no repetidos entre [0, Preguntas.size() )
		int vector []=new int [6];
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
		
		JButton btnJuego_2 = new JButton("Juego 2");
		btnJuego_2.setEnabled(false);
		btnJuego_2.setBounds(556, 111, 89, 23);
		add(btnJuego_2);
		
		JButton btnJuego_3 = new JButton("Juego 3");
		btnJuego_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelModoDesafioJuego3= new ModoDesafioJuego3(conexion, personaje, usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoDesafioJuego3);
				panelModoDesafioJuego3.setLayout(null);
				panelModoDesafioJuego3.setSize(getWidth(), getHeight());
			}
		});
		btnJuego_3.setEnabled(false);
		btnJuego_3.setBounds(756, 111, 89, 23);
		add(btnJuego_3);
		
		JButton btnJuego_4 = new JButton("Juego 4");
		btnJuego_4.setEnabled(false);
		btnJuego_4.setBounds(954, 111, 89, 23);
		add(btnJuego_4);
		
		JButton btnJuego_5 = new JButton("Juego 5");
		btnJuego_5.setEnabled(false);
		btnJuego_5.setBounds(1176, 111, 89, 23);
		add(btnJuego_5);
		
		JLabel labelTitulo = new JLabel("El Pequeño Gran Minuto");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTitulo.setForeground(Color.GREEN);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(556, 186, 200, 30);
		add(labelTitulo);
		
		JLabel label_1 = new JLabel("1) "+Preguntas.get(vector[0]).getPregunta());
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(260, 270, 700, 16);
		add(label_1);
		JLabel label_2 = new JLabel("2) "+Preguntas.get(vector[1]).getPregunta());
		JLabel label_3 = new JLabel("3) "+Preguntas.get(vector[2]).getPregunta());
		JLabel label_4 = new JLabel("4) "+Preguntas.get(vector[3]).getPregunta());
		JLabel label_5 = new JLabel("5) "+Preguntas.get(vector[4]).getPregunta());
		JLabel label_6 = new JLabel("6) "+Preguntas.get(vector[5]).getPregunta());
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (textField_1.getText().equals(Preguntas.get(vector[0]).getRespuesta()))
				{
					label_2.setVisible(true);
					textField_2.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+50);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 3.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_3.setEnabled(true);
				}
				textField_1.setEnabled(false);
			}
		});
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(260, 300, 150, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		//JLabel label_2 = new JLabel("2) \u00BFC\u00FAal es el volcan mas activo del mundo?");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(260, 350, 700, 16);
		add(label_2);
		label_2.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().equals(Preguntas.get(vector[1]).getRespuesta()))
				{
					label_3.setVisible(true);
					textField_3.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+100);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 3.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_3.setEnabled(true);
				}
				textField_2.setEnabled(false);
			}
		});
		textField_2.setBounds(260, 380, 150, 20);
		add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		//JLabel label_3 = new JLabel("3) \u00BFC\u00F3mo se llama nuestra galaxia?");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(260, 430, 700, 16);
		add(label_3);
		label_3.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_3.getText().equals(Preguntas.get(vector[2]).getRespuesta()))
				{
					label_4.setVisible(true);
					textField_4.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+200);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 3.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_3.setEnabled(true);
				}
				textField_3.setEnabled(false);
			}
		});
		textField_3.setBounds(260, 460, 150, 20);
		add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		
		//JLabel label_4 = new JLabel("4) \u00BFque es la aurora boreal?");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(260, 510, 700, 16);
		add(label_4);
		label_4.setVisible(false);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_4.getText().equals(Preguntas.get(vector[3]).getRespuesta()))
				{
					label_5.setVisible(true);
					textField_5.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+400);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 3.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_3.setEnabled(true);
				}
				textField_4.setEnabled(false);
			}
		});
		textField_4.setBounds(260, 540, 150, 20);
		add(textField_4);
		textField_4.setColumns(10);
		textField_4.setVisible(false);
		
		//JLabel label_5 = new JLabel("5) \u00BFC\u00FAal es el r\u00EDo m\u00E1s largo del mundo?");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(260, 590, 700, 16);
		add(label_5);
		label_5.setVisible(false);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_5.getText().equals(Preguntas.get(vector[4]).getRespuesta()))
				{
					label_6.setVisible(true);
					textField_6.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+800);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 3.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_3.setEnabled(true);
				}
				textField_5.setEnabled(false);
			}
		});
		textField_5.setBounds(260, 620, 150, 20);
		add(textField_5);
		textField_5.setColumns(10);
		textField_5.setVisible(false);
		
		//JLabel label_6 = new JLabel("6) \u00BFA qu\u00E9 pa\u00EDs pertenesen las gal\u00E1pagos?");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(260, 670, 700, 16);
		add(label_6);
		label_6.setVisible(false);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_6.getText().equals(Preguntas.get(vector[5]).getRespuesta()))
				{
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+1600);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 3.\nPuntos Acumulados: "+usuario.getPuntos());
					//btnJuego_3.setEnabled(true);
				}
				textField_6.setEnabled(false);
				btnJuego_3.setEnabled(true);
			}
		});
		textField_6.setBounds(260, 700, 150, 20);
		add(textField_6);
		textField_6.setColumns(10);
		textField_6.setVisible(false);
		
		JLabel labelTiempo = new JLabel("Tiempo:");
		labelTiempo.setForeground(Color.WHITE);
		labelTiempo.setBounds(954, 302, 60, 15);
		add(labelTiempo);
		
		JLabel label_Cronometro = new JLabel("");
		label_Cronometro.setForeground(Color.WHITE);
		label_Cronometro.setBounds(1025, 305, 70, 15);
		add(label_Cronometro);
		
		Timer timer;
	    timer = new Timer();

	    TimerTask task = new TimerTask() {
	        int seg=60;
	        @Override
	        public void run()
	        {
	            if(seg==0)
	            {
	            	timer.cancel();
	            	actualizarPuntos(conexion, usuario);
	            	textField_1.setEnabled(false);
	            	textField_2.setEnabled(false);
	            	textField_3.setEnabled(false);
	            	textField_4.setEnabled(false);
	            	textField_5.setEnabled(false);
	            	textField_6.setEnabled(false);
	            	btnJuego_3.setEnabled(true);
	            }
	            label_Cronometro.setText(Integer.toString(seg));
	            seg--;
	        }
	        };
	        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
	    timer.schedule(task, 10, 1000);
	    }
	
	public ArrayList<PreguntaJuego2> cargarPreguntasJuego2(Connection conexion)
	{
		PreguntaJuego2 preguntajuego2;
		ArrayList<PreguntaJuego2> Preguntas= new ArrayList<PreguntaJuego2>();
		ResultSet consulta;
		Statement statement;
		try {
			statement = (Statement) conexion.createStatement();
			consulta= (ResultSet) statement.executeQuery("select * from preguntajuego2");
			while(consulta.next())
			{
				preguntajuego2= new PreguntaJuego2();
				preguntajuego2.setId(Integer.parseInt(consulta.getString("id")));
				preguntajuego2.setPregunta(consulta.getString("pregunta"));
				preguntajuego2.setRespuesta(consulta.getString("respuesta"));
				Preguntas.add(preguntajuego2);
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
