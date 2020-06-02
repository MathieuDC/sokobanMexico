//  Grid.java       Author: Puy Guillaume

package model.grid;

import model.element.Element;
import model.util.Coordinate;

/**
 * Interface used to represents a Grid of Element.
 */
public interface Grid {
    Element get(int x, int y);

    Element get(Coordinate coord);
}
