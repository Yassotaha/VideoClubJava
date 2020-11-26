package GUI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

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

	/**
	 * Create the panel.
	 */
	public MembrePanel() {
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		JButton button = new JButton("Cr\u00E9er un nouveau membre");
		button.setBounds(45, 350, 258, 47);
		add(button);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(692, 412, 180, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(692, 381, 180, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(692, 350, 180, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("    Nom:");
		textField_5.setColumns(10);
		textField_5.setBounds(615, 322, 61, 20);
		add(textField_5);
		
		txtTlphone = new JTextField();
		txtTlphone.setText("    T\u00E9l\u00E9phone:");
		txtTlphone.setColumns(10);
		txtTlphone.setBounds(615, 350, 67, 20);
		add(txtTlphone);
		
		textField_7 = new JTextField();
		textField_7.setText("    Code secret:");
		textField_7.setColumns(10);
		textField_7.setBounds(595, 412, 80, 20);
		add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("    Carte de Cr\u00E9dit/D\u00E9bit:");
		textField_8.setColumns(10);
		textField_8.setBounds(537, 381, 140, 20);
		add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(695, 322, 177, 20);
		add(textField_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 11, 859, 300);
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

	}
}
