package collection.framework;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections and Arrays Utility Classes Theory and Implementation Details
 *
 * 1. Collections Utility Class
 *  - Provides static methods for operating on or returning collections.
 *  - Includes methods for sorting, searching, shuffling, and manipulating collections.
 *  - Can be used to create synchronized (thread-safe) versions of collections.
 *
 * 2. Arrays Utility Class
 *  - Provides static methods for operating on arrays.
 *  - Includes methods for sorting, searching, filling, and manipulating arrays.
 *  - Can be used to convert arrays to lists and vice versa.
 */


public class UtilityExamples {

    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5);
        
        // Collections utility class
        List<Integer> list2 = Arrays.asList(3, 1, 4, 1, 5);
        Collections.sort(list2);                // Sort
        System.out.println("Sorted list: " + list2);
        Collections.reverse(list2);             // Reverse
        System.out.println("Reversed list: " + list2);
        Collections.shuffle(list2);             // Randomize
        System.out.println("Shuffled list: " + list2);
        int max = Collections.max(list2);       // Find maximum
        System.out.println("Max value: " + max);
        int frequency = Collections.frequency(list2, 1); // Count occurrences
        System.out.println("Frequency of 1: " + frequency);
        List<Integer> singletonList = Collections.singletonList(10);
        System.out.println("Singleton list: " + singletonList);

        // Arrays utility class
        int[] array = {3, 1, 4, 1, 5};
        Arrays.sort(array);                    // Sort array
        System.out.println("Sorted array: " + Arrays.toString(array));
        int position = Arrays.binarySearch(array, 4); // Binary search
        System.out.println("Position of 4: " + position);
        List<Integer> arrayList = Arrays.asList(1, 2, 3); // Convert to List
        System.out.println("Array as list: " + arrayList);
        int[] newArray = Arrays.copyOf(array, array.length);
        System.out.println("Copied array: " + Arrays.toString(newArray));
        Arrays.fill(newArray, 0);
        System.out.println("Filled array: " + Arrays.toString(newArray));

    }

}
