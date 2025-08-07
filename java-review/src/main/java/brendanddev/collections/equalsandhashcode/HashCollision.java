package brendanddev.collections.equalsandhashcode;

import java.util.Objects;

/**
 * This class represents an HashCollision object with a name and an id.
 * It demonstrates the importance of a well designed hashCode method when using objects in 
 * hash-based collections like HashSet or HashMap.
 * 
 * The HashCollision class overrides equals and hashCode, but the hashCode implementation is
 * intentionally poor, using only 'id % 2' as the hash code.
 * 
 * A hash collison occurs when two distinct objects produce the same hash code. Excessive hash collisions
 * degrade the performance of hash-based collections by increasing the number of objects stored in the same 
 * bucket, leading to slower lookup, insertion, and deletion operations.
 * 
 * In this example, since the hash code depends only on whether the id is even or odd, many objects will share
 * the same hash code (only two possible hash codes: 0 or 1), resulting in frequent collisions.
 */
public class HashCollision {

    private final String name;
    private final int id;

    // Construct an instance of the CollidingObject object
    public HashCollision(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * Compares a HashCollision with another HashCollision object to determine if they
     * are equal based on their id and name fields.
     */
    @Override
    public boolean equals(Object o) {
        // Check if the two references are the same object
        if (this == o) return true;
        // Check if the object is null or if the two objects are of the same class
        if (o == null || getClass() != o.getClass()) return false;
        // Cast the object to CollidingObject
        HashCollision other = (HashCollision) o;
        // Compare the id and name fields of both objects
        return this.id == other.id && this.name.equals(other.name);
    }

    /**
     * Generates a hash code for the HashCollision object based on its id field.
     */
    @Override
    public int hashCode() {
        return id % 2; // Poor hash function to demonstrate collisions
    }

    /**
     * Provides a string representation of the HashCollision instance, including its name and id.
     */
    @Override
    public String toString() {
        return "HashCollision{name='" + name + "', id=" + id + "}";
    }
    
}

/**
 * Better implementation for comparison
 * 
 * This version of the class uses a much stronger hashCode implementation by combining both name and id fields into the calculation. It
 * uses Java's built in Objects.hash(), which applies a algorithm to generate a more evenly distributed range of hash codes.
 * 
 * It is considered better because it uses more fields to generate the hash code, both of which are unique identifiers for the object,
 * increasing the variety of hash outputs and reducing the likelihood of collisions. The algorithm also distributes values more evenly 
 * across buckets, keeping operations fast and efficient, and reducing clustering. This leads to a lower collision rate, meaning fewer 
 * different objects will end up with the same hash code, keeping operations fast.
 * 
 * The  Objects.hash() method is a utility method that internally calls the Arrays.hashCode(Object[]) method, which iterates over each field
 * and combines their hash codes using a prime multiplier (like 31) to produce a final hash. This spreads values well across the integer space,
 * making it less likely for different objects to produce the same hash code.
 * 
 * Typically in a HashMap or HashSet, the hash code is processed, often with some bit shifting and masking, to pick a bucket index. The better
 * and more uniform the distribution of hash codes, the more evenly objects are spread across the buckets, and the faster lookups remain.
 */
class BetterHashCollision {
    private final String name;
    private final int id;
    
    public BetterHashCollision(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Compares this BetterHashCollision object with another object for equality 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetterHashCollision other = (BetterHashCollision) o;
        return this.id == other.id && Objects.equals(this.name, other.name);
    }

    /**
     * Provides a better hash code implementation that combines both name and id fields, using the Objects.hash() method
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
    
    @Override
    public String toString() {
        return "BetterHashCollision{name='" + name + "', id=" + id + ", hash=" + hashCode() + "}";
    }
}