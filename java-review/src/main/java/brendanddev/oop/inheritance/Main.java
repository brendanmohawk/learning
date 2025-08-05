package brendanddev.oop.inheritance;

public class Main {

    public static void main(String[] args) {

        // Creates a generic Animal object
        Animal genericAnimal = new Animal("GenericAnimal");
        genericAnimal.speak();

        // Creates a Dog object
        Dog buddy = new Dog("Buddy");
        buddy.speak();         
        buddy.fetch(); 

        // Polymorphism: Dog referenced as an Animal

        // Dog referenced as an Animal object
        // Reference type is Animal, object type is Dog
        Animal anotherDog = new Dog("Max");

        // Calls the overridden speak method in Dog
        anotherDog.speak();

        // Will throw compiler time error
        // Animal cannot access Dog specific methods
        // But we can cast it back to Dog
        // if we know it is actually a Dog
        // anotherDog.fetch();
    }

}