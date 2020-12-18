package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import GUI.InventairePanel;
import net.proteanit.sql.DbUtils;

public class Film {

	//Attributs
		private String titre;
		private int annee;
		private double prixLocation;
		private double prixAchat;
		private int stock; 
		private String categorie;
		static Connection conn = sqliteConnection.dbConnector();
		
	//Constructeur
		public Film(String titre, int annee, double prixLocation, double prixAchat, int stock, String categorie) {
			this.titre = titre;
			this.annee = annee;
			this.prixLocation = prixLocation;
			this.prixAchat = prixAchat;
			this.stock = stock;
			this.categorie = categorie;
		}
		
	//Getters (Accesseurs object Film)
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
	
		
	//Setters (Mutateurs object Film)
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
		
		
		
		
	//Methode pour la creation des films
	public static void creer_film() {
		String Titre = InventairePanel.getTitre().getText();
		String Annee = InventairePanel.getAnnee().getText();
		Double Prixdelocation= Double.parseDouble(InventairePanel.getPrixdelocation().getText());
		Double Prixachat= Double.parseDouble(InventairePanel.getPrixdachat().getText());
		String Nouveaute = (InventairePanel.getNouveaute().getText());
		String Bluray = (InventairePanel.getBluray().getText());
		String Stock= InventairePanel.getStock().getText();
		String Categorie= InventairePanel.getCategorie().getText();
		System.out.println(Nouveaute);
		
	     try {
	    	 
		 	String query = "INSERT INTO FilmInfo (Titre,Annee,PrixDeLocation,PrixAchat,Nouveaute,Bluray,Stock,Categorie) Values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, Titre);
			pst.setString(2, Annee);
			pst.setDouble(3, Prixdelocation);
			pst.setDouble(4, Prixachat);
			pst.setString(5, Nouveaute);
			pst.setString(6, Bluray);
			pst.setString(7, Stock);
			pst.setString(8, Categorie);
			pst.execute();
				
		} catch (SQLException e1) {
			e1.printStackTrace();				
		}
	}
	
	
	//La methode supprimer_Membre permet de supprimer un employer de la base de donnees.
	public static void supprimer_film() {
		
		int row = InventairePanel.getTableInventaire().getSelectedRow();
        int id = (Integer) InventairePanel.getTableInventaire().getModel().getValueAt(row, 0);	
        
        try {
        	
			String query = "delete from FilmInfo where ID= "+ id  ;
			PreparedStatement pst = conn.prepareStatement(query);
			pst.execute();
			String query1 = "select * from FilmInfo";
			PreparedStatement pst1 = conn.prepareStatement(query1);
			ResultSet rs1 = pst1.executeQuery();
			InventairePanel.getTableInventaire().setModel(DbUtils.resultSetToTableModel(rs1));
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	
	//Methode pour la modification des films dans la base de donnees
	public static void modifier_film() {
		
		//Chercher les données rentrées par l'employé
		int newId = Integer.parseInt(InventairePanel.getId().getText());
		String Titre = InventairePanel.getTitre().getText();
		int Annee = Integer.parseInt(InventairePanel.getAnnee().getText());
		Double PrixDeLocation= Double.parseDouble(InventairePanel.getPrixdelocation().getText());
		Double PrixAchat= Double.parseDouble(InventairePanel.getPrixdachat().getText());
		Boolean Nouveaute = Boolean.parseBoolean(InventairePanel.getNouveaute().getText());
		Boolean Bluray = Boolean.parseBoolean(InventairePanel.getBluray().getText());
		int Stock= Integer.parseInt(InventairePanel.getStock().getText());
		String Categorie= InventairePanel.getCategorie().getText();
		
		//Chercher la ligne sélectionner par l'employé
		int row = InventairePanel.getTableInventaire().getSelectedRow();
		int id = (int) InventairePanel.getTableInventaire().getValueAt(row, 0);	
		
		//Modifier les données dans la database
		try {
	       	String query = "UPDATE FilmInfo SET ID = ?, Titre = ?, Annee = ?, PrixDeLocation = ?, PrixAchat = ?, Nouveaute = ?, Bluray = ?, Stock = ?, Categorie = ? WHERE ID = ?";
    	 	PreparedStatement pst = conn.prepareStatement(query);
    	 	
    	 	pst.setInt(1, newId);
    	 	pst.setString(2, Titre);
			pst.setInt(3, Annee);
			pst.setDouble(4, PrixDeLocation);
			pst.setDouble(5, PrixAchat);
			pst.setBoolean(6, Nouveaute);
			pst.setBoolean(7, Bluray);
			pst.setInt(8, Stock);
			pst.setString(9, Categorie);
			pst.setInt(10, id);
			pst.execute();
		
			
		} catch (SQLException e1) {
			e1.printStackTrace();				
		}
	}

		
	
	//Méthode permettant de réafficher la table de films (updater)
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
	
	
}
