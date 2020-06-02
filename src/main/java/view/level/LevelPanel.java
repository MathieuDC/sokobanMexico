package view.level;

import model.level.Level;
import model.levelHandler.LevelHandler;
import view.SokobanFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LevelPanel extends JPanel {

    private Level level;

    public LevelPanel(LevelHandler levelHandler, SokobanFrame sokobanFrame) {
        this.level = levelHandler.getCurrentLevel();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ElementImg elementImg : getElementImgs()) {
            g.drawImage(elementImg.getImage(), elementImg.getX(), elementImg.getY(), null);
        }
    }

    private List<ElementImg> getElementImgs() {
        ArrayList<ElementImg> res = new ArrayList<>();
        for (int i = 0; i < level.height(); i++) {
            for (int j = 0; j < level.length(); j++) {
                res.add(new ElementImg(level.get(i,j), i, j));
            }
        }
        return res;
    }
}
