package GUI;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
import Main.sqliteConnection;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import Main.*;
import Main.Film;

public class InventairePanel extends JPanel 
{
	//Variable du JPanel Inventaire
	private JTextField textFieldNbPopcorn;
	private static JTable tableInventaire;
	private JScrollPane scrollPaneInventaire;
	private JTextField textFieldNbBonbon;
	private JLabel lblFilms;
	private JLabel lblPopcorn;
	private JLabel lblBonbon;
	
	public static Connection connection ;
	private JButton btnNewButton_2;
	private static JTextField Titre;
	private static JTextField Année;
	private static JTextField Categorie;
	private static JTextField prixdachat;
	private static JTextField prixdelocation;

	private JTextField txtTitre;
	private JTextField txtAnne;
	private JTextField txtCatgorie;
	private JTextField txtPrixDachat;
	private JTextField txtPrixDeLocation;
	private static JTextField Stock;
	private JTextField txtStock;
	private JTextField PrixdArticle;
	private JTextField txtPrixDarticle;
	private JTextField txtQuantit;
	private JTextField Quantite;
	private JLabel lblArticleModifier;
	private JLabel lblFilmModifier;
	private JTextField textField;
	private static JTextField Stock1;
	private JButton btnNewButton_4;
	private JButton btnModifieArticle;
	
	private static JTable table_1;
	private static JTextField id_field;
	private JTextField txtIdFilm;
	
	//Créer le JPanel Inventaire
	//dfhrghdfghd
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
		textFieldNbPopcorn.setBounds(308, 397, 53, 28);
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
		
		
		
		setTableInventaire(new JTable());
		getTableInventaire().setFont(new Font("Tahoma", Font.PLAIN, 18));
	
		
		try {
			String query = "select * from FilmInfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			getTableInventaire().setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		getTableInventaire().getColumnModel().getColumn(0).setPreferredWidth(168);
		getTableInventaire().getColumnModel().getColumn(2).setPreferredWidth(68);
		getTableInventaire().getColumnModel().getColumn(3).setPreferredWidth(89);
		getTableInventaire().getColumnModel().getColumn(4).setPreferredWidth(48);
		getTableInventaire().getColumnModel().getColumn(5).setPreferredWidth(116);
		getTableInventaire().getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPaneInventaire.setViewportView(getTableInventaire());
		
		setTable(new JTable());
		scrollPaneInventaire.setColumnHeaderView(getTable());
		
		table_1 = new JTable();
		scrollPaneInventaire.setColumnHeaderView(table_1);
		
		JButton btnNewButton = new JButton("Cr\u00E9er un film");
		btnNewButton.setBounds(485, 288, 149, 38);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Film.creer_film();
				Film.loadTableFilms();
				
			}
		});
		add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Modifier un film");
		btnNewButton_1.setBounds(23, 260, 149, 38);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblFilmModifier.setVisible(true);
				getStock1() .setVisible(true);
				textField.setVisible(true);
				btnNewButton_4.setVisible(true);
				revalidate();
			}
		});
		add(btnNewButton_1);
		
		
		btnNewButton_2 = new JButton("Supprimer un film");
		btnNewButton_2.setBounds(485, 337, 149, 38);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sqliteConnection.supprimer_film();	
				Film.loadTableFilms();
				
			
			
			
			}
		});
		add(btnNewButton_2);
		
		setTitre(new JTextField());
		getTitre().setBounds(778, 260, 104, 20);
		add(getTitre());
		getTitre().setColumns(10);
		
		setAnnée(new JTextField());
		getAnnée().setColumns(10);
		getAnnée().setBounds(778, 288, 104, 20);
		add(getAnnée());
		
		setCategorie(new JTextField());
		getCategorie().setColumns(10);
		getCategorie().setBounds(778, 318, 104, 20);
		add(getCategorie());
		
		setPrixdachat(new JTextField());
		getPrixdachat().setColumns(10);
		getPrixdachat().setBounds(778, 342, 59, 20);
		add(getPrixdachat());
		
		setPrixdelocation(new JTextField());
		getPrixdelocation().setColumns(10);
		getPrixdelocation().setBounds(778, 367, 59, 20);
		add(getPrixdelocation());
		
		txtTitre = new JTextField();
		txtTitre.setEditable(false);
		txtTitre.setText("    Titre");
		txtTitre.setColumns(10);
		txtTitre.setBounds(664, 260, 104, 20);
		add(txtTitre);
		
		txtAnne = new JTextField();
		txtAnne.setEditable(false);
		txtAnne.setText("    Ann\u00E9e");
		txtAnne.setColumns(10);
		txtAnne.setBounds(664, 288, 104, 20);
		add(txtAnne);
		
		txtCatgorie = new JTextField();
		txtCatgorie.setEditable(false);
		txtCatgorie.setText("    Cat\u00E9gorie");
		txtCatgorie.setColumns(10);
		txtCatgorie.setBounds(664, 318, 104, 20);
		add(txtCatgorie);
		
		txtPrixDachat = new JTextField();
		txtPrixDachat.setEditable(false);
		txtPrixDachat.setText("   Prix d'achat");
		txtPrixDachat.setColumns(10);
		txtPrixDachat.setBounds(664, 342, 104, 20);
		add(txtPrixDachat);
		
		txtPrixDeLocation = new JTextField();
		txtPrixDeLocation.setEditable(false);
		txtPrixDeLocation.setText("   Prix de location");
		txtPrixDeLocation.setColumns(10);
		txtPrixDeLocation.setBounds(664, 367, 104, 20);
		add(txtPrixDeLocation);
		
		setStock(new JTextField());
		getStock().setColumns(10);
		getStock().setBounds(600, 260, 53, 20);
		add(getStock());
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setText("      Stock");
		txtStock.setColumns(10);
		txtStock.setBounds(485, 260, 104, 20);
		add(txtStock);
		
		JButton btnNewButton_3 = new JButton("    Modifier un article");
		btnNewButton_3.setBounds(23, 309, 149, 38);
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				lblArticleModifier.setVisible(true);
				Quantite.setVisible(true);
				txtQuantit.setVisible(true);
				txtPrixDarticle.setVisible(true);
				PrixdArticle.setVisible(true);
				btnModifieArticle .setVisible(true);
				revalidate();
			}
		});
		add(btnNewButton_3);
		  lblArticleModifier = new JLabel("Article \u00E0 modifier:");
		lblArticleModifier.setBounds(31, 355, 141, 20);
		lblArticleModifier.setVisible(false);
		add(lblArticleModifier);
		
		
		PrixdArticle = new JTextField();
		PrixdArticle.setBounds(106, 378, 86, 20);
		PrixdArticle.setColumns(10);
		PrixdArticle.setVisible(false);
		add(PrixdArticle);
		
		
		txtPrixDarticle = new JTextField();
		txtPrixDarticle.setEditable(false);
		txtPrixDarticle.setText(" Prix d'article");
		txtPrixDarticle.setBounds(10, 378, 86, 20);
		txtPrixDarticle.setColumns(10);
		txtPrixDarticle.setVisible(false);
		add(txtPrixDarticle);
		
		
		txtQuantit = new JTextField();
		txtQuantit.setEditable(false);
		txtQuantit.setText("  Quantit\u00E9");
		txtQuantit.setBounds(10, 404, 86, 20);
		txtQuantit.setColumns(10);
		txtQuantit.setVisible(false);
		add(txtQuantit);

		
		Quantite = new JTextField();
		Quantite.setBounds(106, 404, 75, 20);
		Quantite.setColumns(10);
		Quantite.setVisible(false);
		add(Quantite);
		
		lblFilmModifier = new JLabel("Film \u00E0 modifier:");
		lblFilmModifier.setBounds(182, 260, 111, 14);
		lblFilmModifier.setVisible(false);
		add(lblFilmModifier);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("      Stock");
		textField.setColumns(10);
		textField.setBounds(182, 278, 104, 20);
		textField.setVisible(false);
		add(textField);
		
		setStock1(new JTextField());
		getStock1().setColumns(10);
		getStock1().setBounds(296, 278, 53, 20);
		getStock1().setVisible(false);
		add(getStock1());
		
		btnNewButton_4 = new JButton("Modifie film");
		btnNewButton_4.setBounds(192, 303, 89, 23);
		btnNewButton_4.setVisible(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Film.modifier_film();
				Film.loadTableFilms();
			
			}
		});
		add(btnNewButton_4);
		
		btnModifieArticle = new JButton("Modifie article");
		btnModifieArticle.setBounds(202, 366, 108, 23);
		btnModifieArticle.setVisible(false);
		btnModifieArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		add(btnModifieArticle);
		
		setId_field(new JTextField());
		getId_field().setBounds(382, 342, 98, 20);
		add(getId_field());
		getId_field().setColumns(10);
		
		txtIdFilm = new JTextField();
		txtIdFilm.setEditable(false);
		txtIdFilm.setText("ID film");
		txtIdFilm.setColumns(10);
		txtIdFilm.setBounds(388, 318, 59, 20);
		add(txtIdFilm);
		
		

	}

	public static JTable getTableInventaire() {
		return tableInventaire;
	}
	public void setTableInventaire(JTable tableInventaire) {
		this.tableInventaire = tableInventaire;
	}

	public static JTable getTable() {
		return table_1;
	}

	public void setTable(JTable table) {
		this.table_1 = table;
	}

	public static JTextField getId_field() {
		return id_field;
	}

	public void setId_field(JTextField id_field) {
		this.id_field = id_field;
	}

	public static JTextField getTitre() {
		return Titre;
	}

	public void setTitre(JTextField titre) {
		Titre = titre;
	}

	public static JTextField getAnnée() {
		return Année;
	}

	public void setAnnée(JTextField année) {
		Année = année;
	}

	public static JTextField getPrixdelocation() {
		return prixdelocation;
	}

	public void setPrixdelocation(JTextField prixdelocation) {
		this.prixdelocation = prixdelocation;
	}

	public static JTextField getPrixdachat() {
		return prixdachat;
	}

	public void setPrixdachat(JTextField prixdachat) {
		this.prixdachat = prixdachat;
	}

	public static JTextField getStock() {
		return Stock;
	}

	public void setStock(JTextField stock) {
		this.Stock = stock;
	}

	public static  JTextField getCategorie() {
		return Categorie;
	}

	public void setCategorie(JTextField categorie) {
		this.Categorie = categorie;
	}

	public static JTextField getStock1() {
		return Stock1;
	}

	public void setStock1(JTextField stock1) {
		this.Stock1 = stock1;
	}
}