package Main;

public class Film {

	//Attributs
		private String titre;
		private int annee;
		private double prixLocation;
		private double prixAchat;
		private int stock; //quantité
		private String categorie;
		
		
	//Constructeur
		public Film(String titre, int annee, double prixLocation, double prixAchat, int stock, String categorie) {
			this.titre = titre;
			this.annee = annee;
			this.prixLocation = prixLocation;
			this.prixAchat = prixAchat;
			this.stock = stock;
			this.categorie = categorie;
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
