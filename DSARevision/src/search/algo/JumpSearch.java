package search.algo;

//problem: Implement jump search algorithm.
//logic: 
//1. Find the block size that is a multiple of the jump size.
//2. Start from the beginning of the array.
//3. If the element at the current index is equal to the target value, return its index.
//4. If the element at the current index is greater than the target value, search in the previous block.
//5. Repeat the process until the target value is found or the entire array has been searched.
//Time Complexity: O(sqrt(n)), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.
public class JumpSearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 3;
        int result = jumpSearch(arr, target);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element " + target + " found at index: " + result);
        }

    }

    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);//jump size
        int prev = 0;//previous index

        // Finding the block size that is a multiple of the jump size.
        while (arr[Math.min(step, n) - 1] < target) {//if the element at the current index is less than the target value, move to the next block.
            prev = step;
            step += (int) Math.sqrt(n); //increase the block size by the jump size.
            if (prev >= n) {
                return -1;
            }
        }
        // Searching for the target value in the block.
        while (arr[prev] < target) {//if the element at the current index is less than the target value, move to the next block.
            prev++;
            if (prev == Math.min(step, n)) {//if the current index is equal to the block size, return -1.
                return -1;
            }
        }
        // If the target value is found, return its index.
        if (arr[prev] == target) {
            return prev;
        }
        return -1;
    }

}
