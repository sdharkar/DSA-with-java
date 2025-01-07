package search.algo;

//problem: Implement binary search algorithm.
//1. Sort the array in ascending order.
//2. Find the middle element of the array.
//3. If the middle element is equal to the target value, return its index.
//4. If the middle element is greater than the target value, search in the left half of the array.
//5. If the middle element is less than the target value, search in the right half of the array.
//6. Repeat the process until the target value is found or the entire array has been searched.
//Time Complexity: O(log n), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        int result = binarySearch(arr, target);
        if(result == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element " + target + " found at index: " + result);
        }

    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] == target){
                return mid;
            }

            if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

}
