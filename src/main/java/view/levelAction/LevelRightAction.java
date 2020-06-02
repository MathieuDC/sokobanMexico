package view.levelAction;

import model.level.Level;
import view.SokobanFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LevelRightAction extends AbstractAction {
    private Level level;

    private SokobanFrame sokobanFrame;

    public LevelRightAction(Level level, SokobanFrame sokobanFrame) {
        this.level = level;
        this.sokobanFrame = sokobanFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        level.moveRight();
        sokobanFrame.repaint();
        if(level.gameOver()){
            sokobanFrame.displayNextLevelMenu();
        }
    }
}
