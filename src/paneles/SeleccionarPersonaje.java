package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class SeleccionarPersonaje extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7265741831160288163L;
	private ModoJuego panelModoJuego;

	/**
	 * Create the panel.
	 * @param contentPane 
	 * @param conexion 
	 * @param usuario 
	 */
	public SeleccionarPersonaje(JPanel contentPane, Connection conexion, Usuario usuario) {
		setBackground(Color.BLACK);
		setLayout(null);
		String Personajes[]= new String[6];
		Personajes[0]= "/imagenes/colibri.jpg";
		Personajes[1]= "/imagenes/delfin.jpg";
		Personajes[2]= "/imagenes/elefante.jpg";
		Personajes[3]= "/imagenes/Cuervo1.jpg";
		Personajes[4]= "/imagenes/pulpo.jpg";
		Personajes[5]= "/imagenes/tortuga.jpg";
		
		JLabel lblNewLabel = new JLabel("Selecciona un Personaje");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(512, 11, 276, 31);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Colibr\u00ED");
		btnNewButton.setIcon(new ImageIcon(SeleccionarPersonaje.class.getResource("/imagenes/colibri.jpg")));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//luego de elegir un personaje, se va al panel de seleccionar el modo de juego
				panelModoJuego= new ModoJuego(contentPane, conexion, Personajes[0], usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoJuego);
				panelModoJuego.setLayout(null);
				panelModoJuego.setSize(getWidth(), getHeight());
			}
		});
		btnNewButton.setBounds(51, 77, 200, 160);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Delf\u00EDn");
		btnNewButton_1.setIcon(new ImageIcon(SeleccionarPersonaje.class.getResource("/imagenes/delfin.jpg")));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//luego de elegir un personaje, se va al panel de seleccionar el modo de juego
				panelModoJuego= new ModoJuego(contentPane, conexion, Personajes[1], usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoJuego);
				panelModoJuego.setLayout(null);
				panelModoJuego.setSize(getWidth(), getHeight());
			}
		});
		btnNewButton_1.setBounds(543, 77, 200, 160);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//luego de elegir un personaje, se va al panel de seleccionar el modo de juego
				panelModoJuego= new ModoJuego(contentPane, conexion, Personajes[2], usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoJuego);
				panelModoJuego.setLayout(null);
				panelModoJuego.setSize(getWidth(), getHeight());
			}
		});
		btnNewButton_2.setToolTipText("Elefante");
		btnNewButton_2.setIcon(new ImageIcon(SeleccionarPersonaje.class.getResource("/imagenes/elefante.jpg")));
		btnNewButton_2.setBounds(1033, 77, 200, 160);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//luego de elegir un personaje, se va al panel de seleccionar el modo de juego
				panelModoJuego= new ModoJuego(contentPane, conexion, Personajes[3], usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoJuego);
				panelModoJuego.setLayout(null);
				panelModoJuego.setSize(getWidth(), getHeight());
			}
		});
		btnNewButton_3.setToolTipText("Cuervo");
		btnNewButton_3.setIcon(new ImageIcon(SeleccionarPersonaje.class.getResource("/imagenes/Cuervo1.jpg")));
		btnNewButton_3.setBounds(51, 326, 200, 160);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//luego de elegir un personaje, se va al panel de seleccionar el modo de juego
				panelModoJuego= new ModoJuego(contentPane, conexion, Personajes[4], usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoJuego);
				panelModoJuego.setLayout(null);
				panelModoJuego.setSize(getWidth(), getHeight());
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(SeleccionarPersonaje.class.getResource("/imagenes/pulpo.jpg")));
		btnNewButton_4.setToolTipText("Pulpo");
		btnNewButton_4.setBounds(543, 326, 202, 159);
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//luego de elegir un personaje, se va al panel de seleccionar el modo de juego
				panelModoJuego= new ModoJuego(contentPane, conexion, Personajes[5], usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoJuego);
				panelModoJuego.setLayout(null);
				panelModoJuego.setSize(getWidth(), getHeight());
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(SeleccionarPersonaje.class.getResource("/imagenes/tortuga.jpg")));
		btnNewButton_5.setToolTipText("Tortuga Gigante");
		btnNewButton_5.setBounds(1033, 326, 200, 162);
		add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Volver");
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//regresar al menu principal
				remove(getRootPane());
				getRootPane().setContentPane(contentPane);
			}
		});
		btnNewButton_6.setBounds(582, 582, 89, 23);
		add(btnNewButton_6);

	}

}
