package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import GUI.*;
import net.proteanit.sql.DbUtils;



public class Membre {
	
	//Attributs
		private String nom;
		private String noTelephone;
		private int noCarte;
		private int codeSecret;
		static Connection conn =sqliteConnection.dbConnector();
		
	//Constructeur
		public Membre(String nom, String noTelephone, int noCarte, int codeSecret) {
			this.nom = nom;
			this.noTelephone = noTelephone;
			this.noCarte = noCarte;
			this.codeSecret = codeSecret;
		}
		//Methode pour la modification des des membres dans la base de donnees
		public static void modifier_membre() {
			
			String nom= MembrePanel.getNom().getText();
			String Telephone = MembrePanel.getTelephone().getText();
			//Integer Telephone1 = Integer.parseInt(Telephone);
			String CodeSecret= MembrePanel.getCodeSecret().getText();
			Integer CodeSecret1 = Integer.parseInt(CodeSecret);
			String Cartedecredit = MembrePanel.getCartedecredit().getText();
			 int row = MembrePanel.getTable().getSelectedRow();
		        Object id =  MembrePanel.getModel().getValueAt(row, 0);	
			
	     try {
	    
			
	       	String query = "UPDATE MembreInfo SET Nom = ?, Telephone = ?, CodeSecret = ?, credit = ? WHERE ID = ?" + id;
				PreparedStatement pst = conn.prepareStatement(query);
				pst.setString(1, nom);
				pst.setString(2, Telephone);
				pst.setInt(3, CodeSecret1);
				pst.setString(4, Cartedecredit);
			//	pst.setInt(5, id);
				

				boolean rs = pst.execute();
			
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();				}
			
		}
		// permet d'affichier la table des membres
		public static void loadTablemembres() {
			try {
				String query = "select * from MembreInfo";
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				MembrePanel.getTable().setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		
				
	//dfghdghdfgh
	//Getters (Accesseurs)
		public String getNom(){
			return this.nom;
		}
		
		public String getNoTelepone(){
			return this.noTelephone;
		}
	
		public int getNoCarte(){
			return this.noCarte;
		}
	
		public int getCodeSecret(){
			return this.codeSecret;
		}
		
		
	//Setters (Mutateurs)
		public void setNom(String nom){
			this.nom = nom;
		}
		
		public void setNoTelepone(String noTelephone){
			this.noTelephone = noTelephone;
		}
	
		public void setNoCarte(int noCarte){
			this.noCarte = noCarte;
		}
	
		public void setCodeSecret(int codeSecret){
			this.codeSecret = codeSecret;
		}
	
		
		
//		public static void createMembre(String nom, String noTelephone, int noCarte, int codeSecret)
//		{
//			Membre membre = new Membre(nom, noTelephone, noCarte, codeSecret);
//		}
//		
//		
//		public static void ajouterMembreADatabase()
//		{
//			
//		}
		
		
		
}
