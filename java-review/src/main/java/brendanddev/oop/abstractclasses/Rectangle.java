package brendanddev.oop.abstractclasses;


/**
 * Defines the Rectangle class, which is a concrete subclass of the Shape abstract class.
 * It provides a specific implementation for calculating the area of a rectangle.
 */
public class Rectangle extends Shape {

    private double width;
    private double height;

    /**
     * Constructs a Rectangle object
     * Makes a call to the superclass constructor to set the color
     */
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    /**
     * Implementation of abstract method getArea() for rectangle.
     */
    @Override
    public double getArea() {
        return width * height;
    }


    
}
