package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import clases.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5383492159681021137L;
	private SeleccionarPersonaje panelSeleccionarPersonaje;
	private JTextField textField;
	private JPasswordField passwordField;
	private Usuario usuario;

	/**
	 * Create the panel.
	 * @param contentPane 
	 * @param conexion 
	 */
	public Login(JPanel contentPane, Connection conexion) {
		setBackground(Color.BLACK);
		setLayout(null);
		setSize(1366, 768);
		
		usuario= new Usuario();
		JLabel lblNewLabel = new JLabel("Iniciar Sesión");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(599, 117, 161, 46);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(375, 344, 223, 23);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(637, 349, 100, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setBounds(375, 399, 223, 23);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Conectarse");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				usuario.setNombre(textField.getText());
				usuario.setClave(passwordField.getText());
				try
				{
					Statement statement= (Statement) conexion.createStatement();
					ResultSet consulta= (ResultSet) statement.executeQuery("select nombre,clave,puntos from usuario where nombre='"+usuario.getNombre()+"'");
					if(consulta.next())
					{
						if( consulta.getString("nombre").equals(usuario.getNombre()) && consulta.getString("clave").equals(usuario.getClave()) )
						{
							usuario.setPuntos(Integer.parseInt(consulta.getString("puntos")));
							System.out.println(usuario.getPuntos());
							panelSeleccionarPersonaje= new SeleccionarPersonaje(contentPane, conexion, usuario);
							remove(getRootPane());
							getRootPane().setContentPane(panelSeleccionarPersonaje);
							panelSeleccionarPersonaje.setLayout(null);
							panelSeleccionarPersonaje.setSize(getWidth(), getHeight());
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No existe el usuario.");
							textField.setText("");
							passwordField.setText("");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No existe el usuario.");
					}
					statement.close();
					//consulta.close();
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error "+e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(623, 498, 114, 23);
		add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(637, 404, 100, 20);
		add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//regresar al menu principal
				remove(getRootPane());
				getRootPane().setContentPane(contentPane);
			}
		});
		btnNewButton_1.setBounds(850, 498, 89, 23);
		add(btnNewButton_1);

	}
}
