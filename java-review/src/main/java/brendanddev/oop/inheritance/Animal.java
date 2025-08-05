package brendanddev.oop.inheritance;

/**
 * The superclass that defines common properties and behaviors for all animals.
 * This class can be extended by specific animal types to inherit common functionality.
 */
public class Animal {

    protected String name;

    /**
     * Constructs a new Animal with the specified name
     */
    public Animal(String name) {
        this.name = name;
    }

    /**
     * Makes the animal produce a generic sound
     * Can be overridden by subclasses to provide specific behavior
     */
    public void speak() {
        System.out.println(name + " makes a sound.");
    }
    
}
