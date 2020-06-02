package model.levelHandler;

import model.level.Level;
import model.util.LevelReader;

import java.io.IOException;
import java.io.Serializable;

public class LevelHandler implements Serializable {

    public final static int MAX_INDEX_LEVEL = 3;

    private Level currentLevel;

    private int indexCurrentLevel = 1;

    /**
     * This constructor is used when the player start a game. It will automatically load the first level.
     */
    public LevelHandler() {
        try {
            LevelReader levelReader = new LevelReader();
            currentLevel = levelReader.read(indexCurrentLevel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This constructor is used when the player load an existing game.
     *
     * @param currentLevel The level that has been load.
     * @param indexCurrentLevel Index of the level.
     */
    public LevelHandler(Level currentLevel, int indexCurrentLevel) {
        this.currentLevel = currentLevel;
        this.indexCurrentLevel = indexCurrentLevel;
    }

    public void nextLevel()  {
        try {
            if(indexCurrentLevel + 1 <= MAX_INDEX_LEVEL){
                indexCurrentLevel++;
            }
            LevelReader levelReader = new LevelReader();
            currentLevel = levelReader.read(indexCurrentLevel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public int getIndexCurrentLevel() {
        return indexCurrentLevel;
    }

    public void restartCurrentLevel() {
        try {
            LevelReader levelReader = new LevelReader();
            currentLevel.copy(levelReader.read(indexCurrentLevel));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
