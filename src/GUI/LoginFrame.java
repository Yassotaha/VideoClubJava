package GUI;

import Main.sqliteConnection;


import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*; 
import javax.swing.*;

public class LoginFrame {
	
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
		LoginFrame loginWindow = new LoginFrame();
		loginWindow.frame.setVisible(true);
	}
	
	
	
	
	/**
	 * Construct the loginFrame.
	 */
	public LoginFrame() {
		
		connection = sqliteConnection.dbConnector();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		firstpanel = new JPanel();
		firstpanel.setBackground(Color.GRAY);
		firstpanel.setBounds(new Rectangle(0, 0, 940, 438));
		firstpanel.setLayout(null);
		frame.getContentPane().add(firstpanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 238, 238));
		panel.setBounds(288, 62, 296, 337);
		firstpanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setBounds(20, 36, 250, 84);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(Color.red);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 37));
		
		IDField = new JTextField();
		IDField.setBounds(126, 184, 142, 20);
		IDField.setColumns(10);
		panel.add(IDField);
		
		JLabel label = new JLabel("Identifiant:");
		label.setBounds(49, 165, 144, 54);
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(label);
		
		JLabel label_1 = new JLabel("Mot de passe:");
		label_1.setBounds(20, 196, 127, 84);
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(label_1);
		
		MDPField = new JPasswordField();
		MDPField.setBounds(126, 230, 144, 20);
		panel.add(MDPField);
		
		JButton btnSeConnecter = new JButton("Se connecter");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Main.Employe.setEstSup(false);
					
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
							Main.Employe.setEstSup(true);
						}
						else {
							System.out.println(IDField.getText()+" n'est pas un superviseur");
							Main.Employe.setEstSup(false);
						}
						
						
//						Afficher/Add ID in MainGUI
						MainGUI.ID = IDField.getText();
						
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
					JOptionPane.showMessageDialog(null, "Identifiant et mot de passe incorrect. Veuillez essayer de nouveau.");
				}
				
				finally {
					
					try {
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
				}
				
			}
		});
		btnSeConnecter.setBounds(94, 273, 119, 34);
		
		panel.add(btnSeConnecter);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 807, 461);
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/background.jpg")));
		firstpanel.add(lblNewLabel_1);

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
