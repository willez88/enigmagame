package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.Usuario;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ModoJuego extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2470106090156278114L;
	private SeleccionarPersonaje panelSeleccionarPersonaje;
	private ModoDesafio panelModoDesafio;
	private ModoTablero panelModoTablero;

	/**
	 * Create the panel.
	 * @param conexion 
	 * @param contentPane 
	 * @param usuario 
	 */
	public ModoJuego(JPanel contentPane, Connection conexion, String personaje, Usuario usuario) {
		setBackground(Color.BLACK);
		setLayout(null);
		setSize(1366, 768);
		
		JLabel lblNewLabel = new JLabel("Seleccione  Modo de Juego");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(468, 11, 368, 56);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelModoTablero= new ModoTablero(contentPane, conexion, personaje, usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoTablero);
				panelModoTablero.setLayout(null);
				panelModoTablero.setSize(getWidth(), getHeight());
			}
		});
		btnNewButton.setIcon(new ImageIcon(ModoJuego.class.getResource("/imagenes/tablero.jpg")));
		btnNewButton.setToolTipText("Tablebro");
		btnNewButton.setBounds(370, 264, 200, 200);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Desafío");
		btnNewButton_1.setIcon(new ImageIcon(ModoJuego.class.getResource("/imagenes/desafio.jpg")));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelModoDesafio= new ModoDesafio(contentPane, conexion, personaje, usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoDesafio);
				panelModoDesafio.setLayout(null);
				panelModoDesafio.setSize(getWidth(), getHeight());
			}
		});
		btnNewButton_1.setBounds(770, 264, 200, 200);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//regresar al panel de Seleccionar Personaje
				panelSeleccionarPersonaje= new SeleccionarPersonaje(contentPane, conexion, usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelSeleccionarPersonaje);
				panelSeleccionarPersonaje.setLayout(null);
				panelSeleccionarPersonaje.setSize(getWidth(), getHeight());
			}
		});
		btnNewButton_2.setBounds(612, 532, 89, 23);
		add(btnNewButton_2);

	}

}
