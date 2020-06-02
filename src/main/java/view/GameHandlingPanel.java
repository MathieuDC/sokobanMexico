//  GameHandlingPanel.java
//  Author: Ouarezki Nabil
//  Date : 01/06/2020

package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GameHandlingPanel extends JPanel {
    public GameHandlingPanel() {
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
