//  Author : De Campou Mathieu
// Date : 19/05/2020

package model.grid;

import model.element.MovableElement;
import model.util.Coordinate;
import model.util.Direction;

import java.io.Serializable;
import java.util.*;

/**
 * This class represents a Grid of MovableElement and implements Grid interface.
 * Uses HashMap to associate Coordinate to MovableElement.
 */
public class GridMovableElement implements Grid, Serializable {

    private HashMap<Coordinate, MovableElement> elements;

    public GridMovableElement(HashMap<Coordinate, MovableElement> elements) {
        this.elements = elements;
    }

    /**
     * Marks the BOX with coordinate coord as PLACED_BOX.
     * Does nothing if the BOX doesn't exist.
     */
    public void place(Coordinate coord) {
        if(!elements.containsKey(coord)) return; //TODO Handle error

        elements.put(coord, MovableElement.PLACED_BOX);
    }

    /**
     * Marks the PLACED_BOX with coordinate coord as BOX.
     * Does nothing if the PLACED_BOX doesn't exist.
     */
    public void unplace(Coordinate coord) {
        if(!elements.containsKey(coord)) return; //TODO Handle error

        elements.put(coord, MovableElement.BOX);
    }

    public void move( Coordinate elementCoord, Direction direction) {
        if(!elements.containsKey(elementCoord)) return; //TODO Handle error

        MovableElement element =  elements.remove(elementCoord);

        switch (direction){
            case UP:
                elementCoord.moveUp();
                break;
            case DOWN:
                elementCoord.moveDown();
                break;
            case LEFT:
                elementCoord.moveLeft();
                break;
            case RIGHT:
                elementCoord.moveRight();
                break;
        }

        elements.put(elementCoord, element);
    }

    public void moveRight(Coordinate coord) {
        move(coord, Direction.RIGHT);
    }

    public void moveRight(int x, int y){
        moveRight(new Coordinate(x, y));
    }

    public void moveLeft(Coordinate coord) {
        move(coord, Direction.LEFT);
    }

    public void moveLeft(int x, int y) {
        moveLeft(new Coordinate(x, y));
    }

    public void moveUp(Coordinate coord) {
        move(coord, Direction.UP);
    }

    public void moveUp(int x, int y) {
        moveUp(new Coordinate(x, y));
    }

    public void moveDown(Coordinate coord) {
        move(coord, Direction.DOWN);
    }

    public void moveDown(int x, int y) {
        moveDown(new Coordinate(x, y));
    }

    public Set<Coordinate> getCoords() {
        return elements.keySet();
    }

    @Override
    public MovableElement get(int x, int y) {
        return get(new Coordinate(x,y));
    }

    @Override
    public MovableElement get(Coordinate coord) {
        return elements.get(coord);
    }

    /**
     * @return number of placed boxes.
     */
    public int getNumPlacedBoxes() {
        return (int) elements.values().stream().filter(element -> element == MovableElement.PLACED_BOX).count();
    }
}
