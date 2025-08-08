package brendanddev.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple container class that demonstrates how to implement Iterator interface.
 * This shows the basic pattern for making any custom collection iterable.
 */
public class SimpleContainer<T> implements Iterable<T> {
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public SimpleContainer() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    /**
     * Add an element to the container
     */
    public void add(T element) {
        if (size >= elements.length) {
            resize();
        }
        elements[size++] = element;
    }
    
    /**
     * Get element at specific index
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }
    
    /**
     * Get current size
     */
    public int size() {
        return size;
    }
    
    /**
     * Resize internal array when needed
     */
    private void resize() {
        T[] newElements = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
    
    /**
     * Implementation of Iterable interface - must return an Iterator
     * This uses an anonymous inner class.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            private boolean canRemove = false;
            
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }
            
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                canRemove = true;  // Mark that we can now remove
                return elements[currentIndex++];
            }
            
            @Override
            public void remove() {
                if (!canRemove) {
                    throw new IllegalStateException("Cannot remove - call next() first");
                }
                
                // Remove the last element returned by next()
                int indexToRemove = currentIndex - 1;
                
                // Shift elements left to fill the gap
                for (int i = indexToRemove; i < size - 1; i++) {
                    elements[i] = elements[i + 1];
                }
                
                // Clean up and adjust
                elements[--size] = null;  // Help GC and decrement size
                currentIndex--;           // Adjust current position
                canRemove = false;        // Reset remove flag
            }
        };
    }
    
    /**
     * String representation for easy printing
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}