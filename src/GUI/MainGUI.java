package GUI;

import java.sql.*;

import java.text.ParseException;

import javax.swing.*;

import Main.BackEnd;

import GUI.*;

import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

public class MainGUI {
	
	private JFrame frame;
	private JTextField textField;
	private JPanel mainPanel;
	private InventairePanel inventairePanel;
	private MembrePanel membrePanel;
	private VentePanel ventePanel;
	private JPanel panelOperation;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gbc_MainPanel;
	private JPanel panel_1;
	private GridBagConstraints gbc_panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private GridBagConstraints gbc_panel_2;
	
	public static String amende1;
	public static String amende2;
	public static String amende3;
	public static String amende4;
	public static String amende5;
	
	//Temporaire pour l'instant; ID sauvegarder ici
	public static String ID = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LoginFrame.createLoginFrame();
	}
	

	/**
	 * Create the object application.
	 */
	public static void createMainFrame()
	{
		MainGUI window = new MainGUI();
		window.frame.setVisible(true);		
	}
	
	
	
	/**
	 * Construct the application.
	 * @wbp.parser.entryPoint
	 */
	public MainGUI() {
		initialize();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Frame
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 1206, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{44, 157, 16, 403, 484, 30, 0};
		gridBagLayout.rowHeights = new int[]{0, 84, 207, 44, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		
		frame.getContentPane().setLayout(gridBagLayout);
		
		//MainPanel
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.GRAY);
		mainPanel.setVisible(true);
		
		gbc_MainPanel = new GridBagConstraints();
		gbc_MainPanel.gridwidth = 3;
		gbc_MainPanel.insets = new Insets(0, 0, 5, 5);
		gbc_MainPanel.fill = GridBagConstraints.BOTH;
		gbc_MainPanel.gridx = 2;
		gbc_MainPanel.gridy = 2;
		
		frame.getContentPane().add(mainPanel, gbc_MainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		//MembrePanel
		membrePanel = new MembrePanel();
		membrePanel.setLayout(null);
		
		mainPanel.add(membrePanel, "name_66790686876900");
		
		//VentePanel (et location)
		ventePanel = new VentePanel();
		
		mainPanel.add(ventePanel, "name_67722725656500");
		
		//InventairePanel
		inventairePanel = new InventairePanel();
		
		mainPanel.add(inventairePanel, "name_67788483635900");
		
		
		//PanelStructural1
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		
		gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 1;
		
		frame.getContentPane().add(panel_1, gbc_panel_1);
		
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//LabelVideoClub
		lblNewLabel = new JLabel("Vid\u00E9o Club");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panel_1.add(lblNewLabel);
		
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 34));
		
		//PanelStructural2
		panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setLayout(null);
		gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 4;
		gbc_panel_2.gridy = 1;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		
		//LabelID
		JLabel lblNewLabel_1 = new JLabel("ID: ");
		lblNewLabel_1.setBounds(216, 9, 18, 14);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		//TextFieldID
		textField = new JTextField();
		textField.setBounds(244, 6, 109, 20);
		textField.setText(ID);
		panel_2.add(textField);
		textField.setEditable(false);
		textField.setColumns(10);
		
		//ButtonNotification
		JButton btnNewButton_1 = new JButton("Notification");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Main.Location.calculeRetard();
					JOptionPane.showMessageDialog(null, amende1+"\n"+"\n"+amende2+"\n"+"\n"+amende3+"\n"+"\n"+amende4+"\n"+"\n"+amende5);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(244, 34, 109, 34);
		panel_2.add(btnNewButton_1);
		
		
		//ButtonSeDéconnecter
		JButton btnNewButton_2 = new JButton("Se d\u00E9connecter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//			Cache et détruit le MainFrame pour ensuite 
//			créer un LoginFrame qui prendra sa place
				hideMainFrame();
				frame.dispose();
				LoginFrame.createLoginFrame();
				
			}
		});
		btnNewButton_2.setBounds(363, 5, 124, 23);
		panel_2.add(btnNewButton_2);
		
		//HorizontalStrut (structural)
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		frame.getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		
		//Panel Des Opérations (structural)
		panelOperation = new JPanel();
		panelOperation.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		frame.getContentPane().add(panelOperation, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{139, 0};
		gbl_panel.rowHeights = new int[]{59, 16, 66, 21, 64, 23, 66, 88, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelOperation.setLayout(gbl_panel);
		
		
		//ButtonVenteEtLocation
		JButton btnVente = new JButton("Vente et Location");
		btnVente.setBackground(UIManager.getColor("CheckBox.background"));
		btnVente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventairePanel.setVisible(false);
				ventePanel.setVisible(true);
				membrePanel.setVisible(false);
			}
		});
		btnVente.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnVente = new GridBagConstraints();
		gbc_btnVente.anchor = GridBagConstraints.WEST;
		gbc_btnVente.fill = GridBagConstraints.VERTICAL;
		gbc_btnVente.insets = new Insets(0, 0, 5, 0);
		gbc_btnVente.gridx = 0;
		gbc_btnVente.gridy = 2;
		panelOperation.add(btnVente, gbc_btnVente);
		
		
		//ButtonMembre
		JButton btnMembre = new JButton("Membre");
		btnMembre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inventairePanel.setVisible(false);
				ventePanel.setVisible(false);
				membrePanel.setVisible(true);
				
			}
			
		});
		btnMembre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnMembre = new GridBagConstraints();
		gbc_btnMembre.fill = GridBagConstraints.BOTH;
		gbc_btnMembre.insets = new Insets(0, 0, 5, 0);
		gbc_btnMembre.gridx = 0;
		gbc_btnMembre.gridy = 4;
		panelOperation.add(btnMembre, gbc_btnMembre);
		
		
		//ButtonInventaire
		JButton btnInventaire = new JButton("Inventaire");
		btnInventaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if (BackEnd.estSup == true) {
					
					inventairePanel.setVisible(true);
					ventePanel.setVisible(false);
					membrePanel.setVisible(false);
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Accès refusé");
					}
					
				}
				
				
			
		});
		
		btnInventaire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnInventaire = new GridBagConstraints();
		gbc_btnInventaire.insets = new Insets(0, 0, 5, 0);
		gbc_btnInventaire.fill = GridBagConstraints.BOTH;
		gbc_btnInventaire.gridx = 0;
		gbc_btnInventaire.gridy = 6;
		panelOperation.add(btnInventaire, gbc_btnInventaire);
		//GridBagConstraints gbc_label = new GridBagConstraints();
		//gbc_label.gridx = 0;
		//gbc_label.gridy = 7;
		//logo.setIcon(new ImageIcon(MainGUI.class.getResource("/logo.png")));
	
	


		
	
		
		
		//HorizontalStrut2 (structural)
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 5;
		gbc_horizontalStrut_1.gridy = 2;
		frame.getContentPane().add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		
		
	}
	
	
	
	
	public void showMainFrame()
	{
		frame.setVisible(true);
	}
	
	public void hideMainFrame()
	{
		frame.setVisible(false);
	}
		}
	
	
