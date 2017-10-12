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

import clases.PreguntaJuego4;
import clases.Usuario;

import javax.swing.JRadioButton;

public class ModoDesafioJuego4 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3961998773931131352L;
	private ModoDesafioJuego5 panelModoDesafioJuego5;
	private ArrayList<PreguntaJuego4> Preguntas;
	/**
	 * Create the panel.
	 * @param usuario 
	 */
	public ModoDesafioJuego4(Connection conexion, String personaje, Usuario usuario) {
		setBackground(Color.BLACK);
		setLayout(null);
		//quitar al terminar
		setSize(1366, 768);
		
		Random r= new Random();
        r.setSeed(new Date().getTime());
		Preguntas= new ArrayList<PreguntaJuego4>();
		
		//se cargan todas las preguntas del juego4
		Preguntas= cargarPreguntasJuego4(conexion);
		
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
		
		JButton btnJuego_4 = new JButton("Juego 4");
		btnJuego_4.setEnabled(false);
		btnJuego_4.setBounds(954, 111, 89, 23);
		add(btnJuego_4);
		
		JButton btnJuego_5 = new JButton("Juego 5");
		btnJuego_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelModoDesafioJuego5= new ModoDesafioJuego5(conexion, personaje, usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoDesafioJuego5);
				panelModoDesafioJuego5.setLayout(null);
				panelModoDesafioJuego5.setSize(getWidth(), getHeight());
			}
		});
		btnJuego_5.setEnabled(false);
		btnJuego_5.setBounds(1176, 111, 89, 23);
		add(btnJuego_5);
		
		JLabel labelTitulo = new JLabel("El Reto");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTitulo.setForeground(Color.GREEN);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(556, 186, 200, 30);
		add(labelTitulo);
		
		JLabel label_1 = new JLabel("1) "+Preguntas.get(vector[0]).getPregunta());
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(65, 270, 700, 16);
		add(label_1);
		JLabel label_2 = new JLabel("2) "+Preguntas.get(vector[1]).getPregunta());
		JLabel label_3 = new JLabel("3) "+Preguntas.get(vector[2]).getPregunta());
		
		//opciones 1
		JRadioButton rdbtn_1a = new JRadioButton(Preguntas.get(vector[0]).getOpcion1());
		JRadioButton rdbtn_2a = new JRadioButton(Preguntas.get(vector[0]).getOpcion2());
		JRadioButton rdbtn_3a = new JRadioButton(Preguntas.get(vector[0]).getOpcion3());
		JRadioButton rdbtn_4a = new JRadioButton(Preguntas.get(vector[0]).getOpcion4());
		//opciones 2
		JRadioButton rdbtn_1b = new JRadioButton(Preguntas.get(vector[1]).getOpcion1());
		JRadioButton rdbtn_2b = new JRadioButton(Preguntas.get(vector[1]).getOpcion2());
		JRadioButton rdbtn_3b = new JRadioButton(Preguntas.get(vector[1]).getOpcion3());
		JRadioButton rdbtn_4b = new JRadioButton(Preguntas.get(vector[1]).getOpcion4());
		//opciones 3
		JRadioButton rdbtn_1c = new JRadioButton(Preguntas.get(vector[2]).getOpcion1());
		JRadioButton rdbtn_2c = new JRadioButton(Preguntas.get(vector[2]).getOpcion2());
		JRadioButton rdbtn_3c = new JRadioButton(Preguntas.get(vector[2]).getOpcion3());
		JRadioButton rdbtn_4c = new JRadioButton(Preguntas.get(vector[2]).getOpcion4());
		
		//JRadioButton rdbtn_1a = new JRadioButton("Halcon Africano");
		rdbtn_1a.setBounds(65, 300, 160, 23);
		rdbtn_1a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(1==Preguntas.get(vector[0]).getRespuesta())
				{
					//se habilita la segunda pregunta
					label_2.setVisible(true);
					rdbtn_1b.setVisible(true);
					rdbtn_2b.setVisible(true);
					rdbtn_3b.setVisible(true);
					rdbtn_4b.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1a.setSelected(true);
				rdbtn_2a.setSelected(false);
				rdbtn_3a.setSelected(false);
				rdbtn_4a.setSelected(false);
				
				rdbtn_1a.setEnabled(false);
				rdbtn_2a.setEnabled(false);
				rdbtn_3a.setEnabled(false);
				rdbtn_4a.setEnabled(false);
			}
		});
		add(rdbtn_1a);
		
		//JRadioButton rdbtn_2 = new JRadioButton("Cocodrilo Asiatico");
		rdbtn_2a.setBounds(315, 300, 160, 23);
		rdbtn_2a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(2==Preguntas.get(vector[0]).getRespuesta())
				{
					//se habilita la 2da pregunta
					label_2.setVisible(true);
					rdbtn_1b.setVisible(true);
					rdbtn_2b.setVisible(true);
					rdbtn_3b.setVisible(true);
					rdbtn_4b.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1a.setSelected(false);
				rdbtn_2a.setSelected(true);
				rdbtn_3a.setSelected(false);
				rdbtn_4a.setSelected(false);
				
				rdbtn_1a.setEnabled(false);
				rdbtn_2a.setEnabled(false);
				rdbtn_3a.setEnabled(false);
				rdbtn_4a.setEnabled(false);
			}
		});
		add(rdbtn_2a);
		
		//JRadioButton rdbtn_3 = new JRadioButton("Pez Abisal");
		rdbtn_3a.setBounds(565, 300, 160, 23);
		rdbtn_3a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(3==Preguntas.get(vector[0]).getRespuesta())
				{
					//sigue a la siguiente pregunta
					label_2.setVisible(true);
					rdbtn_1b.setVisible(true);
					rdbtn_2b.setVisible(true);
					rdbtn_3b.setVisible(true);
					rdbtn_4b.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1a.setSelected(false);
				rdbtn_2a.setSelected(false);
				rdbtn_3a.setSelected(true);
				rdbtn_4a.setSelected(false);
				
				rdbtn_1a.setEnabled(false);
				rdbtn_2a.setEnabled(false);
				rdbtn_3a.setEnabled(false);
				rdbtn_4a.setEnabled(false);
			}
		});
		add(rdbtn_3a);
		
		//JRadioButton rdbtn_4 = new JRadioButton("Sapo Gigante");
		rdbtn_4a.setBounds(815, 300, 160, 23);
		rdbtn_4a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(4==Preguntas.get(vector[0]).getRespuesta())
				{
					//sigue a la siguiente pregunta
					label_2.setVisible(true);
					rdbtn_1b.setVisible(true);
					rdbtn_2b.setVisible(true);
					rdbtn_3b.setVisible(true);
					rdbtn_4b.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1a.setSelected(false);
				rdbtn_2a.setSelected(false);
				rdbtn_3a.setSelected(false);
				rdbtn_4a.setSelected(true);
				
				rdbtn_1a.setEnabled(false);
				rdbtn_2a.setEnabled(false);
				rdbtn_3a.setEnabled(false);
				rdbtn_4a.setEnabled(false);
			}
		});
		add(rdbtn_4a);
		
		//JLabel label_2 = new JLabel("2) ¿Como se llama la luna de pluton?");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(65, 350, 700, 16);
		add(label_2);
		label_2.setVisible(false);
		
		//JRadioButton rdbtn_1b = new JRadioButton("Caronte");
		rdbtn_1b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(1==Preguntas.get(vector[1]).getRespuesta())
				{
					//pasa a la siguiente pregunta
					label_3.setVisible(true);
					rdbtn_1c.setVisible(true);
					rdbtn_2c.setVisible(true);
					rdbtn_3c.setVisible(true);
					rdbtn_4c.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1b.setSelected(true);
				rdbtn_2b.setSelected(false);
				rdbtn_3b.setSelected(false);
				rdbtn_4b.setSelected(false);
				
				rdbtn_1b.setEnabled(true);
				rdbtn_2b.setEnabled(false);
				rdbtn_3b.setEnabled(false);
				rdbtn_4b.setEnabled(false);
			}
		});
		rdbtn_1b.setBounds(65, 380, 160, 23);
		add(rdbtn_1b);
		rdbtn_1b.setVisible(false);
		
		//JRadioButton rdbtn_2b = new JRadioButton("Tetis");
		rdbtn_2b.setBounds(315, 380, 160, 23);
		rdbtn_2b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(2==Preguntas.get(vector[1]).getRespuesta())
				{
					//pasa a la siguiente pregunta
					label_3.setVisible(true);
					rdbtn_1c.setVisible(true);
					rdbtn_2c.setVisible(true);
					rdbtn_3c.setVisible(true);
					rdbtn_4c.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1b.setSelected(false);
				rdbtn_2b.setSelected(true);
				rdbtn_3b.setSelected(false);
				rdbtn_4b.setSelected(false);
				
				rdbtn_1b.setEnabled(false);
				rdbtn_2b.setEnabled(false);
				rdbtn_3b.setEnabled(false);
				rdbtn_4b.setEnabled(false);
			}
		});
		add(rdbtn_2b);
		rdbtn_2b.setVisible(false);
		
		//JRadioButton rdbtn_3b = new JRadioButton("IO");
		rdbtn_3b.setBounds(565, 380, 160, 23);
		rdbtn_3b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(3==Preguntas.get(vector[1]).getRespuesta())
				{
					//pasa a la siguiente pregunta
					label_3.setVisible(true);
					rdbtn_1c.setVisible(true);
					rdbtn_2c.setVisible(true);
					rdbtn_3c.setVisible(true);
					rdbtn_4c.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1b.setSelected(false);
				rdbtn_2b.setSelected(false);
				rdbtn_3b.setSelected(true);
				rdbtn_4b.setSelected(false);
				
				rdbtn_1b.setEnabled(false);
				rdbtn_2b.setEnabled(false);
				rdbtn_3b.setEnabled(false);
				rdbtn_4b.setEnabled(false);
			}
		});
		add(rdbtn_3b);
		rdbtn_3b.setVisible(false);
		
		//JRadioButton rdbtn_4b = new JRadioButton("Titania");
		rdbtn_4b.setBounds(815, 380, 149, 23);
		rdbtn_4b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(4==Preguntas.get(vector[1]).getRespuesta())
				{
					//pasa a la siguiente pregunta
					label_3.setVisible(true);
					rdbtn_1c.setVisible(true);
					rdbtn_2c.setVisible(true);
					rdbtn_3c.setVisible(true);
					rdbtn_4c.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1b.setSelected(false);
				rdbtn_2b.setSelected(false);
				rdbtn_3b.setSelected(false);
				rdbtn_4b.setSelected(true);
				
				rdbtn_1b.setEnabled(false);
				rdbtn_2b.setEnabled(false);
				rdbtn_3b.setEnabled(false);
				rdbtn_4b.setEnabled(false);
			}
		});
		add(rdbtn_4b);
		rdbtn_4b.setVisible(false);
		
		//JLabel label_3 = new JLabel("3) ¿En que atolon se probo la bomba H?");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(65, 430, 700, 16);
		add(label_3);
		label_3.setVisible(false);
		
		//JRadioButton rdbtn_1c = new JRadioButton("Muroroa");
		rdbtn_1c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(1==Preguntas.get(vector[2]).getRespuesta())
				{
					btnJuego_5.setEnabled(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1c.setSelected(true);
				rdbtn_2c.setSelected(false);
				rdbtn_3c.setSelected(false);
				rdbtn_4c.setSelected(false);
				
				rdbtn_1c.setEnabled(false);
				rdbtn_2c.setEnabled(false);
				rdbtn_3c.setEnabled(false);
				rdbtn_4c.setEnabled(false);
			}
		});
		rdbtn_1c.setBounds(65, 460, 160, 23);
		add(rdbtn_1c);
		rdbtn_1c.setVisible(false);
		
		//JRadioButton rdbtn_2c = new JRadioButton("Eniwetok");
		rdbtn_2c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(2==Preguntas.get(vector[2]).getRespuesta())
				{
					btnJuego_5.setEnabled(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1c.setSelected(false);
				rdbtn_2c.setSelected(true);
				rdbtn_3c.setSelected(false);
				rdbtn_4c.setSelected(false);
				
				rdbtn_1c.setEnabled(false);
				rdbtn_2c.setEnabled(false);
				rdbtn_3c.setEnabled(false);
				rdbtn_4c.setEnabled(false);
			}
		});
		rdbtn_2c.setBounds(315, 460, 160, 23);
		add(rdbtn_2c);
		rdbtn_2c.setVisible(false);
		
		//JRadioButton rdbtn_3c = new JRadioButton("Ross");
		rdbtn_3c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(3==Preguntas.get(vector[2]).getRespuesta())
				{
					btnJuego_5.setEnabled(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1c.setSelected(false);
				rdbtn_2c.setSelected(false);
				rdbtn_3c.setSelected(true);
				rdbtn_4c.setSelected(false);
				
				rdbtn_1c.setEnabled(false);
				rdbtn_2c.setEnabled(false);
				rdbtn_3c.setEnabled(false);
				rdbtn_4c.setEnabled(false);
			}
		});
		rdbtn_3c.setBounds(565, 460, 160, 23);
		add(rdbtn_3c);
		rdbtn_3c.setVisible(false);
		
		//JRadioButton rdbtn_4c = new JRadioButton("Bikini");
		rdbtn_4c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(4==Preguntas.get(vector[2]).getRespuesta())
				{
					btnJuego_5.setEnabled(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+150);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 5.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_5.setEnabled(true);
				}
				rdbtn_1c.setSelected(false);
				rdbtn_2c.setSelected(false);
				rdbtn_3c.setSelected(false);
				rdbtn_4c.setSelected(true);
				
				rdbtn_1c.setEnabled(false);
				rdbtn_2c.setEnabled(false);
				rdbtn_3c.setEnabled(false);
				rdbtn_4c.setEnabled(false);
			}
		});
		rdbtn_4c.setBounds(815, 460, 160, 23);
		add(rdbtn_4c);
		rdbtn_4c.setVisible(false);
	}
	
	public ArrayList<PreguntaJuego4> cargarPreguntasJuego4(Connection conexion)
	{
		PreguntaJuego4 preguntajuego4;
		ArrayList<PreguntaJuego4> Preguntas= new ArrayList<PreguntaJuego4>();
		ResultSet consulta;
		Statement statement;
		try {
			statement = (Statement) conexion.createStatement();
			consulta= (ResultSet) statement.executeQuery("select * from preguntajuego4");
			while(consulta.next())
			{
				preguntajuego4= new PreguntaJuego4();
				preguntajuego4.setId(Integer.parseInt(consulta.getString("id")));
				preguntajuego4.setPregunta(consulta.getString("pregunta"));
				preguntajuego4.setOpcion1(consulta.getString("opcion1"));
				preguntajuego4.setOpcion2(consulta.getString("opcion2"));
				preguntajuego4.setOpcion3(consulta.getString("opcion3"));
				preguntajuego4.setOpcion4(consulta.getString("opcion4"));
				preguntajuego4.setRespuesta(Integer.parseInt(consulta.getString("respuesta")));
				Preguntas.add(preguntajuego4);
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
