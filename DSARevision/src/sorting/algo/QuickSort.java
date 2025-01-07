package sorting.algo;

//Problem: Implement quick sort algorithm.

//Logic: 
//1. Select a pivot element from the array.
//2. Partition the array around the pivot element.
//3. Recursively sort the left and right subarrays.

//Time Complexity: O(nlogn), where n is the number of elements in the array.
//Space Complexity: O(n), since the function uses an auxiliary array of size n.

public class QuickSort {

    public static void main(String[] args) {

        System.out.println("Quick Sort Algorithm");

        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        quickSort(array, 0, array.length - 1); // Call the sorting method

        System.out.println("\n\nSorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Partition the array
            quickSort(arr, low, pi - 1); // Sort the left subarray
            quickSort(arr, pi + 1, high); // Sort the right subarray
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Select the pivot element
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(arr[j] < pivot){// If the current element is less than the pivot element
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap the pivot element with the element at index i+1
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;// Return the partitioning index
    }



}
