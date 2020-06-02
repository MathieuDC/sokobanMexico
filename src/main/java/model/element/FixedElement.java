package model.element;

public enum FixedElement implements Element {
    WALL("W"),
    FLOOR("F"),
    GOAL("G"),
    NONE("N");

    private String value;

    private FixedElement(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
