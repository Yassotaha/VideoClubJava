package Main;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class sqliteConnection {
	
Connection conn = null;
	
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

}
