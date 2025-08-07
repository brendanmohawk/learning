package brendanddev.collections.equalsandhashcode;

import java.util.*;

/**
 * A demonstration of hash collisions in Java using a poor hash function and how it affects the performance
 * of hash based collections like HashMap and HashSet. The class also includes methods to compare the performance
 * of a good hash function versus a poor one, and to analyze how objects are distributed across hash buckets.
 */
public class Main {

    public static void main(String[] args) {

        // Demonstrate hash collisions
        demonstrateHashCollisions();

        // Compare performance of good vs poor hash functions
        comparePerformance();

        // Show HashMap behavior with collisions
        demonstrateHashMapBehavior();

        // Show HashSet behavior with collisions
        demonstrateHashSetBehavior();

        // Analyze hash bucket distribution
        analyzeHashDistribution();
    }

    /**
     * Show what the hash collisions look like by creating several HashCollision objects
     * and printing their hash codes
     */
    private static void demonstrateHashCollisions() {
        System.out.println("1. BASIC HASH COLLISION DEMO");
        System.out.println("=============================");
        
        // Create objects with different IDs
        HashCollision obj1 = new HashCollision("Alice", 1);
        HashCollision obj2 = new HashCollision("Bob", 2);
        HashCollision obj3 = new HashCollision("Charlie", 3);
        HashCollision obj4 = new HashCollision("Diana", 4);
        HashCollision obj5 = new HashCollision("Eve", 5);
        
        System.out.println("Objects and their hash codes:");
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
        System.out.println(obj4);
        System.out.println(obj5);
        
        System.out.println("\nNotice: Only 2 possible hash codes (0 or 1)!");
        System.out.println("Objects with IDs 1,3,5 all hash to: 1");
        System.out.println("Objects with IDs 2,4 all hash to: 0");
        System.out.println("This creates massive collisions!\n");
    }
    
    /**
     * Compares the performance of a poor hash function (id % 2) vs a good one (using Objects.hash())
     * by measuring the time taken to perform lookups in a HashSet.
     * 
     * The time complexity of lookups in a HashSet is O(1) on average, but with poor hash functions,
     * it can degrade to O(n) linear time in the worst case due to excessive collisions.
     */
    private static void comparePerformance() {
        System.out.println("2. PERFORMANCE COMPARISON");
        System.out.println("=========================");
        
        final int NUM_OBJECTS = 10000;
        final int NUM_LOOKUPS = 1000;
        
        // Test with poor hash function
        Set<HashCollision> poorHashSet = new HashSet<>();
        Random random = new Random(42); // Fixed seed for consistent results
        
        // Populate with objects
        for (int i = 0; i < NUM_OBJECTS; i++) {
            poorHashSet.add(new HashCollision("Person" + i, i));
        }
        
        // Test with good hash function
        Set<BetterHashCollision> goodHashSet = new HashSet<>();
        for (int i = 0; i < NUM_OBJECTS; i++) {
            goodHashSet.add(new BetterHashCollision("Person" + i, i));
        }
        
        // Performance test - lookups
        System.out.println("Testing lookup performance with " + NUM_OBJECTS + " objects...");
        
        // Poor hash function timing
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_LOOKUPS; i++) {
            int randomId = random.nextInt(NUM_OBJECTS);
            poorHashSet.contains(new HashCollision("Person" + randomId, randomId));
        }
        long poorHashTime = System.nanoTime() - startTime;
        
        // Reset random for fair comparison
        random = new Random(42);
        
        // Good hash function timing
        startTime = System.nanoTime();
        for (int i = 0; i < NUM_LOOKUPS; i++) {
            int randomId = random.nextInt(NUM_OBJECTS);
            goodHashSet.contains(new BetterHashCollision("Person" + randomId, randomId));
        }
        long goodHashTime = System.nanoTime() - startTime;
        
        System.out.println("Poor hash function time: " + poorHashTime / 1_000_000.0 + " ms");
        System.out.println("Good hash function time: " + goodHashTime / 1_000_000.0 + " ms");
        System.out.println("Performance difference: " + String.format("%.2fx", (double) poorHashTime / goodHashTime));
        System.out.println();
    }
    
    /**
     * Demonstrates how HashMap handles hash collisions by adding several HashCollision objects with
     * the same hash code and showing how it still allows correct retrieval of values using equals().
     */
    private static void demonstrateHashMapBehavior() {
        System.out.println("3. HASHMAP BEHAVIOR WITH COLLISIONS");
        System.out.println("===================================");
        
        Map<HashCollision, String> map = new HashMap<>();
        
        // Add objects that will collide
        HashCollision person1 = new HashCollision("Alice", 1);   // hash = 1
        HashCollision person2 = new HashCollision("Bob", 3);     // hash = 1 (collision!)
        HashCollision person3 = new HashCollision("Charlie", 5); // hash = 1 (collision!)
        HashCollision person4 = new HashCollision("Diana", 2);   // hash = 0
        HashCollision person5 = new HashCollision("Eve", 4);     // hash = 0 (collision!)
        
        map.put(person1, "Engineer");
        map.put(person2, "Designer");
        map.put(person3, "Manager");
        map.put(person4, "Developer");
        map.put(person5, "Analyst");
        
        System.out.println("HashMap contents:");
        map.forEach((key, value) -> 
            System.out.println(key + " -> " + value));
        
        System.out.println("\nLookup test:");
        System.out.println("Looking up Alice (id=1): " + map.get(person1));
        System.out.println("Looking up Bob (id=3): " + map.get(person2));
        
        System.out.println("\nEven with collisions, HashMap works correctly!");
        System.out.println("It uses equals() to distinguish between objects with same hash code.");
        System.out.println("But performance suffers due to linear search within buckets.\n");
    }
    

    /**
     * Demonstrates how HashSet handles hash collisions by adding several HashCollision objects with
     * the same hash code and showing how it still allows correct retrieval of values using equals().
     */
    private static void demonstrateHashSetBehavior() {
        System.out.println("4. HASHSET BEHAVIOR WITH COLLISIONS");
        System.out.println("===================================");
        
        Set<HashCollision> set = new HashSet<>();
        
        // Demonstrate collision handling
        HashCollision alice1 = new HashCollision("Alice", 1);
        HashCollision alice2 = new HashCollision("Alice", 1); // Same object logically
        HashCollision bob = new HashCollision("Bob", 3);       // Different object, same hash
        
        set.add(alice1);
        set.add(alice2); // Won't be added (equals returns true)
        set.add(bob);    // Will be added (equals returns false despite same hash)
        
        System.out.println("HashSet contents:");
        set.forEach(System.out::println);
        System.out.println("Set size: " + set.size());
        
        System.out.println("\nDemonstrating collision buckets:");
        analyzeHashDistribution();
        
        System.out.println("\n=== KEY TAKEAWAYS ===");
        System.out.println("Poor hash functions create many collisions");
        System.out.println("Collisions hurt performance but don't break correctness");
        System.out.println("equals() is used to resolve collisions");
        System.out.println("Good hash functions distribute objects evenly");
        System.out.println("Use Objects.hash() for combining multiple fields");
    }

     /**
      * Analyzes how objects are distributed across hash buckets in a HashMap.
      */
    private static void analyzeHashDistribution() {
        Map<Integer, List<HashCollision>> buckets = new HashMap<>();
        
        // Create several objects
        for (int i = 1; i <= 10; i++) {
            HashCollision obj = new HashCollision("Person" + i, i);
            
            // Grab hash code using poor hash function
            int hash = obj.hashCode();
            
            // Tries to add object to existing bucket or creates a new one if dosent exist
            // This will show how many objects collide in each bucket
            buckets.computeIfAbsent(hash, k -> new ArrayList<>()).add(obj);
        }
        
        // Print out the distribution of objects across buckets
        System.out.println("Hash bucket distribution:");
        buckets.forEach((hash, objects) -> {
            System.out.println("Bucket " + hash + " (" + objects.size() + " objects): " + 
                             objects.stream()
                                   .map(o -> "id=" + o.getId())
                                   .reduce((a, b) -> a + ", " + b)
                                   .orElse("empty"));
        });
    }
}