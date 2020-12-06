package GUI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class MembrePanel extends JPanel {
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtTlphone;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_13;
	private JTextField textField_14;

	/**
	 * Create the panel.
	 */
	public MembrePanel() {
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		JButton button = new JButton("Cr\u00E9er un nouveau membre");
		button.setBounds(34, 316, 205, 33);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(button);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(684, 412, 180, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(684, 381, 180, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(684, 350, 180, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("    Nom:");
		textField_5.setColumns(10);
		textField_5.setBounds(639, 322, 40, 20);
		add(textField_5);
		
		txtTlphone = new JTextField();
		txtTlphone.setText("    T\u00E9l\u00E9phone:");
		txtTlphone.setColumns(10);
		txtTlphone.setBounds(607, 350, 72, 20);
		add(txtTlphone);
		
		textField_7 = new JTextField();
		textField_7.setText("    Code secret:");
		textField_7.setColumns(10);
		textField_7.setBounds(599, 412, 80, 20);
		add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("    Carte de Cr\u00E9dit/D\u00E9bit:");
		textField_8.setColumns(10);
		textField_8.setBounds(545, 381, 134, 20);
		add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(684, 322, 180, 20);
		add(textField_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 11, 859, 298);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Yaseen Choukri", "819-318-2360"},
				{"Samuel Bernier", "819-123-4567"},
				{"...", null},
				{"...", null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Liste des membres", "T\u00E9l\u00E9phone"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(291);
		table.getColumnModel().getColumn(1).setPreferredWidth(356);
		scrollPane.setViewportView(table);
		
		JButton btn_modifMembre = new JButton("Modifier un membre");
		btn_modifMembre.setBounds(34, 356, 205, 33);
		btn_modifMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(btn_modifMembre);
		
		JButton btn_suppMembre = new JButton("Supprimer un membre");
		btn_suppMembre.setBounds(34, 399, 205, 33);
		btn_suppMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(btn_suppMembre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(353, 353, 180, 20);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("    Nom:");
		textField_1.setColumns(10);
		textField_1.setBounds(301, 353, 40, 20);
		add(textField_1);
		
		textField_13 = new JTextField();
		textField_13.setText("    Code secret:");
		textField_13.setColumns(10);
		textField_13.setBounds(261, 381, 80, 20);
		add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(353, 381, 180, 20);
		add(textField_14);
		
		JLabel lblCompteModifier = new JLabel("Compte \u00E0 modifier :");
		lblCompteModifier.setBounds(261, 324, 134, 16);
		add(lblCompteModifier);
		
		JLabel lblRentrerModification = new JLabel("Rerentrer le compte \u00E0 droite avec les modifications");
		lblRentrerModification.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRentrerModification.setBounds(251, 412, 342, 20);
		add(lblRentrerModification);

	}
}
