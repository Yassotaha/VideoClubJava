package GUI;

import java.awt.Font;
import java.awt.Rectangle;
import Main.sqliteConnection;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
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
		
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		JButton btnPopcorn = new JButton("Popcorn:");
		btnPopcorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TotalPopcorn += i;
				
				
				lblPopcornamount.setText("x :" + " " + TotalPopcorn);
				
			}
		});
		btnPopcorn.setBounds(155, 61, 128, 74);
		add(btnPopcorn);
		
		JLabel lblPopcornamount = new JLabel("PopcornAmount");
		lblPopcornamount.setBounds(293, 91, 65, 14);
		add(lblPopcornamount);
		
		JButton btnBonbons = new JButton("Bonbons:");
		btnBonbons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TotalBonbons += i;
				
				
				lblBonbonsamount.setText("x :" + " " + TotalBonbons);
			}
		});
		btnBonbons.setBounds(534, 61, 128, 74);
		add(btnBonbons);
		
		JLabel lblBonbonsamount = new JLabel("BonbonsAmount");
		lblBonbonsamount.setBounds(672, 91, 65, 14);
		add(lblBonbonsamount);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 160, 859, 144);
		add(scrollPane);
		
		//ListSelectionModel model=table.getSelectionModel();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "james bond", "10", "3", "3", "4"},
				{null, null, "thor", "10", "3", "5", "5"},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Acheter", "Louer", "Titre", "Prix achat", "Prix location", "Quantit\u00E9 achat", "Quantit\u00E9 location"
			}
		));
		
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
				
				connection = sqliteConnection.dbConnector();
				
				
				try {
					
					
					String query = "select * from FilmInfo where ID=?"; 
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, EntrerCodeProduit.getText());
					
					ResultSet rs = pst.executeQuery();
					
					
				} 
				
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				
				
				
				
				
				//Colonne vide ou pas
				
				/*for(int i = 0; i < membre.length && RangerVide != true; i++)
				{
					if(membre[i][0] == null && membre[i][1] == null)
					{
						RangerVide = true;
						noRangerVide = i;
					}
					
					
					
					//si on a fini de lire le tableau et qu,il n,y a pas de place libre (agrandir size du tab)
				}
				
							
			if(RangerVide == true)
			 
		{
			for(int j = 0; j < membre[noRangerVide].length ; j++)
			{
				if(j == 0 && isAchat == true)
				{
					membre[noRangerVide][j] = "Acheter"; 
				}
				else if(j == 1 && isAchat == false)
				{
					membre[noRangerVide][j] = "Louer";
				}
				//colonne louer
				else if(j == 6)
				{
					if(isAchat == false)
					{
						membre[noRangerVide][j] = databaseTabRetour[j-2];
						//m/thode incrementer prix total
					}
					else
					{
						membre[noRangerVide][j] = "-";
					}
							
				}
				//colonne acheter
				else if(j == 7)
				{
					if(isAchat == true)
					{
						membre[noRangerVide][j] = databaseTabRetour[j-2];
						//m/thode incrementer prix total
					}
					else
					{
						membre[noRangerVide][j] = "-";
					}
				}
				else
				{
					membre[noRangerVide][j] = databaseTabRetour[j-2];
				}
				
			}
		}
		
	}
			
			 
			 */
				rdbtnLouer.setSelected(false);
				rdbtnAcheter.setSelected(false);
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
				
				int total = 0;
				
			    for(int i = 0; i < table.getRowCount(); i++){
			       
			        int MontantAchat = Integer.parseInt(table.getValueAt(i, 3)+"");
			        total = MontantAchat+total;
			        System.out.println(total);
			    }
			    for(int i = 0; i < table.getRowCount(); i++){
				       
			        int MontantLouer = Integer.parseInt(table.getValueAt(i, 4)+"");
			        total = MontantLouer+total;
			        System.out.println(total);
			    }
			    
			   
			    
			    Total.setText("" + total);
			
		
				
			}
			
		});
		btnPayer.setBounds(562, 371, 157, 56);
		add(btnPayer);
		
		JLabel lblTotal1 = new JLabel("Total : ");
		lblTotal1.setBounds(729, 353, 48, 14);
		add(lblTotal1);
		
		
	
		
		
		

		

	}
}
