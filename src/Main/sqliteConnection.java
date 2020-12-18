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
   //Connexion a la base de donnees
	public static Connection dbConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			String path = Paths.get("").toAbsolutePath().toString();
			String path_p = path+"\\UsersData.db";
			
			
			Connection conn=DriverManager.getConnection("jdbc:sqlite:"+path_p);
			
			return conn;
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	

	

}
