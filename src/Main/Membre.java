package Main;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import GUI.*;
import net.proteanit.sql.DbUtils;



public class Membre {
	
	//Attributs
		private String nom;
		private String noTelephone;
		private int noCarte;
		private int codeSecret;
		static Connection conn =sqliteConnection.dbConnector();
		
	//Constructeur pour membre
		public Membre(String nom, String noTelephone, int noCarte, int codeSecret) {
			this.nom = nom;
			this.noTelephone = noTelephone;
			this.noCarte = noCarte;
			this.codeSecret = codeSecret;
		}
		//La methode supprimer_Membre permet de supprimer un employer de la base de donnees.
		public static void supprimer_membre() {
		
		
		int row = MembrePanel.getTable().getSelectedRow();
        Integer id = (Integer) MembrePanel.getTable().getModel().getValueAt(row, 0);	
        
        
        try {
        	
			String query = "delete from MembreInfo where ID= "+ id  ;
			PreparedStatement pst = conn.prepareStatement(query);
			pst.execute();
			String query1 = "select ID,Nom,Telephone from MembreInfo";
			PreparedStatement pst1 = conn.prepareStatement(query1);
			ResultSet rs1 = pst1.executeQuery();
			MembrePanel.getTable().setModel(DbUtils.resultSetToTableModel(rs1));
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	 //La methode enregistrer_employer permet d'enregistrer un nouveau membre dans la base de donnees
		public static void Creer_membre() {
		
		String NomValue = MembrePanel.getNom().getText();
		String TelValue = MembrePanel.getTelephone().getText();
		
		String CreditValue= MembrePanel.getCartedecredit().getText();
		
		
		String CodeValue= MembrePanel.getCodeSecret().getText();
		Integer CodeValue1 = Integer.parseInt(CodeValue);
		
		
		
     try {
        	
		
       	String query = "INSERT INTO MembreInfo (`Nom`,Telephone,Credit,CodeSecret) Values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, NomValue);
			pst.setString(2, TelValue);
			pst.setString(3, CreditValue);
			pst.setInt(4, CodeValue1);

			pst.execute();
		String query1 = "select ID,Nom,Telephone from MembreInfo";
			PreparedStatement pst1 = conn.prepareStatement(query1);
			ResultSet rs1 = pst1.executeQuery();
			MembrePanel.getTable().setModel(DbUtils.resultSetToTableModel(rs1));
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();			
			}
}

		
	
		
		//Methode pour la modification des des membres dans la base de donnees
		public static void modifier_membre() {
			
			String nom1 = MembrePanel.getNom().getText();
			String Telephone = MembrePanel.getTelephone().getText();
			//Integer Telephone1 = Integer.parseInt(Telephone);
			String CodeSecret= MembrePanel.getCodeSecret().getText();
			Integer CodeSecret1 = Integer.parseInt(CodeSecret);
			String Cartedecredit = MembrePanel.getCartedecredit().getText();
			
			int row = MembrePanel.getTable().getSelectedRow();
			
		    int id = (int) MembrePanel.getModel().getValueAt(row, 0);	
			

			
	     try {
	    
			

	    	String query = "UPDATE MembreInfo SET Nom = ?, Telephone = ?, CodeSecret = ?, credit = ? WHERE ID = ?";
				
	    	 	PreparedStatement pst = conn.prepareStatement(query);
				pst.setString(1, nom1);
				pst.setString(2, Telephone);
				pst.setInt(3, CodeSecret1);
				pst.setString(4, Cartedecredit);
				pst.setInt(5, id);
				

				 pst.execute();
			
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();				
			}
			
		}
		
		// permet d'affichier la table des membres
		public static void loadTablemembres() {
			try {
				String query = "select ID,Nom,Telephone from MembreInfo";
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				MembrePanel.getTable().setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		
				
	
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
	
		
		
		
		

		
}
