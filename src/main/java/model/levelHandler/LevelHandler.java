//  Author : Puy Guillaume
//  Date : 22/05/2020

package model.levelHandler;

import model.level.Level;
import model.util.LevelReader;

import java.io.IOException;
import java.io.Serializable;

public class LevelHandler implements Serializable {

    private static final Long serialVersionUID = 1L;

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
