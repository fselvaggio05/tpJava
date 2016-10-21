package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.*;
import entities.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Combate extends JFrame {  //diferente tipo de ABMPer

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtEnergiaAtaque;
	private JTextField txtJugador1;
	private JTextField txtVidaJugador1;
	private JTextField txtEnergiaJugador1;
	private JTextField txtDefensaJugador1;
	private JTextField txtEvasionJugador1;
	private JTextField txtJugador2;
	private JTextField txtVidaJugador2;
	private JTextField txtEnergiaJugador2;
	private JTextField txtDefensaJugador2;
	private JTextField txtEvasionJugador2;
	private JTextField txtTurno;
	private CtrlCombate ctrl;
	
	

	/**
	 * Launch the application.
	 */
	public static void main() { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combate frame = new Combate();
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
	public Combate() { //el parametro fue agregado para conservar la instancia del controlador creada en seleccionPersonajes
		initialize();
		ctrl=CtrlCombate.getInstanciaUnica();
		this.setJugadores();
		//final boolean resultado;
		
		 
		
	}
	public void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPersonaje = new JLabel("Personaje 1:");
		lblPersonaje.setBounds(10, 11, 71, 14);
		contentPane.add(lblPersonaje);
		
		JLabel lblPersonaje_1 = new JLabel("Personaje 2:");
		lblPersonaje_1.setBounds(166, 11, 71, 14);
		contentPane.add(lblPersonaje_1);
		
		JLabel lblEnergia = new JLabel("Energ\u00EDa:");
		lblEnergia.setBounds(10, 61, 46, 14);
		contentPane.add(lblEnergia);
		
		JLabel lblVida = new JLabel("Vida:");
		lblVida.setBounds(10, 36, 29, 14);
		contentPane.add(lblVida);
		
		JLabel lblDefensa = new JLabel("Defensa:");
		lblDefensa.setBounds(10, 90, 46, 14);
		contentPane.add(lblDefensa);
		
		JLabel lblEvasin = new JLabel("Evasi\u00F3n:");
		lblEvasin.setBounds(10, 115, 46, 14);
		contentPane.add(lblEvasin);
		
		JLabel label = new JLabel("Vida:");
		label.setBounds(166, 36, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Energ\u00EDa:");
		label_1.setBounds(166, 61, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Defensa:");
		label_2.setBounds(166, 90, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Evasi\u00F3n:");
		label_3.setBounds(166, 115, 46, 14);
		contentPane.add(label_3);
		
		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setBounds(10, 155, 46, 14);
		contentPane.add(lblTurno);
		
		JLabel lblEnerga_1 = new JLabel("Energ\u00EDa:");
		lblEnerga_1.setBounds(10, 200, 46, 14);
		contentPane.add(lblEnerga_1);
		
		txtEnergiaAtaque = new JTextField();
		txtEnergiaAtaque.setBounds(66, 197, 57, 20);
		contentPane.add(txtEnergiaAtaque);
		txtEnergiaAtaque.setColumns(10);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ctrl.Partida(Integer.parseInt(txtEnergiaAtaque.getText())))
				{
					setVida();
					setEnergia();
					setTurno();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Fin del juego");
					//setResultado();
				}
				
				
			}
		});
		btnAtacar.setBounds(166, 196, 89, 23);
		contentPane.add(btnAtacar);
		
		JButton btnDefender = new JButton("Defender");
		btnDefender.setBounds(166, 222, 89, 23);
		contentPane.add(btnDefender);
		
		txtJugador1 = new JTextField();
		txtJugador1.setEnabled(false);
		txtJugador1.setBounds(78, 8, 71, 20);
		contentPane.add(txtJugador1);
		txtJugador1.setColumns(10);
		
		txtVidaJugador1 = new JTextField();
		txtVidaJugador1.setEnabled(false);
		txtVidaJugador1.setBounds(78, 36, 70, 20);
		contentPane.add(txtVidaJugador1);
		txtVidaJugador1.setColumns(10);
		
		txtEnergiaJugador1 = new JTextField();
		txtEnergiaJugador1.setEnabled(false);
		txtEnergiaJugador1.setColumns(10);
		txtEnergiaJugador1.setBounds(78, 64, 71, 20);
		contentPane.add(txtEnergiaJugador1);
		
		txtDefensaJugador1 = new JTextField();
		txtDefensaJugador1.setEnabled(false);
		txtDefensaJugador1.setColumns(10);
		txtDefensaJugador1.setBounds(78, 90, 71, 20);
		contentPane.add(txtDefensaJugador1);
		
		txtEvasionJugador1 = new JTextField();
		txtEvasionJugador1.setEnabled(false);
		txtEvasionJugador1.setColumns(10);
		txtEvasionJugador1.setBounds(78, 116, 71, 20);
		contentPane.add(txtEvasionJugador1);
		
		txtJugador2 = new JTextField();
		txtJugador2.setEnabled(false);
		txtJugador2.setColumns(10);
		txtJugador2.setBounds(238, 8, 71, 20);
		contentPane.add(txtJugador2);
		
		txtVidaJugador2 = new JTextField();
		txtVidaJugador2.setEnabled(false);
		txtVidaJugador2.setColumns(10);
		txtVidaJugador2.setBounds(238, 36, 71, 20);
		contentPane.add(txtVidaJugador2);
		
		txtEnergiaJugador2 = new JTextField();
		txtEnergiaJugador2.setEnabled(false);
		txtEnergiaJugador2.setColumns(10);
		txtEnergiaJugador2.setBounds(238, 64, 71, 20);
		contentPane.add(txtEnergiaJugador2);
		
		txtDefensaJugador2 = new JTextField();
		txtDefensaJugador2.setEnabled(false);
		txtDefensaJugador2.setColumns(10);
		txtDefensaJugador2.setBounds(238, 90, 71, 20);
		contentPane.add(txtDefensaJugador2);
		
		txtEvasionJugador2 = new JTextField();
		txtEvasionJugador2.setEnabled(false);
		txtEvasionJugador2.setColumns(10);
		txtEvasionJugador2.setBounds(238, 115, 71, 20);
		contentPane.add(txtEvasionJugador2);
		
		txtTurno = new JTextField();
		txtTurno.setEnabled(false);
		txtTurno.setColumns(10);
		txtTurno.setBounds(78, 152, 231, 20);
		contentPane.add(txtTurno);
		
	}

	public void setJugadores()
	{
			txtJugador1.setText(ctrl.getJugador1().getNombre());	
			txtJugador2.setText(ctrl.getJugador2().getNombre());
			
			txtVidaJugador1.setText(String.valueOf(ctrl.getJugador1().getVida()));
			txtVidaJugador2.setText(String.valueOf(ctrl.getJugador2().getVida()));
			
			txtEnergiaJugador1.setText(String.valueOf(ctrl.getJugador1().getEnergia()));
			txtEnergiaJugador2.setText(String.valueOf(ctrl.getJugador2().getEnergia()));
			
			txtDefensaJugador1.setText(String.valueOf(ctrl.getJugador1().getDefensa()));
			txtDefensaJugador2.setText(String.valueOf(ctrl.getJugador2().getDefensa()));
			
			txtEvasionJugador1.setText(String.valueOf(ctrl.getJugador1().getEvasion()));
			txtEvasionJugador2.setText(String.valueOf(ctrl.getJugador2().getEvasion()));
					
			txtTurno.setText(ctrl.getPersonajeTurno().getNombre());
	}
	
	public void setResultado()
	{
		
	}
	public void setVida()
	{
		txtVidaJugador1.setText(String.valueOf(ctrl.getJugador1().getVidaActual()));
		txtVidaJugador2.setText(String.valueOf(ctrl.getJugador2().getVidaActual()));
	}
	
	public void setEnergia()
	{
		txtEnergiaJugador1.setText(String.valueOf(ctrl.getJugador1().getEnergiaActual()));
		txtEnergiaJugador2.setText(String.valueOf(ctrl.getJugador2().getEnergiaActual()));
	}
	
	public void setTurno()
	{
		txtTurno.setText(String.valueOf(ctrl.persTurno.getNombre()));
	}
	
	//
}
