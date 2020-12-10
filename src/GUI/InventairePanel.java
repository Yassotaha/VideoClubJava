package GUI;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
import Main.sqliteConnection;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;



import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

public class InventairePanel extends JPanel 
{
	//Variable du JPanel Inventaire
	private JTextField textFieldNbPopcorn;
	private JTable tableInventaire;
	private JScrollPane scrollPaneInventaire;
	private JTextField textFieldNbBonbon;
	private JLabel lblFilms;
	private JLabel lblPopcorn;
	private JLabel lblBonbon;
	
	public static Connection connection = null;

	
	//Créer le JPanel Inventaire
	public InventairePanel() 
	{
		connection = sqliteConnection.dbConnector();
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		
		lblPopcorn = new JLabel("Popcorn:");
		lblPopcorn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPopcorn.setBounds(226, 397, 84, 28);
		add(lblPopcorn);
		
		lblBonbon = new JLabel("Bonbon:");
		lblBonbon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBonbon.setBounds(514, 397, 75, 28);
		add(lblBonbon);
		
		lblFilms = new JLabel("Films:");
		lblFilms.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFilms.setBounds(23, 13, 84, 28);
		add(lblFilms);
		
		
		
		textFieldNbPopcorn = new JTextField();
		textFieldNbPopcorn.setText("45");
		textFieldNbPopcorn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNbPopcorn.setColumns(10);
		textFieldNbPopcorn.setBounds(324, 397, 53, 28);
		textFieldNbPopcorn.setEditable(false);
		add(textFieldNbPopcorn);
		
		
		
		
		textFieldNbBonbon = new JTextField();
		textFieldNbBonbon.setText("85");
		textFieldNbBonbon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNbBonbon.setColumns(10);
		textFieldNbBonbon.setBounds(600, 397, 53, 28);
		textFieldNbBonbon.setEditable(false);
		add(textFieldNbBonbon);
		
		
		
		scrollPaneInventaire = new JScrollPane();
		scrollPaneInventaire.setBounds(23, 42, 859, 207);
		add(scrollPaneInventaire);
		
		
		
		tableInventaire = new JTable();
		tableInventaire.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
		
		try {
			String query = "select * from FilmInfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableInventaire.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		tableInventaire.getColumnModel().getColumn(0).setPreferredWidth(168);
		tableInventaire.getColumnModel().getColumn(2).setPreferredWidth(68);
		tableInventaire.getColumnModel().getColumn(3).setPreferredWidth(89);
		tableInventaire.getColumnModel().getColumn(4).setPreferredWidth(48);
		tableInventaire.getColumnModel().getColumn(5).setPreferredWidth(116);
		tableInventaire.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPaneInventaire.setViewportView(tableInventaire);


	}
}