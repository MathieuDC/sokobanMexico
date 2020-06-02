package view.levelAction;

import model.level.Level;
import view.SokobanFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LevelUpAction extends AbstractAction {
    private Level level;

    private SokobanFrame sokobanFrame;

    public LevelUpAction(Level level, SokobanFrame sokobanFrame) {
        this.level = level;
        this.sokobanFrame = sokobanFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        level.moveUp();
        sokobanFrame.repaint();
        if(level.gameOver()){
            sokobanFrame.displayNextLevelMenu();
        }
    }
}
