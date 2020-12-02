package GUI;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentePanel extends JPanel {
	
	private JLabel lblPopcornamount;
	private JLabel lblBonbonsamount;
	private int TotalPopcorn = 0;
	private int TotalBonbons = 0;
	private int i = 1;

	/**
	 * Create the panel.
	 */
	public VentePanel() {
		
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		JButton btnPopcorn = new JButton("Popcorn:");
		btnPopcorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TotalPopcorn += i;
				
				
				lblPopcornamount.setText("x :" + " " + TotalPopcorn);
				
			}
		});
		btnPopcorn.setBounds(155, 61, 128, 74);
		add(btnPopcorn);
		
		JLabel lblPopcornamount = new JLabel("PopcornAmount");
		lblPopcornamount.setBounds(293, 91, 65, 14);
		add(lblPopcornamount);
		
		JButton btnBonbons = new JButton("Bonbons:");
		btnBonbons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TotalBonbons += i;
				
				
				lblBonbonsamount.setText("x :" + " " + TotalBonbons);
			}
		});
		btnBonbons.setBounds(534, 61, 128, 74);
		add(btnBonbons);
		
		JLabel lblBonbonsamount = new JLabel("BonbonsAmount");
		lblBonbonsamount.setBounds(672, 91, 65, 14);
		add(lblBonbonsamount);
		
		JList list = new JList();
		list.setBounds(41, 166, 409, 235);
		add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(482, 166, 409, 235);
		add(list_1);
		
		

	}
}
