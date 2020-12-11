package GUI;

import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.Font;
import Main.sqliteConnection;

public class MembrePanel extends JPanel {
	private JTextField CodeSecret;
	private JTextField Cartedecredit;
	private JTextField Telephone;
	private JTextField textField_5;
	private JTextField txtTlphone;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField Nom;
	private JTable table;
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
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		JButton button = new JButton("Cr\u00E9er un nouveau membre");
		button.setBounds(34, 316, 205, 33);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(button);
		

		CodeSecret = new JTextField();
		CodeSecret.setColumns(10);
		CodeSecret.setBounds(684, 412, 180, 20);
		add(CodeSecret);

		
		
		
		
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
		
		
		
		
		

		
		Cartedecredit = new JTextField();
		Cartedecredit.setColumns(10);
		Cartedecredit.setBounds(684, 381, 180, 20);
		add(Cartedecredit);
		
		Telephone = new JTextField();
		Telephone.setColumns(10);
		Telephone.setBounds(684, 350, 180, 20);
		add(Telephone);
		
		textField_5 = new JTextField();
		textField_5.setText("    Nom:");
		textField_5.setColumns(10);
		textField_5.setBounds(639, 322, 40, 20);
		add(textField_5);
		
		txtTlphone = new JTextField();
		txtTlphone.setText("    T\u00E9l\u00E9phone:");
		txtTlphone.setColumns(10);
		txtTlphone.setBounds(607, 350, 72, 20);
		add(txtTlphone);
		
		textField_7 = new JTextField();
		textField_7.setText("    Code secret:");
		textField_7.setColumns(10);
		textField_7.setBounds(599, 412, 80, 20);
		add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("    Carte de Cr\u00E9dit/D\u00E9bit:");
		textField_8.setColumns(10);
		textField_8.setBounds(545, 381, 134, 20);
		add(textField_8);
		
		Nom = new JTextField();
		Nom.setColumns(10);
		Nom.setBounds(684, 322, 180, 20);
		add(Nom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 11, 859, 298);
		add(scrollPane);
		
		table = new JTable();
		
		try {
			String query = "select Nom,Telephone from MembreInfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(291);
		table.getColumnModel().getColumn(1).setPreferredWidth(356);
		scrollPane.setViewportView(table);
		
		
		
		
		JButton btn_modifMembre = new JButton("Modifier un membre");
		btn_modifMembre.setBounds(34, 356, 205, 33);
		btn_modifMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCompteModifier.setVisible(true);
				lblRentrerModification.setVisible(true);
				textField_inputNomAModif.setVisible(true);
				textField_nomAModif.setVisible(true);
				textField_CodeSecretAModif.setVisible(true);
				textField_inputCodeSecretAModif.setVisible(true);
				revalidate();
			}
		});
		add(btn_modifMembre);
		
		
		
		
		JButton btn_suppMembre = new JButton("Supprimer un membre");
		btn_suppMembre.setBounds(34, 399, 205, 33);
		btn_suppMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(btn_suppMembre);
		
		textField_inputNomAModif = new JTextField();
		textField_inputNomAModif.setColumns(10);
		textField_inputNomAModif.setBounds(353, 353, 180, 20);
		textField_inputNomAModif.setVisible(false);
		add(textField_inputNomAModif);
		
		textField_nomAModif = new JTextField();
		textField_nomAModif.setText("    Nom:");
		textField_nomAModif.setColumns(10);
		textField_nomAModif.setBounds(301, 353, 40, 20);
		textField_nomAModif.setVisible(false);
		add(textField_nomAModif);
		
		textField_CodeSecretAModif = new JTextField();
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
}
