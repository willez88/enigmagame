package paneles;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;

import clases.Usuario;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModoDesafioJuego1 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7721533609555438266L;
	private ModoDesafioJuego2 panelModoDesafioJuego2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 * @param personaje 
	 * @param conexion 
	 * @param usuario 
	 */
	public ModoDesafioJuego1(Connection conexion, String personaje, Usuario usuario) {
		setBackground(Color.BLACK);
		setLayout(null);
		//quitar al terminar
		setSize(1366, 768);
		
		int limite=99;
        Random r= new Random();
        r.setSeed(new Date().getTime());
		
		//Declaraciones de los label y textfield del juego1
		JLabel label_2 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(SeleccionarPersonaje.class.getResource(personaje)));
		btnNewButton.setBounds(65, 40, 200, 160);
		add(btnNewButton);
		
		JButton btnJuego_1 = new JButton("Juego 1");
		btnJuego_1.setEnabled(false);
		btnJuego_1.setBounds(363, 111, 89, 23);
		add(btnJuego_1);
		
		JButton btnJuego_2 = new JButton("Juego 2");
		btnJuego_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelModoDesafioJuego2= new ModoDesafioJuego2(conexion, personaje, usuario);
				remove(getRootPane());
				getRootPane().setContentPane(panelModoDesafioJuego2);
				panelModoDesafioJuego2.setLayout(null);
				panelModoDesafioJuego2.setSize(getWidth(), getHeight());
			}
		});
		btnJuego_2.setEnabled(false);
		btnJuego_2.setBounds(556, 111, 89, 23);
		add(btnJuego_2);
		
		JButton btnJuego_3 = new JButton("Juego 3");
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
		
		JLabel label_1 = new JLabel("Calculadora");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setForeground(Color.GREEN);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(556, 186, 118, 30);
		add(label_1);
		
		//JLabel lblNewLabel_1 = new JLabel("2");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(363, 267, 40, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("+");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(419, 267, 40, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(486, 267, 40, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("=");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(536, 267, 40, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(363, 305, 40, 14);
		label_6.setVisible(false);
		add(label_6);
		
		JLabel label_7 = new JLabel("x");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(419, 305, 40, 14);
		label_7.setVisible(false);
		add(label_7);
		
		JLabel label_8 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(486, 305, 40, 14);
		label_8.setVisible(false);
		add(label_8);
		
		JLabel label_9 = new JLabel("=");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.WHITE);
		label_9.setBounds(536, 305, 40, 14);
		label_9.setVisible(false);
		add(label_9);
		
		//numerador mayor que el denominador
		JLabel label_10 = new JLabel();
		JLabel label_12 = new JLabel();
		int num1= r.nextInt(limite) +1;
		int num2= r.nextInt(limite) +1;
		if(num1>num2)
		{
			label_10.setText(Integer.toString(num1));
			label_12.setText(Integer.toString(num2));
		}
		else
		{
			label_10.setText(Integer.toString(num2));
			label_12.setText(Integer.toString(num1));
		}
		//JLabel label_10 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setBounds(363, 349, 40, 14);
		label_10.setVisible(false);
		add(label_10);
		
		JLabel label_11 = new JLabel("/");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.WHITE);
		label_11.setBounds(419, 349, 40, 14);
		label_11.setVisible(false);
		add(label_11);
		
		//JLabel label_12 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.WHITE);
		label_12.setBounds(486, 349, 40, 14);
		label_12.setVisible(false);
		add(label_12);
		
		JLabel label_13 = new JLabel("=");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.WHITE);
		label_13.setBounds(536, 349, 40, 14);
		label_13.setVisible(false);
		add(label_13);
		
		JLabel label_14 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.WHITE);
		label_14.setBounds(363, 393, 40, 14);
		label_14.setVisible(false);
		add(label_14);
		
		JLabel label_15 = new JLabel("-");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.WHITE);
		label_15.setBounds(419, 393, 40, 14);
		label_15.setVisible(false);
		add(label_15);
		
		JLabel label_16 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.WHITE);
		label_16.setBounds(486, 393, 40, 14);
		label_16.setVisible(false);
		add(label_16);
		
		JLabel label_17 = new JLabel("=");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(Color.WHITE);
		label_17.setBounds(536, 393, 40, 14);
		label_17.setVisible(false);
		add(label_17);
		
		JLabel label_18 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(Color.WHITE);
		label_18.setBounds(363, 452, 40, 14);
		label_18.setVisible(false);
		add(label_18);
		
		JLabel label_19 = new JLabel("x");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(Color.WHITE);
		label_19.setBounds(419, 452, 40, 14);
		label_19.setVisible(false);
		add(label_19);
		
		JLabel label_20 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setForeground(Color.WHITE);
		label_20.setBounds(486, 452, 40, 14);
		label_20.setVisible(false);
		add(label_20);
		
		JLabel label_21 = new JLabel("=");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(Color.WHITE);
		label_21.setBounds(536, 452, 40, 14);
		label_21.setVisible(false);
		add(label_21);
		
		JLabel label_22 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(Color.WHITE);
		label_22.setBounds(363, 492, 40, 14);
		label_22.setVisible(false);
		add(label_22);
		
		JLabel label_23 = new JLabel("+");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setForeground(Color.WHITE);
		label_23.setBounds(419, 492, 40, 14);
		label_23.setVisible(false);
		add(label_23);
		
		JLabel label_24 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setForeground(Color.WHITE);
		label_24.setBounds(486, 492, 40, 14);
		label_24.setVisible(false);
		add(label_24);
		
		JLabel label_25 = new JLabel("=");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setForeground(Color.WHITE);
		label_25.setBounds(536, 492, 40, 14);
		label_25.setVisible(false);
		add(label_25);
		
		JLabel label_26 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setForeground(Color.WHITE);
		label_26.setBounds(363, 535, 40, 14);
		label_26.setVisible(false);
		add(label_26);
		
		JLabel label_27 = new JLabel("-");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setForeground(Color.WHITE);
		label_27.setBounds(419, 535, 40, 14);
		label_27.setVisible(false);
		add(label_27);
		
		JLabel label_28 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setForeground(Color.WHITE);
		label_28.setBounds(486, 535, 40, 14);
		label_28.setVisible(false);
		add(label_28);
		
		JLabel label_29 = new JLabel("=");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setForeground(Color.WHITE);
		label_29.setBounds(536, 535, 40, 14);
		label_29.setVisible(false);
		add(label_29);
		
		JLabel label_30 = new JLabel();
		JLabel label_32 = new JLabel();
		num1= r.nextInt(limite) +1;
		num2= r.nextInt(limite) +1;
		if(num1>num2)
		{
			label_30.setText(Integer.toString(num1));
			label_32.setText(Integer.toString(num2));
		}
		else
		{
			label_30.setText(Integer.toString(num2));
			label_32.setText(Integer.toString(num1));
		}
		
		//JLabel label_30 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setForeground(Color.WHITE);
		label_30.setBounds(363, 580, 40, 14);
		label_30.setVisible(false);
		add(label_30);
		
		JLabel label_31 = new JLabel("/");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setForeground(Color.WHITE);
		label_31.setBounds(419, 580, 40, 14);
		label_31.setVisible(false);
		add(label_31);
		
		//JLabel label_32 = new JLabel(Integer.toString(r.nextInt(limite) +1));
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setForeground(Color.WHITE);
		label_32.setBounds(486, 580, 40, 14);
		label_32.setVisible(false);
		add(label_32);
		
		JLabel label_33 = new JLabel("=");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setForeground(Color.WHITE);
		label_33.setBounds(536, 580, 40, 14);
		label_33.setVisible(false);
		add(label_33);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int result= Integer.parseInt(label_2.getText())+Integer.parseInt(label_4.getText());
				if( result == Integer.parseInt(textField.getText()) )
				{
					label_6.setVisible(true);
					label_7.setVisible(true);
					label_8.setVisible(true);
					label_9.setVisible(true);
					textField_1.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+20);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 2.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_2.setEnabled(true);
				}
				textField.setEnabled(false);
			}
		});
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(588, 264, 50, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= Integer.parseInt(label_6.getText())*Integer.parseInt(label_8.getText());
				if (result == Integer.parseInt(textField_1.getText()))
				{
					label_10.setVisible(true);
					label_11.setVisible(true);
					label_12.setVisible(true);
					label_13.setVisible(true);
					textField_2.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+20);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 2.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_2.setEnabled(true);
				}
				textField_1.setEnabled(false);
			}
		});
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(588, 302, 50, 20);
		textField_1.setVisible(false);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= Integer.parseInt(label_10.getText())/Integer.parseInt(label_12.getText());
				System.out.println(result+" "+textField_2.getText());
				if (result == Integer.parseInt(textField_2.getText()))
				{
					label_14.setVisible(true);
					label_15.setVisible(true);
					label_16.setVisible(true);
					label_17.setVisible(true);
					textField_3.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+20);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 2.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_2.setEnabled(true);
				}
				textField_2.setEnabled(false);
			}
		});
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(586, 349, 50, 20);
		textField_2.setVisible(false);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= Integer.parseInt(label_14.getText())-Integer.parseInt(label_16.getText());
				if (result == Integer.parseInt(textField_3.getText()))
				{
					label_18.setVisible(true);
					label_19.setVisible(true);
					label_20.setVisible(true);
					label_21.setVisible(true);
					textField_4.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+20);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 2.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_2.setEnabled(true);
				}
				textField_3.setEnabled(false);
			}
		});
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(586, 390, 50, 20);
		textField_3.setVisible(false);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= Integer.parseInt(label_18.getText())*Integer.parseInt(label_20.getText());
				if (result == Integer.parseInt(textField_4.getText()))
				{
					label_22.setVisible(true);
					label_23.setVisible(true);
					label_24.setVisible(true);
					label_25.setVisible(true);
					textField_5.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+20);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 2.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_2.setEnabled(true);
				}
				textField_4.setEnabled(false);
			}
		});
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(586, 449, 50, 20);
		textField_4.setVisible(false);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= Integer.parseInt(label_22.getText())+Integer.parseInt(label_24.getText());
				if (result == Integer.parseInt(textField_5.getText()))
				{
					label_26.setVisible(true);
					label_27.setVisible(true);
					label_28.setVisible(true);
					label_29.setVisible(true);
					textField_6.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+20);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 2.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_2.setEnabled(true);
				}
				textField_5.setEnabled(false);
			}
		});
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(586, 489, 50, 20);
		textField_5.setVisible(false);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= Integer.parseInt(label_26.getText())-Integer.parseInt(label_28.getText());
				if (result == Integer.parseInt(textField_6.getText()))
				{
					label_30.setVisible(true);
					label_31.setVisible(true);
					label_32.setVisible(true);
					label_33.setVisible(true);
					textField_7.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+20);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 2.\nPuntos Acumulados: "+usuario.getPuntos());
					btnJuego_2.setEnabled(true);
				}
				textField_6.setEnabled(false);
			}
		});
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		textField_6.setBounds(586, 532, 50, 20);
		textField_6.setVisible(false);
		add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result=Integer.parseInt(label_30.getText())/Integer.parseInt(label_32.getText());
				if (result == Integer.parseInt(textField_7.getText()))
				{
					label_30.setVisible(true);
					label_31.setVisible(true);
					label_32.setVisible(true);
					label_33.setVisible(true);
					//puntos+=20;
					usuario.setPuntos(usuario.getPuntos()+20);
					actualizarPuntos(conexion, usuario);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Perdiste!!!\nIntenta con el Juego 2.\nPuntos Acumulados: "+usuario.getPuntos());
				}
				textField_7.setEnabled(false);
				btnJuego_2.setEnabled(true);
			}
		});
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		textField_7.setBounds(586, 577, 50, 20);
		textField_7.setVisible(false);
		add(textField_7);
		
		JLabel labelTiempo = new JLabel("Tiempo:");
		labelTiempo.setForeground(Color.WHITE);
		labelTiempo.setBounds(954, 349, 60, 15);
		add(labelTiempo);
		
		JLabel label_Cronometro = new JLabel("");
		label_Cronometro.setForeground(Color.WHITE);
		label_Cronometro.setBounds(1026, 349, 70, 15);
		add(label_Cronometro);
		
		Timer timer;
	    timer = new Timer();

	    TimerTask task = new TimerTask() {
	        int seg=120;
	        @Override
	        public void run()
	        {
	            if(seg==0)
	            {
	            	timer.cancel();
	            	actualizarPuntos(conexion, usuario);
	            	textField.setEnabled(false);
	            	textField_1.setEnabled(false);
	            	textField_2.setEnabled(false);
	            	textField_3.setEnabled(false);
	            	textField_4.setEnabled(false);
	            	textField_5.setEnabled(false);
	            	textField_6.setEnabled(false);
	            	textField_7.setEnabled(false);
	            	btnJuego_2.setEnabled(true);
	            }
	            label_Cronometro.setText(Integer.toString(seg));
	            seg--;
	        }
	        };
	        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
	    timer.schedule(task, 10, 1000);
	    }
	public void actualizarPuntos(Connection conexion, Usuario usuario)
	{
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) conexion.prepareStatement("update usuario set puntos="+usuario.getPuntos()+" where nombre='"+usuario.getNombre()+"';");
			ps.executeUpdate();
			//ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
