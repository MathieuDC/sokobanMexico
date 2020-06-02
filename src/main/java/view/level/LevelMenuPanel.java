//  Author : Baudorre Grégoire
//  Date : 01/06/2020

package view.level;

import view.SokobanFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelMenuPanel extends JPanel {

    JLabel currentLevelLabel;

    JButton restartButton;

    JButton saveButton;

    public LevelMenuPanel(SokobanFrame sokobanFrame, int indexLevel) {
        currentLevelLabel = new JLabel("Level n°" + indexLevel);
        add(currentLevelLabel);

        restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sokobanFrame.restartCurrentLevel();
            }
        });
        restartButton.requestFocus(false);
        add(restartButton);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sokobanFrame.saveCurrentLevel();
            }
        });
        saveButton.requestFocus(false);
        add(saveButton);
    }
}
