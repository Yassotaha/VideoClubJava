package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.EventQueue;
import java.sql.*; 
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	private JTextField IDField;
	private JPasswordField MDPField;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(263, 62, 321, 99);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 37));
		
		IDField = new JTextField();
		IDField.setBounds(370, 209, 214, 26);
		add(IDField);
		IDField.setColumns(10);
		
		JLabel IDLabel = new JLabel("Identifiant:");
		IDLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		IDLabel.setBounds(263, 209, 83, 22);
		add(IDLabel);
		
		JLabel MDPLabel = new JLabel("Mot de passe:");
		MDPLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		MDPLabel.setBounds(263, 259, 105, 22);
		add(MDPLabel);
		
		JButton btnConnect = new JButton("Se connecter");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Main.BackEnd.setEstSup(false);
					
					String query = "select * from UsersInfo where ID=? and PW=? ";
					PreparedStatement pst = MainGUI.connection.prepareStatement(query);
					
					pst.setString(1, IDField.getText());
					pst.setString(2, MDPField.getText());
									
					ResultSet rs = pst.executeQuery();
					
					
					int count = 0;
					while(rs.next()) {
						count++;
					}
					
					if(count==1) {
						JOptionPane.showMessageDialog(null, "Identifiant et mot de passe correct.");
						//TODO Changer pour le Panel "membre"
						
						MainGUI.layeredPane.removeAll();
						MainGUI.layeredPane.add(MainGUI.ventePanel);
						MainGUI.layeredPane.repaint();
						MainGUI.layeredPane.revalidate();

						String query2 = "select * from UsersInfo where ID=? and SUP=?";
						PreparedStatement pst2 = MainGUI.connection.prepareStatement(query2);
						pst2.setString(1, IDField.getText());
						pst2.setString(2, "true");
						
						ResultSet rs2 = pst2.executeQuery();
						
						int count2 = 0;
						while(rs2.next()) {
							count2++;
						}
						
						if(count2==1) {
							System.out.println(IDField.getText()+" est un superviseur");
							Main.BackEnd.setEstSup(true);
						}
						else {
							System.out.println(IDField.getText()+" n'est pas un superviseur");
						}
						
					}
					else if(count>1) {
						JOptionPane.showMessageDialog(null, "Duplicate Username and password");
					}
					else {
						JOptionPane.showMessageDialog(null, "Identifiant et mot de passe incorrect. Veuillez essayer de nouveau.");
					}
					
					rs.close();
					pst.close();
					
					
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
				
				finally {
					
					try {
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		btnConnect.setBounds(370, 305, 126, 23);
		add(btnConnect);
		
		MDPField = new JPasswordField();
		MDPField.setBounds(370, 262, 214, 26);
		add(MDPField);

	}
}
