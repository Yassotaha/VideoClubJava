package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Rectangle;

public class LoginPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(263, 62, 321, 99);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 37));
		
		textField = new JTextField();
		textField.setBounds(347, 209, 237, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Identifiant:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(263, 209, 83, 22);
		add(lblNewLabel_1);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe:");
		lblMotDePasse.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMotDePasse.setBounds(263, 259, 105, 22);
		add(lblMotDePasse);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(370, 259, 214, 26);
		add(textField_1);

	}
}
