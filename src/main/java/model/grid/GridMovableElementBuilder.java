//  GridMovableElementBuilder.java       Author: De Campou Mathieu

package model.grid;

import model.element.MovableElement;
import model.util.Coordinate;

import java.util.HashMap;

/**
 * This class is used to build a GridMovableElement.
 */
public class GridMovableElementBuilder implements GridBuilder {

    public HashMap<Coordinate, MovableElement> movableElements;

    public GridMovableElementBuilder() {
        movableElements = new HashMap<>();
    }

    public void add(int x, int y, MovableElement element){
        movableElements.put(new Coordinate(x,y), element);
    }

    @Override
    public GridMovableElement build() {
        return new GridMovableElement(movableElements);
    }
}
