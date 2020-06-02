// GridFixedElement.java
// Author: De Campou Mathieu
// Date : 19/05/2020
package model.grid;

import model.element.FixedElement;
import model.util.Coordinate;

import java.io.Serializable;
import java.util.List;

/**
 * This class represents a Grid of FixedElement and implements Grid interface.
 * Uses a 2D ArrayList to stock FixedElement.
 */
public class GridFixedElement implements Grid, Serializable {

    List<List<FixedElement>> elements;

    public GridFixedElement(List<List<FixedElement>> elements) {
        this.elements = elements;
    }

    /**
     *
     * @param x
     * @param y
     * @return the model.element with coord (x,y) or null.
     */
    @Override
    public FixedElement get(int x, int y){
        if(x < 0 || x > height() || y < 0 || y > length()) return null;
        return elements.get(x).get(y);
    }

    @Override
    public FixedElement get(Coordinate coord){
        return get(coord.getX(), coord.getY());
    }

    /**
     * Returns number of goals.
     *
     * @return number of goals.
     */
    public int getNumGoals() {
        int res = 0;
        //For each line, a filter is applied to keep only GOAL, then the count is add to res.
        for(List<FixedElement> row : elements){
            res += row.stream().filter(element -> element == FixedElement.GOAL).count();
        }
        return res;
    }

    public int height() {
        return elements.size();
    }

    public int length() {
        return elements.get(0).size();
    }
}
