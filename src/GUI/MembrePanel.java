package GUI;

import javax.swing.JPanel;


import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Main.*;
import java.awt.Font;
import Main.sqliteConnection;

public class MembrePanel extends JPanel {
	private static JTextField CodeSecret;
	private static JTextField Cartedecredit;
	private static JTextField Telephone;
	private static JTextField Nom;
	private static JTable table;
	
	private JTextField textField_5;
	private JTextField txtTlphone;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_inputNomAModif;
	private JTextField textField_nomAModif;
	private JTextField textField_CodeSecretAModif;
	private JTextField textField_inputCodeSecretAModif;
	private JLabel lblCompteModifier;
	private JLabel lblRentrerModification;
	

	public static Connection connection = null;

	private JButton btnAjouterMembre; 
	private JButton btnAppliquerModifMembre;
	private JButton btnSupprimerMembre;
	private JButton btnAnnulerOperation;
	


	/**
	 * Create the panel.
	 */
	public MembrePanel() {
		connection = sqliteConnection.dbConnector();
		setTable(new JTable());
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		JButton button = new JButton("Cr\u00E9er un nouveau membre");
		button.setBounds(34, 316, 205, 33);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//La methode enregistrer_employer permet d'enregistrer un nouveau employer dans la base de donnees.
				String NomValue = getNom().getText();
				String TelValue = getTelephone().getText();
				
				String CreditValue= getCartedecredit().getText();
				//Long  CreditValue1 = Long.parseLong(CreditValue);
				
				String CodeValue= getCodeSecret().getText();
				Integer CodeValue1 = Integer.parseInt(CodeValue);
				
				
				
             try {
		        	
				//String query = "INSERT INTO MembreInfo (`Nom`,Telephone,Credit,CodeSecret) Values("+NomValue+","+TelValue+","+CreditValue2+","+CodeValue2+")";*/
               	String query = "INSERT INTO MembreInfo (`Nom`,Telephone,Credit,CodeSecret) Values(?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, NomValue);
					pst.setString(2, TelValue);
					pst.setString(3, CreditValue);
					pst.setInt(4, CodeValue1);

					boolean rs = pst.execute();
				String query1 = "select ID,Nom,Telephone from MembreInfo";
					PreparedStatement pst1 = connection.prepareStatement(query1);
					ResultSet rs1 = pst1.executeQuery();
					getTable().setModel(DbUtils.resultSetToTableModel(rs1));
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();				}
				
			}
		});
		add(button);
		

		setCodeSecret(new JTextField());
		getCodeSecret().setColumns(10);
		getCodeSecret().setBounds(684, 412, 180, 20);
		add(getCodeSecret());

		
		
		
		
		btnAjouterMembre = new JButton("Ajouter");
		button.setBounds(910, 400, 10, 10);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(button);
		
		
		btnAppliquerModifMembre = new JButton("Appliquer");
		button.setBounds(34, 316, 205, 33);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(button);
		
		
		
		btnSupprimerMembre = new JButton("Supprimer");
		button.setBounds(34, 316, 205, 33);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(button);
		
		
		btnAnnulerOperation = new JButton("Annuler");
		button.setBounds(34, 316, 205, 33);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(button);
		
		
		
		
		

		
		setCartedecredit(new JTextField());
		getCartedecredit().setColumns(10);
		getCartedecredit().setBounds(684, 381, 180, 20);
		add(getCartedecredit());
		
		setTelephone(new JTextField());
		getTelephone().setColumns(10);
		getTelephone().setBounds(684, 350, 180, 20);
		add(getTelephone());
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setText("    Nom:");
		textField_5.setColumns(10);
		textField_5.setBounds(639, 322, 40, 20);
		add(textField_5);
		
		txtTlphone = new JTextField();
		txtTlphone.setEditable(false);
		txtTlphone.setText("    T\u00E9l\u00E9phone:");
		txtTlphone.setColumns(10);
		txtTlphone.setBounds(607, 350, 72, 20);
		add(txtTlphone);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setText("    Code secret:");
		textField_7.setColumns(10);
		textField_7.setBounds(599, 412, 80, 20);
		add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setText("    Carte de Cr\u00E9dit/D\u00E9bit:");
		textField_8.setColumns(10);
		textField_8.setBounds(545, 381, 134, 20);
		add(textField_8);
		//dghdghdfgh
		setNom(new JTextField());
		getNom().setColumns(10);
		getNom().setBounds(684, 322, 180, 20);
		add(getNom());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 11, 859, 298);
		add(scrollPane);
		
		
		
		
		try {
			String query = "select ID,Nom,Telephone from MembreInfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			getTable().setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		getTable().getColumnModel().getColumn(0).setPreferredWidth(291);
		getTable().getColumnModel().getColumn(1).setPreferredWidth(356);
		scrollPane.setViewportView(getTable());
		
		
		
		
		JButton btn_modifMembre = new JButton("Modifier un membre");
		btn_modifMembre.setBounds(34, 356, 205, 33);
		btn_modifMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Membre.modifier_membre();
				Membre.loadTablemembres();
				//lblCompteModifier.setVisible(true);
				//lblRentrerModification.setVisible(true);
				//textField_inputNomAModif.setVisible(true);
				//textField_nomAModif.setVisible(true);
				//textField_CodeSecretAModif.setVisible(true);
				//textField_inputCodeSecretAModif.setVisible(true);
				//revalidate();
			}
		});
		add(btn_modifMembre);
		
		
		
		
		JButton btn_suppMembre = new JButton("Supprimer un membre");
		btn_suppMembre.setBounds(34, 399, 205, 33);
		btn_suppMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//La methode supprimer_employer permet de supprimer un employer de la base de donnees.
				
				int row = getTable().getSelectedRow();
		        Integer id = (Integer) getTable().getModel().getValueAt(row, 0);	
		        
		        
		        try {
		        	
					String query = "delete from MembreInfo where ID= "+ id  ;
					PreparedStatement pst = connection.prepareStatement(query);
					boolean rs = pst.execute();
					String query1 = "select ID,Nom,Telephone from MembreInfo";
					PreparedStatement pst1 = connection.prepareStatement(query1);
					ResultSet rs1 = pst1.executeQuery();
					getTable().setModel(DbUtils.resultSetToTableModel(rs1));
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		add(btn_suppMembre);
		
		textField_inputNomAModif = new JTextField();
		textField_inputNomAModif.setColumns(10);
		textField_inputNomAModif.setBounds(353, 353, 180, 20);
		textField_inputNomAModif.setVisible(false);
		add(textField_inputNomAModif);
		
		textField_nomAModif = new JTextField();
		textField_nomAModif.setEditable(false);
		textField_nomAModif.setText("    Nom:");
		textField_nomAModif.setColumns(10);
		textField_nomAModif.setBounds(301, 353, 40, 20);
		textField_nomAModif.setVisible(false);
		add(textField_nomAModif);
		
		textField_CodeSecretAModif = new JTextField();
		textField_CodeSecretAModif.setEditable(false);
		textField_CodeSecretAModif.setText("Code secret:");
		textField_CodeSecretAModif.setColumns(10);
		textField_CodeSecretAModif.setVisible(false);
		textField_CodeSecretAModif.setBounds(261, 381, 80, 20);
		
		add(textField_CodeSecretAModif);
		
		textField_inputCodeSecretAModif = new JTextField();
		textField_inputCodeSecretAModif.setColumns(10);
		textField_inputCodeSecretAModif.setBounds(353, 381, 180, 20);
		textField_inputCodeSecretAModif.setVisible(false);
		add(textField_inputCodeSecretAModif);
		
		lblCompteModifier = new JLabel("Compte \u00E0 modifier :");
		lblCompteModifier.setBounds(261, 324, 134, 16);
		lblCompteModifier.setVisible(false);
		add(lblCompteModifier);
		
		lblRentrerModification = new JLabel("Rerentrer le compte \u00E0 droite avec les modifications");
		lblRentrerModification.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRentrerModification.setBounds(251, 412, 342, 20);
		lblRentrerModification.setVisible(false);
		add(lblRentrerModification);

	}



	public static JTextField getNom() {
		return Nom;
	}



	public void setNom(JTextField nom) {
		Nom = nom;
	}



	public static JTextField getTelephone() {
		return Telephone;
	}



	public void setTelephone(JTextField telephone) {
		Telephone = telephone;
	}



	public static JTextField getCodeSecret() {
		return CodeSecret;
	}



	public void setCodeSecret(JTextField codeSecret) {
		CodeSecret = codeSecret;
	}



	public static JTextField getCartedecredit() {
		return Cartedecredit;
	}



	public void setCartedecredit(JTextField cartedecredit) {
		Cartedecredit = cartedecredit;
	}



	public static JTable getTable() {
		return table;
	}



	public void setTable(JTable table) {
		this.table = table;
	}



	public static JTable getModel() {
		// TODO Auto-generated method stub
		return table;
	}



	
}
