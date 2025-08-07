package brendanddev.collections.list;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        CustomList<String> list = new CustomList<>();

        // Add elements
        for (int i = 1; i <= 15; i++) {
            list.add("Item " + i);
        }

        System.out.println("List after adding 15 elements:");
        printList(list);

        System.out.println("Size: " + list.size());

        // Estimate underlying array memory usage (approximate)
        estimateMemory(list);

        // Remove an element (index 5 means 6th element)
        String removed = list.remove(5);
        System.out.println("\nRemoved element at index 5 (6th element): " + removed);

        System.out.println("\nList after removal:");
        System.out.println(list);

        System.out.println("Size: " + list.size());

        // Iterate using iterator explicitly
        System.out.println("\nIterating with iterator:");
        for (String s : list) {
            System.out.println(s);
        }

    }

    /**
     * Prints the elements of the CustomList with their indices
     * 
     * @param list The CustomList to print
     */
    private static void printList(CustomList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }
    }

    /**
     * Estimates the memory used by the underlying array that backs the CustomList.
     * Provides a comprehensive breakdown of memory usage including array overhead, used vs unused slots,
     * and efficiency metrics.
     * 
     * The Array object overhead is approximately 24 bytes (object header + length field + padding).
     * The reference slots each hold references to objects, typically 4 bytes on a 32-bit JVM or 8 bytes on a 64-bit JVM.
     * This estimate dosent include the memory used by the actual String objects being referenced.
     * 
     * @param list The CustomList to analyze
     */
    private static void estimateMemory(CustomList<?> list) {

        // 8 bytes per reference on 64-bit JVM without compressed OOPs
        int referenceSize = 8;
        int arrayLength = getUnderlyingArrayLength(list);
        int actualSize = list.size();

        // Calculate memory components
        long arrayOverhead = 24; // Object header + array length field + alignment padding
        long usedSlots = (long) actualSize * referenceSize;
        long unusedSlots = (long) (arrayLength - actualSize) * referenceSize;
        long totalArrayMemory = arrayOverhead + (arrayLength * referenceSize);
        
        // Calculate efficiency
        double efficiency = arrayLength > 0 ? (double) actualSize / arrayLength * 100 : 0;
        
        // Display results
        System.out.println("=== Memory Analysis ===");
        System.out.println("Array capacity: " + arrayLength + " slots");
        System.out.println("Elements stored: " + actualSize + " slots");
        System.out.println("Utilization: " + String.format("%.1f%%", efficiency));
        System.out.println();
        System.out.println("Memory breakdown:");
        System.out.println("  Array overhead: " + arrayOverhead + " bytes");
        System.out.println("  Used references: " + actualSize + " x " + referenceSize + " = " + usedSlots + " bytes");
        System.out.println("  Unused references: " + (arrayLength - actualSize) + " x " + referenceSize + " = " + unusedSlots + " bytes");
        System.out.println("  Total array memory: " + totalArrayMemory + " bytes");
        System.out.println();
        System.out.println("Note: This excludes memory used by the actual String objects (estimated ~40-50 bytes each)");
        
        // Efficiency warning
        if (efficiency < 50 && arrayLength > 10) {
            System.out.println("Low memory efficiency - consider trimming unused capacity");
        }
    }

    /**
     * Uses reflection to access the private 'elements' array field inside CustomList.
     * This allows inspection of the physical capacity (array length) versus logical size.
     * 
     * Reflection is a powerful feature in Java that allows code to inspect and manipulate
     * classes, methods, fields, and other elements at runtime, even if they are private or
     * normally inaccessible.
     * 
     * Normally private fields cannot be accessed directly outside their class, but reflection
     * bypasses that for advanced purposes like diagnostics or debugging. It should be used carefully
     * as it breaks encapsulation and can lead to maintenance issues.
     *
     * @param list The CustomList instance to inspect
     * @return The length of the internal 'elements' array, or -1 if an error occurs     
     */
    private static int getUnderlyingArrayLength(CustomList<?> list) {
        try {
            // Accesses the private 'elements' field by name using reflection
            Field field = CustomList.class.getDeclaredField("elements");

            // Bypasses the private access modifier to allow access
            field.setAccessible(true);

            // Retrieves the underlying array from the CustomList object
            Object[] elements = (Object[]) field.get(list);
            return elements.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
}
