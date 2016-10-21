package ui;

import data.*;
import entities.*;
import util.SuperLogger;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.logging.log4j.Level;

import business.CtrlCombate;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SeleccionPersonaje extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtJugador1;
	private JTextField txtJugador2;
	private Personaje p1, p2; 
	dataPersonaje dataPer = new dataPersonaje();
	//Pedirle al controlador???
	private CtrlCombate ctrl;

	/**
	 * Launch the application.
	 */
	
	
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionPersonaje frame = new SeleccionPersonaje();
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
	public SeleccionPersonaje() //modificacion constructor. Los separe al constructor del creador de la ventana 
	{
		initialize();
		ctrl = CtrlCombate.getInstanciaUnica()
				;
	}
		
		
		
	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJugador = new JLabel("Jugador 1:");
		lblJugador.setBounds(32, 66, 63, 14);
		contentPane.add(lblJugador);
		
		JLabel lblJugador_1 = new JLabel("Jugador 2:");
		lblJugador_1.setBounds(32, 102, 63, 14);
		contentPane.add(lblJugador_1);
		
		txtJugador1 = new JTextField();
		txtJugador1.setBounds(105, 63, 217, 20);
		contentPane.add(txtJugador1);
		txtJugador1.setColumns(10);
		
		txtJugador2 = new JTextField();
		txtJugador2.setBounds(105, 99, 217, 20);
		contentPane.add(txtJugador2);
		txtJugador2.setColumns(10);
		txtJugador2.setEditable(false);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Personaje per = dataPer.getByNombre(txtJugador1.getText()); //controlador????
				if(per == null){
					JOptionPane.showMessageDialog(null, "El jugador no existe");
				} 
				else 
				{
					p1 = per;
					txtJugador1.setEditable(false);
					txtJugador2.setEditable(true);
				}				
			}
		});
		btnBuscar.setBounds(357, 62, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personaje per = dataPer.getByNombre(txtJugador2.getText());
				if(per == null){
					JOptionPane.showMessageDialog(null, "El jugador no existe");
				} 
				else 
				{
					p2 = per;
					txtJugador2.setEditable(false);
				}
			}
		});
		btnBuscar_1.setBounds(357, 98, 89, 23);
		contentPane.add(btnBuscar_1);
		
		JButton btnComenzarPartida = new JButton("Comenzar partida ");
		btnComenzarPartida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnComenzarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p1.equals(p2))
					{
						JOptionPane.showMessageDialog(null, "Los dos jugadores no deben ser los mismos");
					}
				else
					{
						Combate.main();
						ctrl.setJugadores(p1, p2);
						
						
					}
			}
		});
		btnComenzarPartida.setBounds(105, 162, 155, 23);
		contentPane.add(btnComenzarPartida);
		
		JLabel lblSeleccionJugadores = new JLabel("Seleccion jugadores");
		lblSeleccionJugadores.setBounds(32, 23, 171, 14);
		contentPane.add(lblSeleccionJugadores);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = null;
				//aca habr�a que buscar la forma que se pueda cerrar la ventana originak
				//antes de abrir la otra porque sino se acumulan pero con el
				//frame.dispose(); se generan errores despues
				Inicio.main(args);
			}
		});
		btnVolver.setBounds(357, 162, 89, 23);
		contentPane.add(btnVolver);
		
	}
}