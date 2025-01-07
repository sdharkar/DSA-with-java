package search.algo;

//problem: Implement linear search algorithm.
//logic: 
//1. Iterate through the array from left to right.
//2. Compare each element with the target value.
//3. If the element is equal to the target, return its index.
//4. Repeat the process until the target value is found or the entire array has been searched.
//Time Complexity: O(n), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.
public class LinearSearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        linearSearch(arr, target);

    }

    public static void linearSearch(int[] arr, int target) {
        for (int i = 0; i <= arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Element " + target + " found at index: " + i);
                return;
            }
        }
    }

}
