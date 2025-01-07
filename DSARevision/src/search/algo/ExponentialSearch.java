package search.algo;

//problem: Implement exponential search algorithm.
//logic: 
//1. Start from the first element of the array.
//2. If the current element is equal to the target value, return its index.
//3. If the current element is greater than the target value, search in the left half of the array.
//4. If the current element is less than the target value, search in the right half of the array.
//5. Repeat the process until the target value is found or the entire array has been searched.
//Time Complexity: O(log n), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.

public class ExponentialSearch {

    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 3;
        int result = exponentialSearch(arr, target);
        if(result == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element " + target + " found at index: " + result);
        }
    }

    public static int exponentialSearch(int[] arr, int target){
        int n = arr.length;

        if(arr[0] == target){
            return 0;
        }

        int i = 1;
        while(i < n && arr[i] <= target){
            i = i * 2;
        }

        return binarySearch(arr, target, i / 2, Math.min(i, n) - 1);
    }

    public static int binarySearch(int[] arr, int target, int left, int right){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

}
