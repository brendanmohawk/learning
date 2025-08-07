package brendanddev.collections.equalsandhashcode;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Demonstrate hash collisions
        demonstrateHashCollisions();

        // Compare performance of good vs poor hash functions
        comparePerformance();
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
    

}