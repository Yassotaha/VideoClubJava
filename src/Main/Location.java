package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Location {
	
	public static Connection connection = null;
	
	
	public static void calculeRetard() throws ParseException {
	connection = sqliteConnection.dbConnector();
	
	
	
	try {
		//LocalDate now = LocalDate.now();
		String now = "2020-12-17";
		
		Object[] tableauAmende1 = new Object[5];
		
		String query1 = "select * from Retard where IDMembre = "+2;
		PreparedStatement pst1;
		pst1 = connection.prepareStatement(query1);
		ResultSet rs1 = pst1.executeQuery();
		
		
		tableauAmende1[0] = rs1.getInt("IDMembre");
		tableauAmende1[1] = rs1.getInt("IDFilm");
		tableauAmende1[2] = rs1.getString("DateFinLocation");
		tableauAmende1[3] = rs1.getInt("DureeLocation");
		tableauAmende1[4] = rs1.getDouble("Amende");

				
		String date1 = (String) tableauAmende1[2];
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
		
		Date firstDate1 = sdf1.parse(date1);
		Date secondDate1 = sdf1.parse(now);
		
		long diffInMillies1 = Math.abs(secondDate1.getTime()-firstDate1.getTime());		
		long diff1 = TimeUnit.DAYS.convert(diffInMillies1, TimeUnit.MILLISECONDS);
				
		double amendeTotal1 = (diff1/(int)tableauAmende1[3])*(double)tableauAmende1[4];
		
		//Si la durée de location initiale est de 1 jour et
		//en retard de 2 à 9 jours
		if((int)tableauAmende1[3]==1 && diff1>=2 && diff1<10) {
			//Employer appel le client
			String resultat1 = "Le client ID: "+tableauAmende1[0]+" doit être contacter."+
					"Ce dernier à "+diff1+" \njours de retard sur le film ID: "+tableauAmende1[1]
					+", pour un total de "+amendeTotal1+"$ ";
			GUI.MainGUI.amende1 = resultat1;
			
		}
		
		///Si la durée de location initiale est de 1 jour et
		//en retard de 10 jours et plus, facturer le total sur la carte de crédit
		else if((int)tableauAmende1[3]==1 && diff1>=10 ) {
			//Facturer le film au complet
			amendeTotal1+=10+20;
			String resultat1 = "Le client ID: "+tableauAmende1[0]+" doit être contacter."+
					"Ce dernier à "+diff1+" \njours de retard sur le film ID: "+tableauAmende1[1]
					+", pour un total de "+amendeTotal1+"$ ";
			GUI.MainGUI.amende1 = resultat1;
			
		}
		
		//Si la durée de location initiale est de 7 jours et
		//en retard de 2 semaines à 59 jours
		else if((int)tableauAmende1[3]==7 && diff1>=14 && diff1<60) {
		//Employer appel le client
			String resultat1 = "Le client ID: "+tableauAmende1[0]+" doit être contacter."+
					"Ce dernier à "+diff1+" \njours de retard sur le film ID: "+tableauAmende1[1]
					+", pour un total de "+amendeTotal1+"$ ";
			GUI.MainGUI.amende1 = resultat1;
			
		}
		//Si la durée de location initiale est de 7 jours et
		//en retard 60 jours et plus, facturer le total sur la carte de crédit
		else if((int)tableauAmende1[3]==7 && diff1>=60) {
			amendeTotal1+=10+20;
			String resultat1 = "Le client ID: "+tableauAmende1[0]+" doit être contacter."+
					"Ce dernier à "+diff1+" \njours de retard sur le film ID: "+tableauAmende1[1]
					+", pour un total de "+amendeTotal1+"$ ";
			GUI.MainGUI.amende1 = resultat1;
			
		}
		
		
		
		Object[] tableauAmende2 = new Object[5];
		
		String query2 = "select * from Retard where IDMembre = "+5;
		PreparedStatement pst2;
		pst2 = connection.prepareStatement(query2);
		ResultSet rs2 = pst2.executeQuery();
		
		tableauAmende2[0] = rs2.getInt("IDMembre");
		tableauAmende2[1] = rs2.getInt("IDFilm");
		tableauAmende2[2] = rs2.getString("DateFinLocation");
		tableauAmende2[3] = rs2.getInt("DureeLocation");
		tableauAmende2[4] = rs2.getDouble("Amende");
		
		String date2 = (String) tableauAmende2[2];
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
		
		Date firstdate2 = sdf2.parse(date2);
		Date seconddate2 = sdf2.parse(now);
		
		long diffInMillies2 = Math.abs(seconddate2.getTime()-firstdate2.getTime());		
		long diff2 = TimeUnit.DAYS.convert(diffInMillies2, TimeUnit.MILLISECONDS);
				
		double amendeTotal2 = (diff2/(int)tableauAmende2[3])*(double)tableauAmende2[4];
		
		//Si la durée de location initiale est de 1 jour et
		//en retard de 2 à 9 jours
		if((int)tableauAmende2[3]==1 && diff2>=2 && diff2<10) {
			//Employer appel le client
			String resultat2 = "Le client ID: "+tableauAmende2[0]+" doit être contacter."+
					"Ce dernier à "+diff2+" \njours de retard sur le film ID: "+tableauAmende2[1]
					+", pour un total de "+amendeTotal2+"$ ";
			GUI.MainGUI.amende2 = resultat2;
			
		}
		
		///Si la durée de location initiale est de 1 jour et
		//en retard de 10 jours et plus, facturer le total sur la carte de crédit
		else if((int)tableauAmende2[3]==1 && diff2>=10 ) {
			//Facturer le film au complet
			amendeTotal2+=10+20;
			String resultat2 = "Le client ID: "+tableauAmende2[0]+" doit être contacter."+
					"Ce dernier à "+diff2+" \njours de retard sur le film ID: "+tableauAmende2[1]
					+", pour un total de "+amendeTotal2+"$ ";
			GUI.MainGUI.amende2 = resultat2;
			
		}
		
		//Si la durée de location initiale est de 7 jours et
		//en retard de 2 semaines à 59 jours
		else if((int)tableauAmende2[3]==7 && diff2>=14 && diff2<60) {
		//Employer appel le client
			String resultat2 = "Le client ID: "+tableauAmende2[0]+" doit être contacter."+
					"Ce dernier à "+diff2+" \njours de retard sur le film ID: "+tableauAmende2[1]
					+", pour un total de "+amendeTotal2+"$ ";
			GUI.MainGUI.amende2 = resultat2;
			
		}
		//Si la durée de location initiale est de 7 jours et
		//en retard 60 jours et plus, facturer le total sur la carte de crédit
		else if((int)tableauAmende2[3]==7 && diff2>=60) {
			amendeTotal2+=10+20;
			String resultat2 = "Le client ID: "+tableauAmende2[0]+" doit être contacter."+
					"Ce dernier à "+diff2+" \njours de retard sur le film ID: "+tableauAmende2[1]
					+", pour un total de "+amendeTotal2+"$ ";
			GUI.MainGUI.amende2 = resultat2;
			
		}
			
		
		Object[] tableauAmende3 = new Object[5];
		
		String query3 = "select * from Retard where IDMembre = "+6;
		PreparedStatement pst3;
		pst3 = connection.prepareStatement(query3);
		ResultSet rs3 = pst3.executeQuery();
		
		tableauAmende3[0] = rs3.getInt("IDMembre");
		tableauAmende3[1] = rs3.getInt("IDFilm");
		tableauAmende3[2] = rs3.getString("DateFinLocation");
		tableauAmende3[3] = rs3.getInt("DureeLocation");
		tableauAmende3[4] = rs3.getDouble("Amende");
		

		String date3 = (String) tableauAmende3[2];
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
		
		Date firstdate3 = sdf3.parse(date3);
		Date seconddate3 = sdf3.parse(now);
		
		long diffInMillies3 = Math.abs(seconddate3.getTime()-firstdate3.getTime());		
		long diff3 = TimeUnit.DAYS.convert(diffInMillies3, TimeUnit.MILLISECONDS);
				
		double amendeTotal3;
		
		//Si la durée de location initiale est de 1 jour et
		//en retard de 2 à 9 jours
		if((int)tableauAmende3[3]==1 && diff3>=2 && diff3<10) {
			//Employer appel le client
			amendeTotal3 = (int)(diff3/(int)tableauAmende3[3])*(double)tableauAmende3[4];
			String resultat3 = "Le client ID: "+tableauAmende3[0]+" doit être contacter."+
					"Ce dernier à "+diff3+" \njours de retard sur le film ID: "+tableauAmende3[1]
					+", pour un total de "+amendeTotal3+"$ ";
			GUI.MainGUI.amende3 = resultat3;
			
		}
		
		///Si la durée de location initiale est de 1 jour et
		//en retard de 10 jours et plus, facturer le total sur la carte de crédit
		else if((int)tableauAmende3[3]==1 && diff3>=10 ) {
			//Facturer le film au complet
			amendeTotal3 = (int)(10*(double)tableauAmende3[4])+10+20;
			String resultat3 = "Le client ID: "+tableauAmende3[0]+" doit être contacter."+
					"Ce dernier à "+diff3+" \njours de retard sur le film ID: "+tableauAmende3[1]
					+", pour un total de "+amendeTotal3+"$ ";
			GUI.MainGUI.amende3 = resultat3;
			
		}
		
		//Si la durée de location initiale est de 7 jours et
		//en retard de 2 semaines à 59 jours
		else if((int)tableauAmende3[3]==7 && diff3>=14 && diff3<60) {
		//Employer appel le client
			amendeTotal3 = (int)(diff3/(int)tableauAmende3[3])*(double)tableauAmende3[4];
			String resultat3 = "Le client ID: "+tableauAmende3[0]+" doit être contacter."+
					"Ce dernier à "+diff3+" \njours de retard sur le film ID: "+tableauAmende3[1]
					+", pour un total de "+amendeTotal3+"$ ";
			GUI.MainGUI.amende3 = resultat3;
			
		}
		//Si la durée de location initiale est de 7 jours et
		//en retard 60 jours et plus, facturer le total sur la carte de crédit
		else if((int)tableauAmende3[3]==7 && diff3>=60) {
			amendeTotal3 = (int)(60*(double)tableauAmende3[4])+10+20;
			String resultat3 = "Le client ID: "+tableauAmende3[0]+" doit être contacter."+
					"Ce dernier à "+diff3+" \njours de retard sur le film ID: "+tableauAmende3[1]
					+", pour un total de "+amendeTotal3+"$ ";
			GUI.MainGUI.amende3 = resultat3;
			
		}
			

		
		Object[] tableauAmende4 = new Object[5];
		
		String query4 = "select * from Retard where IDMembre = "+9;
		PreparedStatement pst4;
		pst4 = connection.prepareStatement(query4);
		ResultSet rs4 = pst4.executeQuery();
		
		
		tableauAmende4[0] = rs4.getInt("IDMembre");
		tableauAmende4[1] = rs4.getInt("IDFilm");
		tableauAmende4[2] = rs4.getString("DateFinLocation");
		tableauAmende4[3] = rs4.getInt("DureeLocation");
		tableauAmende4[4] = rs4.getDouble("Amende");
		


		String date4 = (String) tableauAmende4[2];
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
		
		Date firstdate4 = sdf4.parse(date4);
		Date seconddate4 = sdf4.parse(now);
		
		long diffInMillies4 = Math.abs(seconddate4.getTime()-firstdate4.getTime());		
		long diff4 = TimeUnit.DAYS.convert(diffInMillies4, TimeUnit.MILLISECONDS);
				
		double amendeTotal4 = (diff4/(int)tableauAmende4[3])*(double)tableauAmende4[4];
		
		//Si la durée de location initiale est de 1 jour et
		//en retard de 2 à 9 jours
		if((int)tableauAmende4[3]==1 && diff4>=2 && diff4<10) {
			//Employer appel le client
			String resultat4 = "Le client ID: "+tableauAmende4[0]+" doit être contacter."+
					"Ce dernier à "+diff4+" \njours de retard sur le film ID: "+tableauAmende4[1]
					+", pour un total de "+amendeTotal4+"$ ";
			GUI.MainGUI.amende4 = resultat4;
			
		}
		
		///Si la durée de location initiale est de 1 jour et
		//en retard de 10 jours et plus, facturer le total sur la carte de crédit
		else if((int)tableauAmende4[3]==1 && diff4>=10 ) {
			//Facturer le film au complet
			amendeTotal4+=10+20;
			String resultat4 = "Le client ID: "+tableauAmende4[0]+" doit être contacter."+
					"Ce dernier à "+diff4+" \njours de retard sur le film ID: "+tableauAmende4[1]
					+", pour un total de "+amendeTotal4+"$ ";
			GUI.MainGUI.amende4 = resultat4;
			
		}
		
		//Si la durée de location initiale est de 7 jours et
		//en retard de 2 semaines à 59 jours
		else if((int)tableauAmende4[3]==7 && diff4>=14 && diff4<60) {
		//Employer appel le client
			String resultat4 = "Le client ID: "+tableauAmende4[0]+" doit être contacter."+
					"Ce dernier à "+diff4+" \njours de retard sur le film ID: "+tableauAmende4[1]
					+", pour un total de "+amendeTotal4+"$ ";
			GUI.MainGUI.amende4 = resultat4;
			
		}
		//Si la durée de location initiale est de 7 jours et
		//en retard 60 jours et plus, facturer le total sur la carte de crédit
		else if((int)tableauAmende4[3]==7 && diff4>=60) {
			amendeTotal4+=10+20;
			String resultat4 = "Le client ID: "+tableauAmende4[0]+" doit être contacter."+
					"Ce dernier à "+diff4+" \njours de retard sur le film ID: "+tableauAmende4[1]
					+", pour un total de "+amendeTotal4+"$ ";
			GUI.MainGUI.amende4 = resultat4;
			
		}
			
		
		Object[] tableauAmende5 = new Object[5];
		
		String query5 = "select * from Retard where IDMembre = "+10;
		PreparedStatement pst5;
		pst5 = connection.prepareStatement(query5);
		ResultSet rs5 = pst5.executeQuery();
		
		
		tableauAmende5[0] = rs5.getInt("IDMembre");
		tableauAmende5[1] = rs5.getInt("IDFilm");
		tableauAmende5[2] = rs5.getString("DateFinLocation");
		tableauAmende5[3] = rs5.getInt("DureeLocation");
		tableauAmende5[4] = rs5.getDouble("Amende");
		

		String date5 = (String) tableauAmende5[2];
		
		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
		
		Date firstdate5 = sdf5.parse(date5);
		Date seconddate5 = sdf5.parse(now);
		
		long diffInMillies5 = Math.abs(seconddate5.getTime()-firstdate5.getTime());		
		long diff5 = TimeUnit.DAYS.convert(diffInMillies5, TimeUnit.MILLISECONDS);
				
		double amendeTotal5;
		
		//Si la durée de location initiale est de 1 jour et
		//en retard de 2 à 9 jours
		if((int)tableauAmende5[3]==1 && diff5>=2 && diff5<10) {
			//Employer appel le client
			amendeTotal5 = (int)(diff5/(int)tableauAmende5[3])*(double)tableauAmende5[4];
			String resultat5 = "Le client ID: "+tableauAmende5[0]+" doit être contacter."+
					"Ce dernier à "+diff5+" \njours de retard sur le film ID: "+tableauAmende5[1]
					+", pour un total de "+amendeTotal5+"$ ";
			GUI.MainGUI.amende5 = resultat5;
			
		}
		
		///Si la durée de location initiale est de 1 jour et
		//en retard de 10 jours et plus, facturer le total sur la carte de crédit
		else if((int)tableauAmende5[3]==1 && diff5>=10 ) {
			//Facturer le film au complet
			amendeTotal5 = (int)(10*(double)tableauAmende5[4])+10+20;
			String resultat5 = "Le client ID: "+tableauAmende5[0]+" doit être contacter."+
					"Ce dernier à "+diff5+" \njours de retard sur le film ID: "+tableauAmende5[1]
					+", pour un total de "+amendeTotal5+"$ ";
			GUI.MainGUI.amende5 = resultat5;
			
		}
		
		//Si la durée de location initiale est de 7 jours et
		//en retard de 2 semaines à 59 jours
		else if((int)tableauAmende5[3]==7 && diff5>=14 && diff5<60) {
		//Employer appel le client
			amendeTotal5 = (int)(diff5/(int)tableauAmende5[3])*(double)tableauAmende5[4];
			String resultat5 = "Le client ID: "+tableauAmende5[0]+" doit être contacter."+
					"Ce dernier à "+diff5+" \njours de retard sur le film ID: "+tableauAmende5[1]
					+", pour un total de "+amendeTotal5+"$ ";
			GUI.MainGUI.amende5 = resultat5;
			
		}
		//Si la durée de location initiale est de 7 jours et
		//en retard 60 jours et plus, facturer le total sur la carte de crédit
		else if((int)tableauAmende5[3]==7 && diff5>=60) {
			amendeTotal5 = (int)(60*(double)tableauAmende5[4])+10+20;
			String resultat5 = "Le client ID: "+tableauAmende5[0]+" doit être contacter."+
					"Ce dernier à "+diff5+" \njours de retard sur le film ID: "+tableauAmende5[1]
					+", pour un total de "+amendeTotal5+"$ ";
			GUI.MainGUI.amende5 = resultat5;
			
		}
					
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	}
}
