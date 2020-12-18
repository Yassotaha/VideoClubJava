//test

package GUI;


import java.awt.Rectangle;

import Main.sqliteConnection;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
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



import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentePanel extends JPanel {
	
	public static Connection connection = null;
	private JLabel Total;
	private JTable table;
	private JTextField EntrerCodeProduit;
	private JRadioButton rdbtnAcheter;
	private JRadioButton rdbtnLouer;
	private JButton btnAjouter;
		private int TotalPopcorn = 0;
	private int TotalBonbons = 0;
	private int i = 1;

	/**
	 * Create the panel.
	 */
	public VentePanel() {
		connection = sqliteConnection.dbConnector();
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
	//JTable du "Panier"
		table = new JTable();
		
	//Model du JTable table
		DefaultTableModel model = new DefaultTableModel(); 
		
		model.addColumn("ID");
		model.addColumn("Titre");
		model.addColumn("Année");
		model.addColumn("Prix");
		model.addColumn("Nouveaute");
		model.addColumn("Bluray");
		model.addColumn("Stock");
		model.addColumn("Catégorie");
		
	//Affiche le prixTotal
		Total = new JLabel();
		Total.setBounds(739, 371, 150, 56);
		add(Total);
		Total.setText(String.format(""));
		
		JLabel lblPopcornamount = new JLabel("");
		lblPopcornamount.setBounds(293, 91, 65, 14);
		add(lblPopcornamount);
		
		JButton btnPopcorn = new JButton("Popcorn:");
		btnPopcorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//Ajoute Article Popcorn au "Panier"
				Object[] row = new Object[8];
				row [0] = "-";
				row [1] = "Popcorn";
				row [2] = "-";
				row [3] = "3.00";
				row [4] = "-";
				row [5] = "-";
				row [6] = "1";
				row [7] = "-";
				model.addRow(row);
				table.setModel(model);
				
			//Calcul new Total
				double total = 0;
			    for(int i = 0; i < table.getRowCount(); i++){
			       
			        double MontantAchat = Double.parseDouble(table.getValueAt(i, 3)+"");
			        total = MontantAchat+total;
			       
			    }

			   float TotalFloat = (float)total;
			   String TotalFinal = Float.toString(TotalFloat);
			   Total.setText(String.format(TotalFinal)+" $");
				
			//Modifit compte du nombre de Popcorn
				TotalPopcorn += i;
				String TotalPopcornString = Float.toString(TotalPopcorn);
				lblPopcornamount.setText(String.format(TotalPopcornString));
				
			}
		});
		btnPopcorn.setBounds(155, 61, 128, 74);
		add(btnPopcorn);
		
		JLabel lblBonbonsamount = new JLabel("");
		lblBonbonsamount.setBounds(672, 91, 65, 14);
		add(lblBonbonsamount);
		
		JButton btnBonbons = new JButton("Bonbons:");
		btnBonbons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//Ajoute Article Bonbon au "Panier"
				Object[] row = new Object[8];
				row [0] = "-";
				row [1] = "Bonbon";
				row [2] = "-";
				row [3] = "1.50";
				row [4] = "-";
				row [5] = "-";
				row [6] = "1";
				row [7] = "-";
				model.addRow(row);
				table.setModel(model);
				
			//Calcul new Total
				double total = 0;
			    for(int i = 0; i < table.getRowCount(); i++){
			       
			        double MontantAchat = Double.parseDouble(table.getValueAt(i, 3)+"");
			        total = MontantAchat+total;
			        
			    }

			   float TotalFloat = (float)total;
			   String TotalFinal = Float.toString(TotalFloat);
			   Total.setText(String.format(TotalFinal)+" $");
				
				
				
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
		scrollPane.setViewportView(table);
		
		
		

		
		
		rdbtnLouer = new JRadioButton("Louer");
		rdbtnLouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnAcheter.setSelected(false);
				
					
			}
		});
		rdbtnLouer.setBounds(52, 371, 109, 23);
		add(rdbtnLouer);
		
		
		
		
		rdbtnAcheter = new JRadioButton("Acheter");
		rdbtnAcheter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnLouer.setSelected(false);
				
				
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
		

		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (EntrerCodeProduit.getText().equals("")) {
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
						
						Object[] row = new Object[8];
						
						if (rdbtnLouer.isSelected()) {
						
							row [0] = rs.getInt("ID");
							row [1] = rs.getString("Titre");
							row [2] = rs.getInt("Annee");
							row [3] = rs.getDouble("PrixDeLocation");
							row [4] = rs.getBoolean("Nouveaute");
							row [5] = rs.getBoolean("Bluray");
							row [6] = rs.getInt("Stock");
							row [7] = rs.getString("Categorie");
							model.addRow(row);
							table.setModel(model);
						
						}
						else if (rdbtnAcheter.isSelected()) {
							
							row [0] = rs.getInt("ID");
							row [1] = rs.getString("Titre");
							row [2] = rs.getInt("Annee");
							row [3] = rs.getDouble("PrixAchat");
							row [4] = rs.getBoolean("Nouveaute");
							row [5] = rs.getBoolean("Bluray");
							row [6] = rs.getInt("Stock");
							row [7] = rs.getString("Categorie");
							model.addRow(row);
							table.setModel(model);
							
						}
						
						double total = 0;
						
					    for(int i = 0; i < table.getRowCount(); i++){
					       
					        double MontantAchat = Double.parseDouble(table.getValueAt(i, 3)+"");
					        total = MontantAchat+total;
					 
					    }
					    
					   //PopCorn 3$   Bonbon 1,5$
//					   total = total + (TotalPopcorn*3) + (TotalBonbons*1.5);
					   
					   float TotalFloat = (float)total;
					   String TotalFinal = Float.toString(TotalFloat);
					   Total.setText(String.format(TotalFinal)+" $");
						

					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
					EntrerCodeProduit.setText("");
					rdbtnLouer.setSelected(false);
					rdbtnAcheter.setSelected(false);
				}
			}
		});
		btnAjouter.setBounds(354, 349, 128, 23);
		add(btnAjouter);
		
		
		JLabel lblTotal = new JLabel("Total : ");
		lblTotal.setBounds(729, 353, 48, 14);
		add(lblTotal);
		
		
		
		JButton btnPayer = new JButton("Payer");
		btnPayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("TotalPayé: "+Total.getText());
				
			
				JOptionPane.showMessageDialog(null, "Facture imprimée");
			
				
				
			//Reset les données du Panel
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
		btnRecommencer.setBounds(354, 388, 128, 23);
		add(btnRecommencer);
		
		
	}
}
