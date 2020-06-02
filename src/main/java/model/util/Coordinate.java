//  Coordinate.java
//  Author: Baudorre Grégoire
//  Date : 22/05/2020

package model.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents a coordinate of an Element in a Grid.
 */
public class Coordinate implements Serializable {

    private int x;

    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Direction direction) {
        switch (direction){
            case UP:
                setX(x - 1);
                break;
            case DOWN:
                setX(x + 1);
                break;
            case LEFT:
                setY(y - 1);
                break;
            case RIGHT:
                setY(y + 1);
                break;
        }
    }

    public void moveRight() {
        setY(y + 1);
    }

    public void moveLeft(){
        setY(y - 1);
    }

    public void moveUp() {
        setX(x - 1);
    }

    public void moveDown() {
        setX(x + 1);
    }

    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(int x, int y){
        return equals(new Coordinate(x,y));
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
