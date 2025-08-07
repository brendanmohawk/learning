package brendanddev.collections.list;

import java.util.Iterator;

/**
 * 
 * WHY ANONYMOUS CLASS IS USED HERE:
     * - Iterator is only needed internally by this CustomList
     * - No reusability outside this context
     * - Keeps related code together (iterator logic stays with the collection)
     * - Cleaner than creating a separate IteratorImpl.java file
     * - Has implicit access to outer class members (closure over CustomList state)


 * 
 */
public class CustomList<E> implements Iterable<E> {

    // Define default initial capacity if none specified
    private static final int DEFAULT_CAPACITY = 10;

    // Underlying array to store generic list elements
    private E[] elements;

    // Current number of elements in the list
    private int size = 0;

    /**
     * Constructs an empty CustomList with the default initial capacity
     */
    public CustomList() {
        // Java dosnt allow generic array creation directly,
        // so create Object[] and cast to E[]
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty CustomList with the specified initial capacity
     * @param initialCapacity
     */
    public CustomList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than zero");
        }
        elements = (E[]) new Object[initialCapacity];
    }

    /**
     * Declares a anonymous inner class that implements the Iterator<E> interface.
     * The anonymous class appears as if it has a method body since the method iterator() returns an instance
     * of the interface. Instead of returning a named class instance, it returns a new instance of an anonymous class
     * that implements the Iterator<E> interface inline. This creates a one off implementation of the interface without 
     * needing to write a named class.
     * 
     * Since CustomList implements the Iterable interface (Iterable<E>), it must provide an implementation
     * of the iterator() method. This method returns an Iterator<E> that can be used to traverse the elements
     * of the CustomList without exposing its internal structure.
     */
    @Override
    public Iterator<E> iterator() { 

        // The actual anonymous inner class implementation starts here
        // This 'new Iterator<E>() { ... }' syntax creates an unnamed class that
        // implements Iterator<E> and returns an instance of it immediately
        return new Iterator<E>() {

            // Current position in the iteration
            // Each iterator instance has its own cursor, allowing multiple iterators
            // to traverse the same CustomList simultaneously without interfering
            int cursor = 0;

            /**
             * Checks if there are more elements to iterate over.
             * This method is called before each call to next() to avoid going
             * beyond the collection bounds.
             * 
             * @return true if there are more elements, false if we've reached the end
             */
            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            /**
             * Returns the next element in the iteration and advances the cursor.
             * This method should only be called if hasNext() returns true.
             * 
             * @return the next element of type E
             * @throws IndexOutOfBoundsException if there are no more elements
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("No more elements to iterate over");
                }
                return elements[cursor++];
            }
        };
    }



    
}
