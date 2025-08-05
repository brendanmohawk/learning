package brendanddev.oop.polymorphism;

/**
 * Represents a Car, which is a type of vehicle.
 * Overrides the drive method to provide car specific behavior.
 * 
 * The 'extends' keyword indicates that Car is a subclass of Vehicle,
 * inheriting its properties and methods.
 */
public class Car extends Vehicle {

    /** 
     * Constructs a Car object
     */
    public Car(String model) {
        // Call the superclass constructor to set the model
        super(model); 
    }

    /**
     * Overrides the drive method from Vehicle to provide a car-specific implementation.
     * This method is called when a Car object is driven, demonstrating polymorphism.
     */
    @Override
    public void drive() {
        // Provide a car-specific implementation of the drive method
        System.out.println(model + " is driving smoothly on the road.");
    }
}
