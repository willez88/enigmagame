package paneles;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import clases.ClaseComparacion;
import clases.Usuario;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Final extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8016320556055250653L;
	private ArrayList<Usuario> Usuarios;

	/**
	 * Create the panel.
	 * @param usuario 
	 * @param conexion 
	 */
	public Final(Connection conexion, Usuario usuario) {
		setBackground(Color.BLACK);
		setLayout(null);
		setSize(1366, 768);
		
		Usuarios= new ArrayList<Usuario>();
		Usuarios= cargarJugadores(conexion);
		Collections.sort(Usuarios, new ClaseComparacion());
		for (int i = 0; i < Usuarios.size(); i++) {
			System.out.println(Usuarios.get(i).getNombre());
		}
		
		JLabel labelTitulo = new JLabel("Top 5 de Jugadores");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTitulo.setForeground(Color.GREEN);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(556, 150, 200, 30);
		add(labelTitulo);
		
		JLabel label = new JLabel("1 "+Usuarios.get(0).getNombre()+ " -- "+Usuarios.get(0).getPuntos());
		label.setForeground(Color.WHITE);
		label.setBounds(400, 250, 500, 15);
		add(label);
		
		JLabel label_1 = new JLabel("2 "+Usuarios.get(1).getNombre()+ " -- "+Usuarios.get(1).getPuntos());
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(400, 313, 500, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("3 "+Usuarios.get(2).getNombre()+ " -- "+Usuarios.get(2).getPuntos());
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(400, 378, 500, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("4 "+Usuarios.get(3).getNombre()+ " -- "+Usuarios.get(3).getPuntos());
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(400, 453, 500, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("5 "+Usuarios.get(4).getNombre()+ " -- "+Usuarios.get(4).getPuntos());
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(400, 531, 500, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("Tu:");
		label_5.setForeground(Color.GREEN);
		label_5.setBounds(65, 250, 70, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("Nombre: "+usuario.getNombre());
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(65, 270, 150, 15);
		add(label_6);
		
		JLabel label_7 = new JLabel("Puntos: "+usuario.getPuntos());
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(65, 290, 150, 15);
		add(label_7);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conexion.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnSalir.setBounds(65, 700, 117, 25);
		add(btnSalir);
	}
	
	public ArrayList<Usuario> cargarJugadores(Connection conexion)
	{
		Usuario usuario;
		ArrayList<Usuario> Lista= new ArrayList<Usuario>();
		ResultSet consulta;
		Statement statement;
		try {
			statement = (Statement) conexion.createStatement();
			consulta= (ResultSet) statement.executeQuery("select * from usuario");
			while(consulta.next())
			{
				usuario= new Usuario();
				usuario.setNombre(consulta.getString("nombre"));
				usuario.setPuntos(Integer.parseInt(consulta.getString("puntos")));
				Lista.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Lista;
	}
}
