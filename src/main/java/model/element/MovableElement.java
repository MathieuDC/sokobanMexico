package model.element;

public enum MovableElement implements Element {
    BOX("B"),
    PLACED_BOX("P"),
    CHARACTER("C");

    private String value;

    MovableElement(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
