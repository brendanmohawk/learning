package brendanddev.collections.customobjects;


/**
 * This class represents a custom object that can be stored and used in Java collections.
 * It demonstrates how to correctly override the 'equals' and 'hashCode' methods to ensure proper behavior in
 * hash based collections like HashSet and HashMap. It abides by the contract of the equals and hashCode methods,
 * that says if two objects are equal according to the equals method, they must return the same hash code.
 * 
 * This class also implements the Comparable interface, which defines a natural ordering for instances of the 
 * class based on their value field. This is important when storing objects in sorted collections like a TreeSet
 * or when sorting a List.
 */
public class CustomObject implements Comparable<CustomObject> {

    private String name;
    private int value;
    private int id;

    // Construct an instance of the CustomObject object
    public CustomObject(String name, int value, int id) {
        this.name = name;
        this.value = value;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    /**
     * Compares a CustomObject with another CustomObject to determine if they
     * are equal based on their id fields.
     *
     * This method overrides the equals method from the Object class to provide
     * a custom equality check for instances of CustomObject.
     */
    @Override
    public boolean equals(Object o) {
        // Check if the two references are the same object
        if (this == o) return true;
    
        // Check if the object is null or if the two objects are 
        // instances of the same class
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        // Cast the object to CustomObject
        CustomObject other = (CustomObject) o;
        // Compare the id fields of both objects
        return this.id == other.id;
    }

    /**
     * Generates a hash code for the CustomObject based on its id field which is used 
     * to determine the object's hash code in hash-based collections like HashSet.
     * 
     * The contract for hashCode states that if two objects are equal according to the equals method,
     * they must return the same hash code. This ensures that the hash-based collections can function
     */
    @Override
    public int hashCode() {
        // Use the Integer class's hashCode method to generate a hash code
        // for the primitive int id field
        // This ensures that the hash code is consistent with the equals method
        return Integer.hashCode(id);
    }


    /**
     * Compares this CustomObject with another CustomObject based on their value fields.
     * This method is used to define the natural ordering of CustomObject instances.
     * 
     * The compareTo method is part of the Comparable interface, which allows objects 
     * of the same class to be compared to each other.
     */
    @Override
    public int compareTo(CustomObject other) {
        // Compare this CustomObject's value with another CustomObject's value
        // Returns a negative integer, zero, or a positive integer as this object
        // is less than, equal to, or greater than the specified object.
        return Integer.compare(this.value, other.value);
    }
    
}
