package search.algo;

//problem: Implement interpolation search algorithm.
//logic: 
//1. Sort the array in ascending order.
//2. Find the middle element of the array.
//3. If the middle element is equal to the target value, return its index.
//4. If the middle element is greater than the target value, search in the left half of the array.
//5. If the middle element is less than the target value, search in the right half of the array.
//6. Repeat the process until the target value is found or the entire array has been searched.
//Time Complexity: O(log n), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.

public class InterpolationSearch {

    public static void main(String[] args) {

        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 70;

        System.out.println("Array: " + java.util.Arrays.toString(sortedArray));
        System.out.println("Target: " + target);

        int index = interpolationSearch(sortedArray, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }

    }

    public static int interpolationSearch(int[] arr, int target){
        int low = 0;
        int high = arr.length -1;
        //The formula to calculate the position of the middle element is:
        while(low <= high && target >= arr[low] && target <= arr[high]){
            if(arr[low] == arr[high]){//To avoid division by zero
                if(arr[low] == target){//If the target element is found at the first index
                    return low;
                }else{
                    return -1;
                }
            }
            //The formula to calculate the position of the middle element is:
            int pos = low + ((target - arr[low]) * (high - low) / (arr[high] - arr[low]));
            //If the middle element is equal to the target value, return its index.
            if(arr[pos] == target){
                return pos;
            }
            //If the middle element is greater than the target value, search in the left half of the array.
            if(arr[pos] < target){
                low = pos + 1;
            }else{
                high = pos - 1;
            }
        }
        return -1;
    }

}




// Algorithm:

// Precondition: The search space must be sorted and elements should be uniformly distributed.

// Set low to the first index and high to the last index.

// While low is less than or equal to high

// If arr[low] == arr[high], then it implies all elements are the same. If arr[low] == target return low, otherwise return -1.

// Calculate the position using interpolation: pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low])

// If arr[pos] == target, return pos.

// If arr[pos] < target, move to right by setting low to pos + 1.

// If arr[pos] > target, move to left by setting high to pos - 1.

// If the target not found, return -1.

// Logic Explained:

// Interpolation search uses interpolation to determine the position of the target element in the array. It works best when the array elements are uniformly distributed.
