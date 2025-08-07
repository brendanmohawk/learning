package brendanddev.collections.equalsandhashcode;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Demonstrate hash collisions
        demonstrateHashCollisions();
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
}