package view;

import model.levelHandler.LevelHandler;
import view.levelAction.LevelDownAction;
import view.levelAction.LevelLeftAction;
import view.levelAction.LevelRightAction;
import view.levelAction.LevelUpAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class LevelWrapperPanel extends JPanel {

    private LevelPanel levelPanel;

    private LevelMenuPanel levelMenuPanel;

    private JLabel nextLevelLabel;

    public LevelWrapperPanel(LevelHandler levelHandler, SokobanFrame sokobanFrame) {
        super(new BorderLayout());
        levelPanel = new LevelPanel(levelHandler, sokobanFrame);
        levelMenuPanel = new LevelMenuPanel(sokobanFrame, levelHandler.getIndexCurrentLevel());
        add(levelMenuPanel, BorderLayout.SOUTH);
        initKeyEvent(levelHandler, sokobanFrame);

        nextLevelLabel = new JLabel("You won ! Press any key to continue.");
    }

    private void initKeyEvent(LevelHandler levelHandler, SokobanFrame sokobanFrame) {
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0),"left");
        getActionMap().put("left", new LevelLeftAction(levelHandler.getCurrentLevel(), sokobanFrame));

        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0),"right");
        getActionMap().put("right", new LevelRightAction(levelHandler.getCurrentLevel(), sokobanFrame));

        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),"down");
        getActionMap().put("down", new LevelDownAction(levelHandler.getCurrentLevel(), sokobanFrame));

        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),"up");
        getActionMap().put("up", new LevelUpAction(levelHandler.getCurrentLevel(), sokobanFrame));
    }

    public void displayNextLevelLabel() {
        requestFocus(false);
        remove(levelMenuPanel);
        add(nextLevelLabel, BorderLayout.CENTER);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        levelPanel.paintComponent(g);
    }
}
