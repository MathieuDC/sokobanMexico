package view;

import model.levelHandler.LevelHandler;
import model.util.LevelReader;
import model.util.LevelWriter;
import view.level.LevelWrapperPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static java.lang.System.exit;

public class SokobanFrame extends JFrame {

    private LevelHandler levelHandler = new LevelHandler();

    private LevelWrapperPanel levelWrapperPanel;

    private KeyListener nextLevelKeyListener;

    private JButton startButton;

    private JButton loadButton;

    private JPanel mainMenuPanel;

    public SokobanFrame() throws IOException {
        this.setTitle("Sokoban");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        initMenuPanel();
        add(mainMenuPanel);

        this.setSize(500, 400);
        this.setVisible(true);

        initNextLevelKeyListener();
    }

    private void initNextLevelKeyListener() {
        nextLevelKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                nextLevel();
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        };
    }

    private void initMenuPanel() {
        initStartButton();
        initLoadButton();
        mainMenuPanel = new JPanel();
        mainMenuPanel.add(startButton);
        mainMenuPanel.add(loadButton);
    }

    private void initLoadButton(){
        loadButton = new JButton("Load Game");
        loadButton.setSize(100, 25);
        loadButton.setMaximumSize(getSize());
        loadButton.addActionListener(actionEvent -> {
            LevelReader levelReader = new LevelReader();
            levelHandler = levelReader.load();
            displayLevel();
        });
    }

    private void initStartButton() {
        startButton = new JButton("Start");
        startButton.setSize(100, 25);
        startButton.setMaximumSize(getSize());
        startButton.addActionListener(actionEvent -> {
            displayLevel();
        });
    }

    private void displayLevel(){
        remove(mainMenuPanel);

        levelWrapperPanel = new LevelWrapperPanel(levelHandler, this);
        add(levelWrapperPanel);
        levelWrapperPanel.requestFocus();

        setVisible(true);
    }

    public void displayNextLevelMenu() {
        //remove(levelWrapperPanel);
        levelWrapperPanel.displayNextLevelLabel();
        addKeyListener(nextLevelKeyListener);
        requestFocus();
        setVisible(true);
    }

    private void nextLevel() {
        remove(levelWrapperPanel);
        removeKeyListener(nextLevelKeyListener);

        this.levelHandler.nextLevel();
        levelWrapperPanel = new LevelWrapperPanel(levelHandler, this);
        add(levelWrapperPanel);
        levelWrapperPanel.requestFocus();

        setVisible(true);
    }

    public void restartCurrentLevel() {
        levelHandler.restartCurrentLevel();
        repaint();
        levelWrapperPanel.requestFocus();
    }

    public void saveCurrentLevel() {
        LevelWriter levelWriter = new LevelWriter();
        levelWriter.save(levelHandler);
        exit(0);
    }
}
