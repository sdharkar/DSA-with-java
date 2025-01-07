package sorting.algo;

//problem: Implement insertion sort algorithm.

//logic and algorithm: 
//1. Iterate through the array from the second element to the last element.
//2. Compare the current element with the previous element.
//3. If the current element is smaller than the previous element, swap them.
//4. Repeat the process until the array is sorted.

//Time Complexity: O(n^2), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.


public class InsertionSort {

    public static void main(String[] args) {

        System.out.println("Insertion Sort Algorithm");

        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        insertionSort(array); // Call the sorting method

        System.out.println("\n\nSorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        //Iterate through the array from the second element to the last element
        for(int i = 1; i < n; i++){
            int current = arr[i];
            int j = i -1;

            //Compare the current element with the previous element
            while(j >= 0 && arr[j] > current){//If the current element is smaller than the previous element, swap them
                arr[j+1] = arr[j];//Shift the elements to the right
                j--;
            }
            arr[j+1] = current;
        }
    }
        

}
