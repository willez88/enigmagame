package paneles;

import javax.swing.JPanel;

import clases.Usuario;

import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class ModoDesafio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6338848729426380849L;
	private ModoDesafioJuego1 panelModoDesafioJuego1;

	/**
	 * Create the panel.
	 * @param personaje 
	 * @param conexion 
	 * @param contentPane 
	 * @param usuario 
	 */
	public ModoDesafio(JPanel contentPane, Connection conexion, String personaje, Usuario usuario) {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(SeleccionarPersonaje.class.getResource(personaje)));
		btnNewButton.setBounds(65, 40, 200, 160);
		add(btnNewButton);
		
		JButton btnJuego = new JButton("Juego 1");
		btnJuego.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelModoDesafioJuego1= new ModoDesafioJuego1(conexion, personaje, usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoDesafioJuego1);
				panelModoDesafioJuego1.setLayout(null);
				panelModoDesafioJuego1.setSize(getWidth(), getHeight());
			}
		});
		btnJuego.setBounds(363, 111, 89, 23);
		add(btnJuego);
		
		JButton btnJuego_1 = new JButton("Juego 2");
		btnJuego_1.setBounds(556, 111, 89, 23);
		add(btnJuego_1);
		
		JButton btnJuego_2 = new JButton("Juego 3");
		btnJuego_2.setBounds(756, 111, 89, 23);
		add(btnJuego_2);
		
		JButton btnJuego_3 = new JButton("Juego 4");
		btnJuego_3.setBounds(954, 111, 89, 23);
		add(btnJuego_3);
		
		JButton btnJuego_4 = new JButton("Juego 5");
		btnJuego_4.setBounds(1176, 111, 89, 23);
		add(btnJuego_4);

	}
}
