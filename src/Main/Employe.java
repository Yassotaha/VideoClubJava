package Main;

public class Employe {

	//Attributs
		private String id;
		private String password;
		private Boolean isSuperviseur;
		
		
	//Constructeur
		public Employe(String id, String password, Boolean isSuperviseur) {
			this.id = id;
			this.password = password;
			this.isSuperviseur = isSuperviseur;
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


}
