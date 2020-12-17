package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import GUI.*;
import GUI.InventairePanel;
import net.proteanit.sql.DbUtils;

public class Film {

	//Attributs
		private String titre;
		private int annee;
		private double prixLocation;
		private double prixAchat;
		private int stock; //quantité
		private String categorie;
		static Connection conn =sqliteConnection.dbConnector();
		
	//Constructeur
		public Film(String titre, int annee, double prixLocation, double prixAchat, int stock, String categorie) {
			this.titre = titre;
			this.annee = annee;
			this.prixLocation = prixLocation;
			this.prixAchat = prixAchat;
			this.stock = stock;
			this.categorie = categorie;
		}
		
		//Methode pour la creation des films
	public static void creer_film() {
		String Titre = InventairePanel.getTitre().getText();
		String Année = InventairePanel.getAnnée().getText();
		String Prixdelocation= InventairePanel.getPrixdelocation().getText();
		//Integer CodeValue1 = Integer.parseInt(InventairePanel.CodeValue);
		String Prixdachat= InventairePanel.getPrixdachat().getText();
		Integer Prixdachat1 = Integer.parseInt(Prixdachat);
		String Stock= InventairePanel.getStock().getText();
		String Categorie= InventairePanel.getCategorie().getText();
		
		
     try {
        	
		//String query = "INSERT INTO MembreInfo (`Nom`,Telephone,Credit,CodeSecret) Values("+NomValue+","+TelValue+","+CreditValue2+","+CodeValue2+")";*/
       	String query = "INSERT INTO FilmInfo (Titre,Annee,PrixDeLocation,PrixAchat,Stock,Categorie) Values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, Titre);
			pst.setString(2, Année);
			pst.setString(3, Prixdelocation);
			pst.setInt(4, Prixdachat1);
			pst.setString(5, Stock);
			pst.setString(6, Categorie);
		

			boolean rs = pst.execute();
		
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();				}
		
	}
		
		// permet d'affichier la table de films
				public static void loadTableFilms() {
					try {
						String query = "select * from FilmInfo";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						InventairePanel.getTableInventaire().setModel(DbUtils.resultSetToTableModel(rs));
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}

	
		
	//Getters (Accesseurs)
		public String getTitre(){
			return this.titre;
		}
		
		public int getAnnee(){
			return this.annee;
		}
	
		public double getPrixLocation(){
			return this.prixLocation;
		}
	
		public double getPrixAchat(){
			return this.prixAchat;
		}
		
		public int getStock(){
			return this.stock;
		}
		
		public String getCategorie(){
			return this.categorie;
		}
	
		
	//Setters (Mutateurs)
		public void setTitre(String titre){
			this.titre = titre;
		}
		
		public void setAnnee(int annee){
			this.annee = annee;
		}
	
		public void setPrixLocation(double prixLocation){
			this.prixLocation = prixLocation;
		}
	
		public void setPrixAchat(double prixAchat){
			this.prixAchat = prixAchat;
		}
		
		public void setStock(int stock){
			this.stock = stock;
		}
		
		public void setCategorie(String categorie){
			this.categorie = categorie;
		}
		
	
	
	
	
}
