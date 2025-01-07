package sorting.algo;

//Problem: Implement heap sort algorithm.

//Logic: 
//1. Build a max heap from the array.
//2. Extract elements from the heap one by one and place them at the end of the array.
//3. Heapify the remaining elements to maintain the heap property.
//4. Repeat the process until the array is sorted.

//Time Complexity: O(nlogn), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.

public class HeapSort {

    public static void main(String[] args) {

        System.out.println("Heap Sort Algorithm");

        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        heapSort(array); // Call the sorting method

        System.out.println("\n\nSorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

    }

    //Heap Sort
    public static void heapSort(int[] arr){
        int n = arr.length;

        for(int i = n -1; i >= 0; i--){//Build heap
            heapify(arr, n, i);
        }

        for(int i = n -1; i > 0; i--){//Extract elements from heap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    //Heapify
    private static void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2 * i + 1;//Left child
        int right = 2 * i + 2; //Right child

        if(left < n && arr[left] > arr[largest]){//If left child is larger than root
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]){//If right child is larger than root
            largest = right;
        }

        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

}
