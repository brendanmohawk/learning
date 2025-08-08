package brendanddev.collections.set;

import java.util.Arrays;

/**
 * This class defines a custom implementation of a Set like data structure, CustomSet.
 * It mimics the behavior of a Set, which is a collection that does not allow duplicate elements.
 * 
 * This class stores unique elements only, is backed by a simple dynamically resizing array, and provides
 * basic operations such as adding elements, checking for existence, getting the size, and removing elements.
 */
public class CustomSet<T> {

    // Internal array to hold the elements of the set
    private Object[] elements;

    // Current number of elements in the set
    private int size;

    // The default capacity of the sets internal array
    private static final int DEFAULT_CAPACITY = 10;


    /**
     * Constructs an instance of the CustomSet with a default capacity
     */
    public CustomSet() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Ensures the internal array has enough space/capacity to add a new element.
     * If the array is full, it creates a new array with double the size and copies the elements
     * from the old array to the new one.
     * 
     * This operation is O(n) in time complexity, because copying elements takes time proportional
     * to the number of elements in the set 'n'.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            // Double capacity
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    /**
     * Performs a null safe equality check for two objects.
     * It returns true if both references point to the same object, or if the two objects
     * are considered equal according to their equals() method.
     * 
     * @param a First object
     * @param b Second object
     * @return true if the objects are considered equal, false otherwise
     */
    private boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    /**
     * Checks if the set contains a given element.
     * 
     * Time Complexity is O(n) in the worst case since it must check each stored element
     * 
     * @param element Element to check
     * @return true if the element exists in the set, false otherwise
     */
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (equals(elements[i], element)) {
                return true;
            }
        }
        return false;
    }

    








    
}
