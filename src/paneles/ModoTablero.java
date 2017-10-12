package paneles;

import java.awt.Color;
import javax.swing.JPanel;

import clases.Usuario;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class ModoTablero extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9127207366771663146L;
	private ModoJuego panelModoJuego;
	/**
	 * Create the panel.
	 * @param usuario 
	 * @param personaje 
	 * @param conexion 
	 * @param contentPane 
	 * @param contentPane 
	 */
	public ModoTablero(JPanel contentPane, Connection conexion, String personaje, Usuario usuario) {
		setBackground(Color.BLACK);
		setLayout(null);
		setSize(1366, 768);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ModoTablero.class.getResource("/imagenes/construccion.jpg")));
		label.setToolTipText("En Construcción");
		label.setBounds(104, 100, 990, 399);
		add(label);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelModoJuego= new ModoJuego(contentPane, conexion, personaje, usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoJuego);
				panelModoJuego.setLayout(null);
				panelModoJuego.setSize(getWidth(), getHeight());
			}
		});
		btn_Volver.setBounds(532, 612, 117, 25);
		add(btn_Volver);
		
	}
}
