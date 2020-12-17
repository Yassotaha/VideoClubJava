package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import Main.sqliteConnection;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Main.sqliteConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentePanel extends JPanel {
	
	public static Connection connection = null;
	private JLabel lblPopcornamount;
	private JLabel lblBonbonsamount;
	private int TotalPopcorn = 0;
	private int TotalBonbons = 0;
	private int i = 1;
	private JTable table;
	private JTextField EntrerCodeProduit;
	private JLabel Total;
	private boolean isAchat;

	/**
	 * Create the panel.
	 */
	public VentePanel() {
		connection = sqliteConnection.dbConnector();
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		JLabel lblPopcornamount = new JLabel("PopcornAmount");
		lblPopcornamount.setBounds(293, 91, 65, 14);
		add(lblPopcornamount);
		
		JButton btnPopcorn = new JButton("Popcorn:");
		btnPopcorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TotalPopcorn += i;
				
				
				String TotalPopcornString = Float.toString(TotalPopcorn);
				   
			    
				lblPopcornamount.setText(String.format(TotalPopcornString));
				
			}
		});
		btnPopcorn.setBounds(155, 61, 128, 74);
		add(btnPopcorn);
		
		JLabel lblBonbonsamount = new JLabel("BonbonsAmount");
		lblBonbonsamount.setBounds(672, 91, 65, 14);
		add(lblBonbonsamount);
		
		JButton btnBonbons = new JButton("Bonbons:");
		btnBonbons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TotalBonbons += i;
				
				String TotalBonbonString = Float.toString(TotalBonbons);
				
				
				lblBonbonsamount.setText(String.format(TotalBonbonString));
			}
		});
		btnBonbons.setBounds(534, 61, 128, 74);
		add(btnBonbons);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 160, 859, 144);
		add(scrollPane);
		
		
		/*Object[] columns = {"ID","Firstname","Lastname","Age","Firstname","Lastname","Age"};*/
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = new DefaultTableModel(); 
		//model.setColumnIdentifiers(columns);
		
		model.addColumn("ID");
		model.addColumn("Titre");
		model.addColumn("Année");
		model.addColumn("Prix");
		model.addColumn("Stock");
		model.addColumn("Catégorie");
		
			//table.setModel(model);
		
		
		
		
		
		JRadioButton rdbtnLouer = new JRadioButton("Louer");
		rdbtnLouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
					boolean isAchat = false;
					
					
					
			}
		});
		rdbtnLouer.setBounds(52, 371, 109, 23);
		add(rdbtnLouer);
		
		
		JRadioButton rdbtnAcheter = new JRadioButton("Acheter");
		
		
		rdbtnAcheter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
		
			boolean isAchat = true;
			
			
			
			
			}
			
					
		});
		
		
		
		
		
		rdbtnAcheter.setBounds(52, 333, 109, 23);
		add(rdbtnAcheter);
		
		EntrerCodeProduit = new JTextField();
		EntrerCodeProduit.setBounds(178, 349, 143, 22);
		add(EntrerCodeProduit);
		EntrerCodeProduit.setColumns(10);
		
		JLabel lblCodeProduit = new JLabel("Code produit");
		lblCodeProduit.setBounds(221, 333, 78, 14);
		add(lblCodeProduit);
		

		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (EntrerCodeProduit.getText() == null) {
				JOptionPane.showMessageDialog(null, "Veuillez cochez une option Acheter ou Louez");
				}
				else {
				
				String textFieldValue = EntrerCodeProduit.getText();
				int cher = Integer.parseInt(textFieldValue);
				
				try {
					String query = "select * from FilmInfo where ID = " + cher;
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					//Ajouter une variable une row pour l'affichage
					//https://stackoverflow.com/questions/3549206/how-to-add-row-in-jtable#:~:text=To%20create%20the%20table%20with,model%20%3D%20(DefaultTableModel)%20table
					//https://www.tutorialspoint.com/java-resultset-insertrow-method-with-example
					
					Object[] row = new Object[6];
					
					//System.out.print(isAchat);
					
					if (rdbtnLouer.isSelected()) {
					
				
					row [0] = rs.getInt("ID");
					row [1] = rs.getString("Titre");
					row [2] = rs.getInt("Année");
					row [3] = rs.getDouble("Prix de location");
					row [4] = rs.getInt("Stock");
					row [5] = rs.getString("Catégorie");
					
					model.addRow(row);
					table.setModel(model);
					
					}
					else if (rdbtnAcheter.isSelected()) {
						row [0] = rs.getInt("ID");
						row [1] = rs.getString("Titre");
						row [2] = rs.getInt("Année");
						row [3] = rs.getDouble("Prix d'achat");
						row [4] = rs.getInt("Stock");
						row [5] = rs.getString("Catégorie");
						model.addRow(row);
						table.setModel(model);
						
						
					   }
					double total = 0;
					
				    for(int i = 0; i < table.getRowCount(); i++){
				       
				        double MontantAchat = Double.parseDouble(table.getValueAt(i, 3)+"");
				        total = MontantAchat+total;
				        //System.out.println(total);
				    }
				    
				   total = total + (TotalPopcorn*3) + (TotalBonbons*1.5);
				   
				    float TotalFloat = (float)total;
				    
				    String TotalFinal = Float.toString(TotalFloat);
				   
				    
				   Total.setText(String.format(TotalFinal));
					
					
					
					
				
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				EntrerCodeProduit.setText("");
				rdbtnLouer.setSelected(false);
				rdbtnAcheter.setSelected(false);
			}
			}
		});
		btnAjouter.setBounds(354, 349, 89, 23);
		add(btnAjouter);
		
		
		JLabel lblTotal = new JLabel("Total : ");
		lblTotal.setBounds(729, 353, 48, 14);
		add(lblTotal);
		
		Total = new JLabel();
		Total.setBounds(739, 371, 150, 56);
		add(Total);
		
		JButton btnPayer = new JButton("Payer");
		btnPayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Facture imprimée");
			
				int rowCount = model.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
				    model.removeRow(i);
				}
				
				TotalPopcorn = 0;
				TotalBonbons = 0;
				
				lblPopcornamount.setText("");
				lblBonbonsamount.setText("");
				Total.setText("");
			}
			});
		btnPayer.setBounds(562, 371, 157, 56);
		add(btnPayer);
		
		JButton btnRecommencer = new JButton("Recommencer");
		btnRecommencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rowCount = model.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
				    model.removeRow(i);
				}
				
				TotalPopcorn = 0;
				TotalBonbons = 0;
				
				lblPopcornamount.setText("");
				lblBonbonsamount.setText("");
				Total.setText("");
				
			}
		});
		btnRecommencer.setBounds(354, 388, 109, 23);
		add(btnRecommencer);
		
		
		
		

		

	}
}
