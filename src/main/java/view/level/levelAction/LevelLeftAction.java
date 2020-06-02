package view.level.levelAction;

import model.level.Level;
import view.SokobanFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LevelLeftAction extends AbstractAction {
    private Level level;

    private SokobanFrame sokobanFrame;

    public LevelLeftAction(Level level, SokobanFrame sokobanFrame) {
        this.level = level;
        this.sokobanFrame = sokobanFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        level.moveLeft();
        sokobanFrame.repaint();
        if(level.gameOver()){
            sokobanFrame.displayNextLevelMenu();
        }
    }
}
