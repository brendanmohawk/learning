package brendanddev.oop.abstractclasses;

/**
 * Defines an abstract class Shape that serves as a base for all shapes.
 * An abstarct class cannot be instantiated directly, but can be called by subclasses.
 * It can have both abstract methods (without a body) and concrete methods (with a body).
 * An abstract class defines a contract for sublasses to implement specific behaviors.
 */
public abstract class Shape {

    protected String color;

    /**
     * Constructor to create an instance of the Shape with a specified color
     * @param color
     */
    public Shape(String color) {
        this.color = color;
    }

    /**
     * Abstract method to calculate area.
     * Must be implemented by all concrete subclasses.
     */
    public abstract double getArea();

    /**
     * Concrete method common to all shapes to display their color.
     */
    public void displayColor() {
        System.out.println("Shape color: " + color);
    }

    
}
