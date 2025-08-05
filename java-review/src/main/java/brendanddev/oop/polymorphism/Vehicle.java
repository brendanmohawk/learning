package brendanddev.oop.polymorphism;

/**
 * Base class representing a generic Vehicle.
 * This class demonstrates polymorphism by providing a common method to be overridden by subclasses.
 * The drive method is intended to be overridden by subclasses to specify behavior for different types of vehicles.
 */
public class Vehicle {

    protected String model;

    public Vehicle(String model) {
        this.model = model;
    }

    /**
     * Generic drive method.
     * Subclasses will override this to provide specific driving behavior
     */
    public void drive() {
        System.out.println(model + " is driving.");
    }
    
}
