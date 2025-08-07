package brendanddev.collections.customobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Demonstrates the use of the CustomObject class in Java collections such as 
 * HashSet, List, and array. This example shows how proper implementation of 
 * equals(), hashCode(), and compareTo() allows for correct behavior when storing,
 * sorting, and comparing custom objects in collections.
 * 
 * NOTE:
 * The Collections Framework is a set of interfaces, classes, and algorithms that work
 * together to manage and manipulate groups of objects.
 * 
 * The Collection Interface is the root interface in the collection hierarchy.
 * It is the superinterface for collections like List, Set, and Queue. It does 
 * not include Map, as Map is a sibling in the framework, not a child of Collection.
 * 
 * The Collections class is a utility toolbox class that provides static methods for
 * manipulating collections, such as sorting, searching, shuffling, and more.
 */
public class Main {
    public static void main(String[] args) {

        // Create multiple instances of CustomObject
        CustomObject obj1 = new CustomObject("Object A", 10, 1);
        CustomObject obj2 = new CustomObject("Object B", 20, 2);
        CustomObject obj3 = new CustomObject("Object C", 5, 3);
        CustomObject duplicateObj1 = new CustomObject("Duplicate A", 99, 1); // Same ID as obj1
        

        // Storing CustomObject instances in a HashSet
        Set<CustomObject> customSet = new HashSet<>();
        customSet.add(obj1);
        customSet.add(obj2);
        customSet.add(obj3);
        customSet.add(duplicateObj1); // This will not be added since it has the same ID as obj1
        
        // Display the contents of the HashSet
        System.out.println("HashSet contents: ");
        for (CustomObject obj : customSet) {
            System.out.println(obj.getName() + " (ID: " + obj.getId() + ")");
        }

        
        // Storing CustomObject instances in an array
        CustomObject[] customArray = new CustomObject[3];
        customArray[0] = obj1;
        customArray[1] = obj2;
        customArray[2] = obj3;

        // Display the contents of the array
        System.out.println("\nArray contents: ");
        for (CustomObject obj : customArray) {
            System.out.println(obj.getName() + " (ID: " + obj.getId() + ")");
        }

        // Storing CustomObject instances in a List
        List<CustomObject> customList = new ArrayList<>();
        customList.add(obj1);
        customList.add(obj2);
        customList.add(obj3);
        customList.add(duplicateObj1); // This will be added since List allows duplicates

        // Uses 'compareTo' method to sort the list based on the 'value' field
        Collections.sort(customList);

        // Display the contents of the sorted List
        System.out.println("\nSorted List contents: ");
        for (CustomObject obj : customList) {
            System.out.println(obj.getName() + " (Value: " + obj.getValue() + ", ID: " + obj.getId() + ")");
        }
        









    }
    
}
