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
	
	//Variable static du JPanel Inventaire
	public static Connection connection ;
	private static JTable tableInventaire;
	private static JTextField id;
	private static JTextField Titre;
	private static JTextField Annee;
	private static JTextField nouveaute;
	private static JTextField bluray;
	private static JTextField prixdelocation;
	private static JTextField prixdachat;
	private static JTextField Stock;
	private static JTextField Categorie;
	
	//Variable du JPanel Inventaire
	private JTextField textFieldNbPopcorn;
	private JScrollPane scrollPaneInventaire;
	private JTextField textFieldNbBonbon;
	private JLabel lblFilms;
	private JLabel lblPopcorn;
	private JLabel lblBonbon;
	private JButton btnNewButton_2;
	
	private JTextField txtId;
	private JTextField txtTitre;
	private JTextField txtAnne;
	private JTextField txtPrixDachat;
	private JTextField txtPrixDeLocation;
	private JTextField txtNouveaute;
	private JTextField txtBluray;
	private JTextField txtStock;
	private JTextField txtCatgorie;
	
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
		
		
		
		setId(new JTextField("00000"));
		getId().setColumns(10);
		getId().setBounds(778, 260, 104, 20);
		add(getId());
		
		setTitre(new JTextField("PommeDePin"));
		getTitre().setColumns(10);
		getTitre().setBounds(778, 290, 104, 20);
		add(getTitre());

		setAnnee(new JTextField("2020"));
		getAnnee().setColumns(10);
		getAnnee().setBounds(778, 320, 104, 20);
		add(getAnnee());
		
		setPrixdelocation(new JTextField("2"));
		getPrixdelocation().setColumns(10);
		getPrixdelocation().setBounds(778, 350, 104, 20);
		add(getPrixdelocation());
		
		setPrixdachat(new JTextField("5"));
		getPrixdachat().setColumns(10);
		getPrixdachat().setBounds(778, 380, 104, 20);
		add(getPrixdachat());
		
		setNouveaute(new JTextField("True"));
		getNouveaute().setColumns(10);
		getNouveaute().setBounds(778, 410, 104, 20);
		add(getNouveaute());
		
		setBluray(new JTextField("False"));
		getBluray().setColumns(10);
		getBluray().setBounds(778, 440, 104, 20);
		add(getBluray());
		
		setStock(new JTextField("43"));
		getStock().setColumns(10);
		getStock().setBounds(778, 470, 104, 20);
		add(getStock());
		
		setCategorie(new JTextField("Drame"));
		getCategorie().setColumns(10);
		getCategorie().setBounds(778, 500, 104, 20);
		add(getCategorie());
		
	
		
		
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
		getTableInventaire().setFont(new Font("Tahoma", Font.PLAIN, 13));
	
		
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
		getTableInventaire().getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 13));
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
//				getStock1() .setVisible(true);
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
		
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setText("    ID");
		txtId.setColumns(10);
		txtId.setBounds(650, 260, 104, 20);
		add(txtId);
		
		txtTitre = new JTextField();
		txtTitre.setEditable(false);
		txtTitre.setText("    Titre");
		txtTitre.setColumns(10);
		txtTitre.setBounds(650, 290, 104, 20);
		add(txtTitre);
		
		txtAnne = new JTextField();
		txtAnne.setEditable(false);
		txtAnne.setText("    Ann\u00E9e");
		txtAnne.setColumns(10);
		txtAnne.setBounds(650, 320, 104, 20);
		add(txtAnne);
		
		txtPrixDeLocation = new JTextField();
		txtPrixDeLocation.setEditable(false);
		txtPrixDeLocation.setText("   Prix de location");
		txtPrixDeLocation.setColumns(10);
		txtPrixDeLocation.setBounds(650, 350, 104, 20);
		add(txtPrixDeLocation);
		
		txtPrixDachat = new JTextField();
		txtPrixDachat.setEditable(false);
		txtPrixDachat.setText("   Prix d'achat");
		txtPrixDachat.setColumns(10);
		txtPrixDachat.setBounds(650, 380, 104, 20);
		add(txtPrixDachat);
		
		txtNouveaute = new JTextField();
		txtNouveaute.setEditable(false);
		txtNouveaute.setText("      Nouveaute");
		txtNouveaute.setColumns(10);
		txtNouveaute.setBounds(650, 410, 104, 20);
		add(txtNouveaute);
		
		txtBluray = new JTextField();
		txtBluray.setEditable(false);
		txtBluray.setText("      Bluray");
		txtBluray.setColumns(10);
		txtBluray.setBounds(650, 440, 104, 20);
		add(txtBluray);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setText("      Stock");
		txtStock.setColumns(10);
		txtStock.setBounds(650, 470, 104, 20);
		add(txtStock);
		
		txtCatgorie = new JTextField();
		txtCatgorie.setEditable(false);
		txtCatgorie.setText("    Cat\u00E9gorie");
		txtCatgorie.setColumns(10);
		txtCatgorie.setBounds(650, 500, 104, 20);
		add(txtCatgorie);
		
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
		
//		setStock1(new JTextField());
//		getStock1().setColumns(10);
//		getStock1().setBounds(296, 278, 53, 20);
//		getStock1().setVisible(false);
//		add(getStock1());
		
		btnNewButton_4 = new JButton("Modifie film");
		btnNewButton_4.setBounds(192, 303, 89, 35);
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
		this.Titre = titre;
	}

	public static JTextField getAnnee() {
		return Annee;
	}

	public void setAnnee(JTextField Annee) {
		this.Annee = Annee;
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

//	public static JTextField getStock1() {
//		return Stock1;
//	}
//
//	public void setStock1(JTextField stock1) {
//		this.Stock1 = stock1;
//	}
	
	
	
	public static JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}
	
	public static JTextField getNouveaute() {
		return nouveaute;
	}

	public void setNouveaute(JTextField nouveaute) {
		this.nouveaute = nouveaute;
	}
	
	public static JTextField getBluray() {
		return bluray;
	}

	public void setBluray(JTextField bluray) {
		this.bluray = bluray;
	}
}