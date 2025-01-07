package search.algo;

//problem: Implement binary search algorithm for infinite array.

//logic: 
//1. Find the middle element of the array.
//2. If the middle element is equal to the target value, return its index.
//3. If the middle element is greater than the target value, search in the left half of the array.
//4. If the middle element is less than the target value, search in the right half of the array.
//5. Repeat the process until the target value is found or the entire array has been searched.
//Time Complexity: O(log n), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.

public class InfiniteArraySearch {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 3;
        int result = infiniteArraySearch(arr, target);
        if(result == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element " + target + " found at index: " + result);
        }

    }

    public static int infiniteArraySearch(int[] arr, int target) {

        int low = 0;
        int high = 1;

        while(arr[high] < target){
            low = high;
            high = 2 * high;

            if(high > arr.length){
                high = arr.length - 1;
            }
        }
        return binarySearch(arr,low,high,target);
       
    }

    public static int binarySearch(int[] arr,int low, int high, int target) {

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == target){
                return mid;
            }   else if(arr[mid] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return -1;

    }

}
