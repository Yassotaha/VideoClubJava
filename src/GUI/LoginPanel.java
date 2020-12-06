package GUI;

import Main.sqliteConnection;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.EventQueue;
import java.sql.*; 
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel {
	
	public static Connection connection = null;
	
	private JFrame frame;
	private JPanel firstpanel;
	private JTextField IDField;
	private JPasswordField MDPField;

	
	/**
	 * Create the object loginFrame.
	 */
	public static void createLoginFrame()
	{
		LoginPanel loginWindow = new LoginPanel();
		loginWindow.frame.setVisible(true);
	}
	
	
	
	
	/**
	 * Construct the loginFrame.
	 */
	public LoginPanel() {
		
		connection = sqliteConnection.dbConnector();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 860, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		firstpanel = new JPanel();
		firstpanel.setBackground(Color.GRAY);
		firstpanel.setBounds(new Rectangle(0, 0, 940, 438));
		firstpanel.setLayout(null);
		frame.add(firstpanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(263, 62, 321, 99);
		firstpanel.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setBackground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 37));
		
		IDField = new JTextField();
		IDField.setBounds(370, 209, 214, 26);
		firstpanel.add(IDField);
		IDField.setColumns(10);
		
		JLabel IDLabel = new JLabel("Identifiant:");
		IDLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		IDLabel.setBounds(263, 209, 83, 22);
		firstpanel.add(IDLabel);
		
		JLabel MDPLabel = new JLabel("Mot de passe:");
		MDPLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		MDPLabel.setBounds(263, 259, 105, 22);
		firstpanel.add(MDPLabel);
		
		JButton btnConnect = new JButton("Se connecter");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					Main.BackEnd.setEstSup(false);
					
					String query = "select * from UsersInfo where ID=? and PW=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					
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
						
						
						String query2 = "select * from UsersInfo where ID=? and SUP=?";
						PreparedStatement pst2 = connection.prepareStatement(query2);
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
							Main.BackEnd.setEstSup(false);
						}
						
//						Cache et détruit le LoginFrame pour ensuite 
//						créer un MainFrame qui prendra sa place				
						hideLoginFrame();
						frame.dispose();
						MainGUI.createMainFrame();
						
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
		firstpanel.add(btnConnect);
		
		MDPField = new JPasswordField();
		MDPField.setBounds(370, 262, 214, 26);
		firstpanel.add(MDPField);

	}
	
	
	
	
	public void showLoginFrame()
	{
		frame.setVisible(true);
	}
	
	public void hideLoginFrame()
	{
		frame.setVisible(false);
	}
	
	
	
	
	
}
