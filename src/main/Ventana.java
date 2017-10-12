package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paneles.Login;
import paneles.CrearCuenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3350912854285590648L;
	private JPanel contentPane;
	private CrearCuenta panelCrearCuenta;
	private Login panelLogin;
	Connection conexion= null;
	
	public Image imagenFondo;
	public URL fondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		
		//dim= getToolkit().getScreenSize();
        //setSize(dim);
		
		//setExtendedState(MAXIMIZED_BOTH);
		//setBounds(0, 0, getWidth(), getHeight());
		try
		{
			DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
			//modificar parametros (usuario y clave) correspondiente a su mysql
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/enigma","root", "");
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
			e.printStackTrace();
		}
		
		fondo= getClass().getResource("/imagenes/enigma.jpg");
		imagenFondo= new ImageIcon(fondo).getImage();
		
		contentPane = new JPanel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 4180330360153298626L;

			@Override
			public void paintComponent(Graphics g)
			{
					g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENIGMA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(537, 417, 248, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Crear Cuenta");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//ir al panel de registrar usuario
				panelCrearCuenta= new CrearCuenta(contentPane, conexion);
				contentPane.remove(getRootPane());
				getRootPane().setContentPane(panelCrearCuenta);
				panelCrearCuenta.setLayout(null);
				//panelCrearCuenta.setSize(700, 424);
				panelCrearCuenta.setSize(getWidth(),getHeight());
				System.out.println(getWidth()+" -- "+getHeight());
			}
		});
		btnNewButton.setBounds(605, 493, 127, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ir al panel del login
				panelLogin= new Login(contentPane, conexion);
				contentPane.remove(getRootPane());
				getRootPane().setContentPane(panelLogin);
				panelLogin.setLayout(null);
				//panelLogin.setSize(700, 424);
				panelLogin.setSize(getWidth(),getHeight());
			}
		});
		btnNewButton_1.setBounds(605, 546, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
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
		btnNewButton_2.setBounds(605, 591, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
