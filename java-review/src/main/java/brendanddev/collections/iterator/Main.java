package brendanddev.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        SimpleContainer<String> container = new SimpleContainer<>();

        // Add some elements
        container.add("Apple");
        container.add("Banana");
        container.add("Cherry");
        container.add("Date");

        System.out.println("Initial container: " + container);

        // Use iterator to print elements
        System.out.print("Iterating elements: ");
        Iterator<String> it = container.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Use iterator again to remove an element
        it = container.iterator();
        while (it.hasNext()) {
            String fruit = it.next();
            if ("Banana".equals(fruit)) {
                it.remove();  // Remove Banana
                System.out.println("Removed: " + fruit);
            }
        }

        System.out.println("After removal: " + container);

        // Demonstrate exception handling on next()
        try {
            it.next(); // Should throw NoSuchElementException because iterator is at end
        } catch (NoSuchElementException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        // Show remove() called without next() first throws exception
        it = container.iterator();
        try {
            it.remove();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }

}
