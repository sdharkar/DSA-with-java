package search.algo;

//problem: Implement binary search algorithm for a sorted and rotated array.
//logic: 
//1. Find the middle element of the array.
//2. If the middle element is equal to the target value, return its index.
//3. If the middle element is greater than the target value, search in the left half of the array.
//4. If the middle element is less than the target value, search in the right half of the array.
//5. Repeat the process until the target value is found or the entire array has been searched.

//Time Complexity: O(log n), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.

public class SearchInSortedAndRotatedArray {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = searchInSortedAndRotatedArray(arr, target);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element " + target + " found at index: " + result);
        }

    }

    public static int searchInSortedAndRotatedArray(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }



}
