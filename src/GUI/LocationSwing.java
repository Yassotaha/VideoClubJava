package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import static javax.swing.JOptionPane.*;

public class LocationSwing {
    private JButton inventaireButton;
    private JPanel PanelMain;

    public LocationSwing() {
        inventaireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog(null,"Ton inventaire!" );
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("LocationSwing");
        frame.setContentPane(new LocationSwing().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
