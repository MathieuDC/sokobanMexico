package model.level;

import model.element.Element;
import model.element.FixedElement;
import model.element.MovableElement;
import model.grid.GridFixedElement;
import model.grid.GridMovableElement;
import model.util.Coordinate;
import model.util.Direction;

import java.io.Serializable;

/**
 * Represents a field
 */
public class Field implements Serializable {

    private Coordinate characterCoord;

    private GridFixedElement fixedElements;

    private GridMovableElement movableElements;

    public Field(Coordinate characterCoord, GridFixedElement fixedElements, GridMovableElement movableElements) {
        this.characterCoord = characterCoord;
        this.fixedElements = fixedElements;
        this.movableElements = movableElements;
    }

    /**
     * Returns the model.element with coordinates (x,y), or null.
     *
     * @param x abscissa of the model.element
     * @param y ordinate of the model.element
     * @return the model.element with coordinates (x,y), or null.
     */
    public Element get(int x, int y){
        if(characterCoord != null && characterCoord.equals(x,y)){
            return MovableElement.CHARACTER;
        }
        return movableElements.get(x, y) == null ? fixedElements.get(x, y) : movableElements.get(x, y);
    }

    private Coordinate getNextCoord(Coordinate coord, Direction direction) {
        Coordinate res = new Coordinate(coord.getX(),coord.getY());
        switch (direction){
            case UP:
                res.setX(coord.getX() - 1);
                break;
            case DOWN:
                res.setX(coord.getX() + 1);
                break;
            case LEFT:
                res.setY(coord.getY() - 1);
                break;
            case RIGHT:
                res.setY(coord.getY() + 1);
                break;
        }
        return res;
    }

    /**
     * Moves the character in the given direction, if it's possible (i.e. the next cell is a FLOOR or a BOX).
     *
     * @param direction direction in which the character should move.
     */
    public void move(Direction direction){
        Coordinate nextElementCoord = getNextCoord(characterCoord, direction);

        FixedElement nextFixedElement = fixedElements.get(nextElementCoord);
        if(nextFixedElement == FixedElement.WALL || nextFixedElement == FixedElement.NONE) return;

        MovableElement nextMovableElements = movableElements.get(nextElementCoord);

        Element nextElement = nextMovableElements == null ? nextFixedElement : nextMovableElements;

        if(nextElement == MovableElement.BOX || nextElement == MovableElement.PLACED_BOX){
            if(fixedElements.get(getNextCoord(nextElementCoord, direction)) == FixedElement.WALL || movableElements.get(getNextCoord(nextElementCoord, direction)) != null) return;
            if(fixedElements.get(getNextCoord(nextElementCoord, direction)) == FixedElement.FLOOR) {
                movableElements.unplace(nextElementCoord);
                movableElements.move(nextElementCoord, direction);
                characterCoord.move(direction);
                return;
            }
            if(fixedElements.get(getNextCoord(nextElementCoord, direction)) == FixedElement.GOAL) {
                movableElements.place(nextElementCoord);
                movableElements.move(nextElementCoord, direction);
                characterCoord.move(direction);
                return;
            }
        }
        characterCoord.move(direction);
    }

    public void moveRight(){
        move(Direction.RIGHT);
    }

    public void moveLeft(){
        move(Direction.LEFT);
    }

    public void moveUp(){
        move(Direction.UP);
    }

    public void moveDown(){
        move(Direction.DOWN);
    }

    public int getNumGoals() {
        return fixedElements.getNumGoals();
    }

    public int getNumPlacedBoxes() {
        return movableElements.getNumPlacedBoxes();
    }

    public int height() {
        return fixedElements.height();
    }

    public int length() {
        return fixedElements.length();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < fixedElements.height(); i++) {
            for (int j = 0; j < fixedElements.length(); j++) {
                res.append(get(i,j));
            }
            res.append('\n');
        }
        return res.toString();
    }
}
