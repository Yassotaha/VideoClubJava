package GUI;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import GUI.VentePanel;

public class VentePanel   {

	private JFrame frame;
	private JLabel lblPopcornamount;
	private JLabel lblBonbonsamount;
	private int TotalPopcorn = 0;
	private int TotalBonbons = 0;
	private int i = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentePanel window = new VentePanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 737, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVidoClub = new JLabel("Vid\u00E9o Club");
		lblVidoClub.setFont(new Font("Calibri", Font.BOLD, 14));
		lblVidoClub.setBounds(329, 11, 108, 18);
		frame.getContentPane().add(lblVidoClub);
		
		JButton btnVenteLocation = new JButton("Vente Location");
		btnVenteLocation.setBounds(10, 103, 133, 58);
		frame.getContentPane().add(btnVenteLocation);
		
		JButton btnMmebre = new JButton("Membre\r\n");
		btnMmebre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMmebre.setBounds(10, 172, 133, 58);
		frame.getContentPane().add(btnMmebre);
		
		JButton btnInventaire = new JButton("Inventaire");
		btnInventaire.setBounds(10, 242, 133, 58);
		frame.getContentPane().add(btnInventaire);
		
		JButton btnBonbons = new JButton("Bonbons :");
		btnBonbons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TotalBonbons += i;
				
				
				lblBonbonsamount.setText("x :" + " " + TotalBonbons);
				
			}
		});
		btnBonbons.setBounds(418, 81, 93, 58);
		frame.getContentPane().add(btnBonbons);
		
		JButton btnPopcorn = new JButton("Popcorn :");
		btnPopcorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 TotalPopcorn += i;
				
				
				 lblPopcornamount.setText("x :" + " " + TotalPopcorn);
				
			}
		});
		btnPopcorn.setBounds(223, 81, 93, 58);
		frame.getContentPane().add(btnPopcorn);
		
		lblPopcornamount = new JLabel("PopcornAmount");
		lblPopcornamount.setBounds(329, 103, 48, 14);
		frame.getContentPane().add(lblPopcornamount);
		
		lblBonbonsamount = new JLabel("BonbonsAmount\r\n");
		lblBonbonsamount.setBounds(521, 103, 48, 14);
		frame.getContentPane().add(lblBonbonsamount);
		
		Button button = new Button("Se d\u00E9connecter\r\n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//nous donne l'affichage principale de Sam
			}
		});
		button.setBounds(609, 11, 102, 31);
		frame.getContentPane().add(button);
		
		List list = new List();
		list.setBounds(223, 172, 176, 156);
		frame.getContentPane().add(list);
		
		List list_1 = new List();
		list_1.setBounds(418, 172, 176, 156);
		frame.getContentPane().add(list_1);
	}
}
