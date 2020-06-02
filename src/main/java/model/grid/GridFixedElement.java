package model.grid;

import model.element.FixedElement;
import model.util.Coordinate;

import java.io.Serializable;
import java.util.List;

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
