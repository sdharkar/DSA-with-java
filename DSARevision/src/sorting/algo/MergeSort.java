package sorting.algo;

//problem: Implement merge sort algorithm.

//logic: 
//1. Divide the array into two subarrays, left and right.
//2. Sort the left and right subarrays recursively.
//3. Merge the sorted subarrays into a single sorted array.

//Time Complexity: O(nlogn), where n is the number of elements in the array.
//Space Complexity: O(n), since the function uses an auxiliary array of size n.

public class MergeSort {

    public static void main(String[] args) {

        System.out.println("Merge Sort Algorithm");

        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        mergeSort(array, 0, array.length - 1); // Call the sorting method

        System.out.println("\n\nSorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int middle = (left + right) / 2; //Find the middle element of the array
            mergeSort(arr, left, middle);//Sort the left half of the array
            mergeSort(arr, middle + 1, right);//Sort the right half of the array
            merge(arr, left, middle, right);//Merge the sorted halves
        }
    }

    public static void merge(int[] arr, int left, int middle, int right){
        int n1 = middle - left + 1; //Size of the left subarray
        int n2 = right - middle; //Size of the right subarray

        //temp arrays
        int[] leftArray = new int[n1]; 
        int[] rightArray = new int[n2]; 

        //Copy data to temp arrays
        for(int i = 0; i < n1; i++){
            leftArray[i] = arr[left + 1];
        }

        for(int j = 0; j < n2; j++){
            rightArray[j] = arr[middle + 1 + j];
        }

        //Merge the temp arrays
        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            } else{
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //Copy the remaining elements of leftArray
        while(i < n1){
            arr[k] = leftArray[i];
            i++;
            k++;
        }
    }

}
