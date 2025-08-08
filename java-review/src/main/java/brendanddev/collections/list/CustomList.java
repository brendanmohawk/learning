package brendanddev.collections.list;

import java.util.Iterator;

/**
 * This class demonstrates a simplified generic dynamic array implementation similar to Java's ArrayList.
 * 
 * It provides a resizable list of elements that internally stores elements in a generic array, resizing automatically as elements are added.
 * It supports adding, retrieving, and removing elements by index, and uses a resizing strategy that increases capacity by 50% when needed to 
 * balance memory usage and performance. It also implements Iterable<E>, providing an anonymous inner class iterator for element traversal.
 * The class handles nulling removed elements to help Java's garbage collector reclaim unused objects.
 * 
 * Since generic arrays cannot be created directly in Java, the underlying array is created as Object[] and cast to E[] to satisfy type safety.
 * Index bounds are checked for all access methods to ensure safety and consistent exception handling, and the iterator is implemented as an 
 * anonymous inner class enabling easy access to outer class members without needing a separate Iterator implementation class.
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
     * Ensures that the underlying array has enough capacity to hold at least minCapacity elements.
     * If not, resizes the array to a larger capacity.
     * 
     * This resizing strategy increases capacity by 50% of the current size, similar to how the
     * ArrayList class in Java resizes internally.
     * 
     * @param minCapacity The minimum capacity required
     */
    public void ensureCapacity(int minCapacity) {

        // Check if resize is needed
        if (minCapacity > elements.length) {

            // Increase the capacity of the array by 50%
            int newCapacity = elements.length + (elements.length / 2);

            // Ensure new capacity is at least minCapacity
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            // Create a new array with the larger capacity and copy elements over
            E[] newElements = (E[]) new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    /**
     * Checks if the provided index is within the bounds of the list
     * 
     * @param index The index to check
     * @throws IndexOutOfBoundsException If index is invalid
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Adds a new element to the end of the list, resizing if necessary.
     * 
     * @param element The element to add to the list
     */
    public void add(E element) {
        // Ensure there is enough space, resize if needed
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    /**
     * Retrieves the element at the specified index after validating the index is within bounds.
     * 
     * @param index The index of the element to retrieve (0-based)
     * @return The element at the given index
     * @throws IndexOutOfBoundsException If index is out of range
     */
    public E get(int index) {
        // Validate the index is within bounds of the list
        checkIndex(index);
        return elements[index];
    }

    /**
     * Removes the element at the specified index and shifts subsequent elements left.
     * The array element is dereferenced (setting array slot to null) to allow Javas garbage collector
     * to reclaim memory. This is done because the garbage collection can only reclaim memory if there 
     * are no live references to an object.
     * 
     * @param index the index of the element to remove (0-based)
     * @return the removed element
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public E remove(int index) {
        // Validate the index is within bounds of the list
        checkIndex(index);
        E removedElement = elements[index];
        // Shift elements left to fill the gap
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Clear to let GC do its work
        return removedElement;
    }

    /**
     * Retrieves the current number of elements in the list
     * 
     * @return The size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of the CustomList, showing all elements in order
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
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
