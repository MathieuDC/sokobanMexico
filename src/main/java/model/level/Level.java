package model.level;

import model.element.Element;

import java.io.Serializable;

public class Level implements Serializable {

    private Field field;

    public Level(Field field) {
        this.field = field;
    }

    public void moveRight(){
        if(gameOver()) return;
        field.moveRight();
    }

    public void moveLeft(){
        if(gameOver()) return;
        field.moveLeft();
    }

    public void moveUp(){
        if(gameOver()) return;
        field.moveUp();
    }

    public void moveDown(){
        if(gameOver()) return;
        field.moveDown();
    }

    public Element get(int i, int j) {
        return field.get(i,j);
    }

    public boolean gameOver(){
        return field.getNumPlacedBoxes() == field.getNumGoals();
    }

    public int height() {
        return field.height();
    }

    public int length(){
        return field.length();
    }

    /**
     * "Transforms" this level in the given level. THis method is necessary because sometimes we need to update a level,
     * (e.g. for restarting) without changing the reference of the variable.
     *
     * @param level the level to copy
     */
    public void copy(Level level){
        field = level.field;
    }

    @Override
    public String toString() {
        return field.toString();
    }
}
