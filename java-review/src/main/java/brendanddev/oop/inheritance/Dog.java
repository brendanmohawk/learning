package brendanddev.oop.inheritance;

/**
 * Defines the subclass Dog, which inherits (is a type of) from Animal.
 * This class inherits common animal behavior and adds dog specific functionality.
 */
public class Dog extends Animal {

    /**
     * Constructs a new Dog with the specified name
     * Invokes the superclass constructor to initialize the name field
     */
    public Dog(String name) {
        super(name);
    }

    /**
     * Provides a dog-specific implementation of the speak behavior.
     * Overrides the speak method defined in Animal.
     */
    @Override
    public void speak() {
        System.out.println(name + " barks.");
    }

    /**
     * Performs a dog-specific action: fetching a ball.
     * This behavior is unique to the Dog class and not present in Animal.
     */
    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
    
}
