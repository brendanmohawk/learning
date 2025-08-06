package brendanddev.collections.basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * A very basic demonstration of using List and Set collections in Java.
 * 
 * List is a interface that extends (inherits from) the Collection interface,
 * and the ArrayList class implements the List interface.
 * 
 * Set is another interface that also extends the Collection interface, and
 * the HashSet class implements the Set interface.
 * 
 * List allows duplicate elements and maintains insertion order,
 * while Set does not allow duplicates and does not guarantee any specific order.
 * 
 * Since both List and Set are part of the Java Collections Framework, they can
 * be used interchangeably with the Collection interface.
 */
public class ListAndSet {
    public static void main(String[] args) {

        // Can create a ArrayList as a reference type of List
        // since ArrayList implements the List interface
        List<String> list = new ArrayList<>();

        // Can create a HashSet as a reference type of Set
        // and objet type of HashSet since HashSet implements the Set interface
        Set<String> set = new HashSet<>();

        // This will cause a compilation error since an interface cannot be 
        // instantiated directly
        // Collection<String> collection = new Set<String>();

        // Add elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Apple"); // Duplicate
        list.add("Cherry");

        // Add elements to the set
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Duplicate

        // Print both collections
        System.out.println("List: " + list);
        System.out.println("Set: " + set);
        
    }
}
