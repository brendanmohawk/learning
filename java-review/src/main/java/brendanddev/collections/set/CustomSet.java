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
     * Adds an elements to the set if it is not already present.
     * 
     * It first checks if the element exists using the contains() method,
     * if it dosent exist, it ensures there is enough capacity in the internal array,
     * and if there is, it appends the element at the end of the internal array and
     * increments the size of the set.
     * 
     * Time Complexity is O(n) since the linear search to check for duplicates is O(n),
     * and the operation to add to the end is O(1), but is considered amortized, ignoring
     * the potential O(n) cost of copying elements to a new array when the capacity is exceeded.
     * 
     * @param element Element to add
     * @return true if the element was added, false if it was already in the set
     */
    public boolean add(T element) {
        // Check if element already exists in the set
        if (this.contains(element)) {
            return false;
        }
        // Ensure there is enough capacity to add the new element
        ensureCapacity();
        // Store the new elements and increment the size
        elements[size++] = element;
        return true;
    }

    /**
     * Removes an element from the set if it exists.
     * 
     * It first finds the index of the element to be removed using a linear search.
     * If the element is found, it shifts all elements after it one position to the left,
     * to fill the gap left by the removed element. The slot the element is removed from
     * is set to null to help with garbage collection and prevent memory leaks.
     * 
     * The time complexity is O(n) in the worst case as it must shift almost all elements.
     * 
     * @param element The element to remove
     * @return true if the element was removed, false if it wasn’t found
     */
    public boolean remove(T element) {
        // Iterate through the elements to find the element to remove
        for (int i = 0; i < size; i++) {

            // Use equals() method to check for the element
            if (equals(elements[i], element)) {

                // If element is found, determine how many elements need to be shifted
                // Where number of elements to shift = total elements after removal target
                int numMoved = size - i - 1;

                // If there are elements to shift, shift them left
                // System.arraycopy is used to copy elements from i+1 to i
                if (numMoved > 0) {
                    System.arraycopy(elements, i + 1, elements, i, numMoved);
                }

                // Decrement the size of the set and clear the last element
                elements[--size] = null;
                return true;
            }
        }
        // Element was not found in the set
        return false;
    }

    /**
     * Returns the number of elements currently in the set
     * Time Complexity is O(1) since it simply returns the size variable
     * 
     * @return Number of elements currently in the set
     */
    public int size() {
        return size;
    }

    /**
     * Clears the contents of the set by filling the used portion of the internal
     * array with null values and resetting the size to 0.
     * 
     * Time complexity is O(n) since it requires filling 'n' positions in the array with null.
     */
    public void clear() {
        // Clear the internal array and reset size
        Arrays.fill(elements, 0, size, null);   // Only clear the used portion
        size = 0;
    }

    /**
     * Returns a copy of the sets elements in an array.
     * It only returns the portion of the array that is currently used, and contains data.
     * 
     * @return Object[] containing the elements of the set
     */
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    /**
     * Returns a string representation of the set
     */
    @Override
    public String toString() {
        return Arrays.toString(toArray());
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


    
}
