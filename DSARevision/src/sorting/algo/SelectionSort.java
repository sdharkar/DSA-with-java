package sorting.algo;

//problem: Implement selection sort algorithm.

//logic: 
//1. Iterate through the array.
//2. Find the minimum element in the unsorted part of the array.
//3. Swap the minimum element with the first element of the unsorted part of the array.
//4. Repeat the process until the array is sorted.

//Time Complexity: O(n^2), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.

public class SelectionSort {

    public static void main(String[] args) {

        System.out.println("Selection Sort Algorithm");

        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        selectionSort(array); // Call the sorting method

        System.out.println("\n\nSorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        //Iterate through the array
        for(int i = 0; i < n -1; i++){
            int minIndex = i;

            //Find the minimum element in the unsorted part of the array
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[minIndex]){//If the current element is smaller than the minimum element
                    minIndex = j;
                }
            }

            //Swap the minimum element with the first element of the unsorted part of the array
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

}
