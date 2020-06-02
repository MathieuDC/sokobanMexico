package model.grid;

import model.element.Element;
import model.util.Coordinate;

public interface Grid {
    Element get(int x, int y);

    Element get(Coordinate coord);
}
