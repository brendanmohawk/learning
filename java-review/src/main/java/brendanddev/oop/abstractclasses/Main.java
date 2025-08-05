package brendanddev.oop.abstractclasses;

public class Main {
    public static void main(String[] args) {
        
        // Will throw error as shape cannot be instantiated directly
        // Shape shape = new Shape("Green");

        // Will throw compiler error as Shape is abstract
        // The object type of Shape cannot be instantiated
        // Rectangle rectangle2 = new Shape("Blue", 3, 4);



        // Use methods defined in Shape, implemented by Rectangle
        Rectangle rectangle = new Rectangle("Red", 5, 10);
        rectangle.displayColor();
        System.out.println("Rectangle area: " + rectangle.getArea());
        

        Shape shape = new Rectangle(null, 0, 0);
        shape.displayColor();
        System.out.println("Shape reference to Rectangle area: " + shape.getArea());

    }
    
}
