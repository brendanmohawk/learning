package brendanddev.collections.set;



public class Main {

    public static void main(String[] args) {

        // Create the CustomSet instance
        CustomSet<String> customSet = new CustomSet<>();

        // Add elements to the set
        System.out.println("\n====== Adding Elements ======");
        customSet.add("Apple");
        customSet.add("Banana");
        customSet.add("Blueberry");
        customSet.add("Cherry");
        customSet.add("Cantaloupe");
        customSet.add("Apple"); // Duplicate, should not be added

        // Test contains() method
        System.out.println("\n====== Set Contains Elements ======");
        System.out.println("Contains Apple? " + customSet.contains("Apple"));
        System.out.println("Contains Banana? " + customSet.contains("Banana"));
        System.out.println("Contains Grape? " + customSet.contains("Grape"));

        // Remove an element from the set
        System.out.println("\n====== Removing Elements ======");
        customSet.remove("Banana");
        System.out.println("Contains Banana after removal? " + customSet.contains("Banana"));

        // Print each element in the set
        // Since the CustomSet implementation does not implement the Iterable<T> interface,
        // it cannot use the enhanced for loop directly, since the enhanced for loop calls
        // the iterator() method under the hood.
        // Instead, we can use the toArray() method to get a copy of the elements in the set
        // as an array, and then iterate over that array. This iterates over a copy of the sets
        // contents
        System.out.println("\n====== Current Set Elements ======");
        for (Object element : customSet.toArray()) {
            System.out.println(element);
        }

        // Print the size of the set
        System.out.println("\n====== Set Size ======");
        System.out.println("Size of the set: " + customSet.size());



        

    }
    
}
