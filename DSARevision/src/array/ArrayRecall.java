package array;

//Array is a collection of elements of the same type.
//Array is a fixed size, meaning that once an array is created, its size cannot be changed.
//Array is a reference type, meaning that it is a pointer to an object.

import java.util.Arrays;
import java.util.Random;

public class ArrayRecall {

    public static void main(String[] args) {

        // --- 1. Array Declaration & Initialization ---
        System.out.println("--- 1. Array Declaration & Initialization ---");
        //Primitive Array
        int[] numbers = new int[5]; // Array of 5 integers, initialized to 0
        String[] names = {"Alice", "Bob", "Charlie"}; // String array with initial values

        //Initialize all values at once using array literal syntax
        int[] numbers2 = {10,20,30,40,50}; 
        System.out.println("Numbers Array: " + Arrays.toString(numbers)); // Print array using Arrays.toString()
        System.out.println("Names Array: " + Arrays.toString(names));
        System.out.println("Numbers2 Array : " + Arrays.toString(numbers2));

        // --- 2. Accessing Elements ---
        System.out.println("\n--- 2. Accessing Elements ---");
        numbers[0] = 10; // Assign a value at index 0
        System.out.println("Element at numbers[0]: " + numbers[0]);
        System.out.println("Element at names[1]: " + names[1]);
        try{
            System.out.println("Element at numbers[10] " + numbers[10]); // This will throw an exception since index 10 is out of bounds
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Error: Array index out of bounds!");
        }


        // --- 3. Array Length ---
        System.out.println("\n--- 3. Array Length ---");
        System.out.println("Length of numbers array: " + numbers.length); // length is a property, not a method
        System.out.println("Length of names array: " + names.length);

        // --- 4. Iterating Through an Array (for loop) ---
        System.out.println("\n--- 4. Iterating Through an Array (for loop) ---");
        System.out.print("Numbers array elements : ");
        // Traditional for loop with index
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        // --- 5. Iterating Through an Array (Enhanced for loop) ---
        System.out.println("\n--- 5. Iterating Through an Array (Enhanced for loop) ---");
        System.out.print("Names array elements : ");
        // Enhanced for loop (for-each) - simpler syntax but no access to index
        for (String name : names) {
             System.out.print(name + " ");
        }
        System.out.println();

        // --- 6. Array Modification ---
        System.out.println("\n--- 6. Array Modification ---");
        numbers[2] = 25; // Modify element at index 2
        System.out.println("Modified numbers array: " + Arrays.toString(numbers));
        names[1] = "David"; // Replace "Bob" with "David"
        System.out.println("Modified names array: " + Arrays.toString(names));


        // --- 7. Copying Arrays ---
        System.out.println("\n--- 7. Copying Arrays ---");
        // Create a new array with same length and copy all elements
        int[] copiedNumbers = Arrays.copyOf(numbers, numbers.length); 
        System.out.println("Copied numbers array: " + Arrays.toString(copiedNumbers));

        //Creating a copy with specific length (truncates or pads with zeros if necessary)
        int[] copiedNumbers2 = Arrays.copyOf(numbers,3);
        System.out.println("Copied numbers array of length 3 : " + Arrays.toString(copiedNumbers2));
        
        // --- 8. Array Filling ---
        System.out.println("\n--- 8. Array Filling ---");
        Arrays.fill(numbers, 7); // Fill entire array with the value 7
        System.out.println("Filled numbers array: " + Arrays.toString(numbers));

        // --- 9. Array Sorting ---
        System.out.println("\n--- 9. Array Sorting ---");
        Random random = new Random();
        // Fill array with random numbers between 0 and 99
        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i] = random.nextInt(100);
        }
        System.out.println("Random numbers array before sorting : " + Arrays.toString(numbers));
        Arrays.sort(numbers); // Sort in ascending order
        System.out.println("Sorted numbers array: " + Arrays.toString(numbers));


        String[] names2 = {"zebra","apple","monkey"};
        System.out.println("Names2 Array before sort: " + Arrays.toString(names2));
        Arrays.sort(names2); // Sort strings alphabetically
        System.out.println("Names2 Array after sort : " + Arrays.toString(names2));


        // --- 10. Array Searching ---
        System.out.println("\n--- 10. Array Searching ---");
        // Binary search requires array to be sorted first
        int index = Arrays.binarySearch(numbers, 25); 
        if (index >= 0)
        {
            System.out.println("25 is present at " + index);
        }
        else
        {
            System.out.println("25 is not present!");
        }


        // --- 11. Array Equality Checking ---
        System.out.println("\n--- 11. Array Equality Checking ---");
        // Create exact copy for equality testing
        int [] numbers3 = Arrays.copyOf(numbers, numbers.length);
        if(Arrays.equals(numbers, numbers3))
        {
            System.out.println("Numbers array is equal to numbers3 array!");
        }
        else
        {
            System.out.println("Numbers array is not equal to numbers3 array!");
        }
        
        // Testing equality of arrays with same values
        int[] numbers4 = {1,2,3,4,5};
        int[] numbers5 = {1,2,3,4,5};

        if (Arrays.equals(numbers4, numbers5))
        {
            System.out.println("numbers4 array is equal to numbers5 array!");
        }
        else {
            System.out.println("numbers4 array is not equal to numbers5 array!");
        }
         
        // Testing equality of arrays with same values in different order
        int[] numbers6 = {1,2,3,4,5};
        int[] numbers7 = {5,4,3,2,1};
         
        if (Arrays.equals(numbers6, numbers7))
        {
              System.out.println("numbers6 array is equal to numbers7 array!");
        }
        else
        {
             System.out.println("numbers6 array is not equal to numbers7 array!");
        }
    }
}