package brendanddev.collections.list;

import java.util.Iterator;

/**
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


    @Override
    public Iterator<E> iterator() { }
    
}
