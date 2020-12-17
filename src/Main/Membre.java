package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import GUI.*;



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
