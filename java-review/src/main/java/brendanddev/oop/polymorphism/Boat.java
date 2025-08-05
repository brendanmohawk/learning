package brendanddev.oop.polymorphism;

/**
 * Represents a Boat, which is a type of Vehicle.
 * Overrides the drive method to provide boat specific behavior.
 */
public class Boat extends Vehicle {

    /**
     * Constructs a Boat object
     */
    public Boat(String model) {
        // Call the superclass constructor to set the model
        super(model); 
    }

    /**
     * Overrides the drive method from Vehicle to provide a boat-specific implementation.
     * This method is called when a Boat object is driven, demonstrating polymorphism.
     */
    @Override
    public void drive() {
        // Provide a boat-specific implementation of the drive method
        System.out.println(model + " is sailing smoothly on the water.");
    }
    
}
