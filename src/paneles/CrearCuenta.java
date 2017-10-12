package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import clases.Usuario;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class CrearCuenta extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8589282460586222358L;
	private JTextField textField;
	private JPasswordField passwordField;
	private SeleccionarPersonaje panelSeleccionarPersonaje;
	private Usuario usuario;

	/**
	 * Create the panel.
	 * @param contentPane
	 * @param conexion 
	 */
	public CrearCuenta(JPanel contentPane, Connection conexion) {
		setBackground(Color.BLACK);
		
		setLayout(null);
		//quitar al terminar
		setSize(1366, 768);
		
		usuario= new Usuario();
		JLabel lblNewLabel = new JLabel("Registro de Usuario");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(662, 37, 204, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(590, 188, 140, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(757, 187, 130, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(590, 244, 110, 14);
		add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(756, 241, 131, 20);
		add(passwordField);
		
		JButton btnNewButton = new JButton("Crear Cuenta");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Statement statement;
				try {
					usuario.setNombre(textField.getText());
					usuario.setClave(passwordField.getText());
					usuario.setPuntos(0);
					statement = (Statement) conexion.createStatement();
					//System.out.println("insert into usuario values('"+usuario.getNombre()+"','"+usuario.getClave()+"','"+0+"');");
					statement.execute("insert into usuario values('"+usuario.getNombre()+"','"+usuario.getClave()+"','"+usuario.getPuntos()+"');");
					JOptionPane.showMessageDialog(null, "Cuenta creada!!!");
					panelSeleccionarPersonaje= new SeleccionarPersonaje(contentPane, conexion, usuario);
					remove(getRootPane());
					getRootPane().setContentPane(panelSeleccionarPersonaje);
					panelSeleccionarPersonaje.setLayout(null);
					panelSeleccionarPersonaje.setSize(getWidth(), getHeight());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Cuenta no creada: "+e.getMessage());
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(590, 451, 110, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Para volver al panel principal
				remove(getRootPane());
				getRootPane().setContentPane(contentPane);
			}
		});
		btnNewButton_1.setBounds(757, 451, 89, 23);
		add(btnNewButton_1);

	}
}
