package sorting.algo;

//problem: Implement bubble sort algorithm.

//logic: 
//1. Iterate through the array and compare adjacent elements.
//2. If the first element is greater than the second element, swap them.
//3. Repeat the process until the array is sorted.

//Algorithm:
//1. Initialize a boolean variable swapped to false.
//2. Iterate through the array from the first element to the second last element.
//3. If the current element is greater than the next element, swap them and set swapped to true.
//4. If swapped is false, break the loop.
//5. Return the sorted array.

//Time Complexity: O(n^2), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.

public class BubbleSort {

    public static void main(String[] args) {

        System.out.println("Bubble Sort Algorithm");

    	 int[] array = {64, 34, 25, 12, 22, 11, 90};
         System.out.println("Original Array:");
         for (int num : array) {
             System.out.print(num + " ");
         }

         bubbleSort(array); // Call the sorting method

         System.out.println("\n\nSorted Array:");
         for (int num : array) {
             System.out.print(num + " ");
         }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length; // Length of the array
        boolean swapped; // Flag to check if any swapping happened

        // Loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Reset the swapped flag at the beginning of each pass

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) { 
                if (arr[j] > arr[j + 1]) { // Compare elements
                    // Swap if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Set the flag as swapping occurred
                }
            }

            // If no two elements were swapped in the last pass, array is sorted
            if (!swapped) {
                break;
            }
        }
    }


}
