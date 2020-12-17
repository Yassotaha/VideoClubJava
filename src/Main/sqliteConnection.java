package Main;

import java.nio.file.Paths;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import GUI.*;
import net.proteanit.sql.DbUtils;


public class sqliteConnection {
	
static Connection conn =dbConnector();

	public static Connection dbConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			String path = Paths.get("").toAbsolutePath().toString();
			String path_p = path+"\\UsersData.db";
			
			
			Connection conn=DriverManager.getConnection("jdbc:sqlite:"+path_p);
			//OptionPane.showMessageDialog(null, "Connection Successfull");
			return conn;
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	/*
	//La methode supprimer_membre permet de supprimer un employer de la base de donnees "UsersData.db".
	public static void supprimer_membre() {
		try {
		String query = "delete from employee where empid = '"+ id"'";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.execute();
			pst.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}*/
	//La methode supprimer_film permet de supprimer un film de la base de donnees "UsersData.db".
		public static void supprimer_film() {
			
	
	        
			try {
				String query = "delete from FilmInfo where ID= "+ InventairePanel.getId_field().getText()  ;
				PreparedStatement pst = conn.prepareStatement(query);
				pst.execute();
				pst.executeUpdate();
				pst.close();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	//La methode chercher_article permet de chercher un produit dans la base de donnees a partir de son ID.
	public static void chercher_article() {
		try {
			Statement stmt = conn.createStatement();
		      String query[] = {
		         "SELECT * FROM FilmInfo where " ,  
		      };
		      
		      for(String q : query) {
		         ResultSet rs = stmt.executeQuery(q);
		         System.out.println("Names for query "+q+" are");
		         
		         while (rs.next()) {
		            String name = rs.getString("name");
		            System.out.print(name+"  ");
		         }
		         System.out.println();
		      }
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	

	

}
