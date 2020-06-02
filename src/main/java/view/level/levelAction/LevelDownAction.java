package view.level.levelAction;

import model.level.Level;
import view.SokobanFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LevelDownAction extends AbstractAction {
    private Level level;

    private SokobanFrame sokobanFrame;

    public LevelDownAction(Level level, SokobanFrame sokobanFrame) {
        this.level = level;
        this.sokobanFrame = sokobanFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        level.moveDown();
        sokobanFrame.repaint();
        if(level.gameOver()){
            sokobanFrame.displayNextLevelMenu();
        }
    }
}
