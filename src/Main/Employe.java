package Main;

public class Employe {
	
	
	//Variable static pour enregistrer le login de l'employée
		public static boolean estSup = false;
	
		
	//Attributs
		protected String id;
		protected String password;
		protected Boolean isSuperviseur;
		
		
	//Constructeur
		public Employe(String id, String password) {
			this.id = id;
			this.password = password;
			this.isSuperviseur = false;
		}
		

	//Getters (Accesseurs)
		public String getId(){
			return this.id;
		}
		
		public String getPassword(){
			return this.password;
		}

		public Boolean getIsSuperviseur(){
			return this.isSuperviseur;
		}
	//Setters (Mutateurs)
		public void setId(String id){
			this.id = id;
		}
		
		public void setPassword(String password){
			this.password = password;
		}

		public void setIsSuperviseur(Boolean isSuperviseur){
			this.isSuperviseur = isSuperviseur;
		}


	//Méthode pour get et set la variable static pour enregistrer le login de l'employée
		public static boolean getEstSup() {
			return estSup;
		}
		
		public static void setEstSup(boolean estSup) {
			Employe.estSup = estSup;
		}
		
		
}
