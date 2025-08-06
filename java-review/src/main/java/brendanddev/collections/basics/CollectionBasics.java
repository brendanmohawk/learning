package brendanddev.collections.basics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Basic demonstration of using the Collection interface and its methods.
 * 
 * The Collection interface is part of the Java Collections Framework and 
 * provides a way to work with groups of objects.
 */
public class CollectionBasics {
    public static void main(String[] args) {

        // Can declare with Collection as reference type and
        // ArrayList as object type since the ArrayList class 
        // implements the Collection interface
        Collection<String> collection = new ArrayList<>();
        collection.add("Hello");
        collection.add("World");

        // Check size
        System.out.println("Collection size: " + collection.size());

        // Check if collection contains an element
        System.out.println("Collection contains 'Hello': " + collection.contains("Hello"));

        // Remove an element
        collection.remove("Hello");
        System.out.println("Collection after removing 'Hello': " + collection);

        // Iterate through the collection
        System.out.println("Iterating through collection:");
        for (String item : collection) {
            System.out.println(item);
        }

        // Clear the collection
        collection.clear();
        System.out.println("Collection after clearing: " + collection.size());
        System.out.println("Collection is empty: " + collection.isEmpty());
    }
}
