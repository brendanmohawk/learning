package brendanddev.collections.equalsandhashcode;


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
