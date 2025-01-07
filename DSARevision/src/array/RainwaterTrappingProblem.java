package array;

//Problem: Rainwater Trapping Problem
//Logic: Use two pointers to find the maximum height of the water.
//Algorithm:
//1. Initialize two pointers, left and right, to the leftmost and rightmost elements of the array, respectively.
//2. Initialize a variable totalWater to 0.
//3. Iterate through the array:
//4. Calculate the minimum height between the left and right pointers.
//5. If the minimum height is greater than the current height, add the difference to totalWater.
//6. If the current height is greater than the left pointer, move the left pointer to the right.
//7. If the current height is greater than the right pointer, move the right pointer to the left.
//8. Return totalWater.
//Time Complexity: O(n), where n is the number of elements in the array.
//Space Complexity: O(1), since the function does not use any additional data structures.

public class RainwaterTrappingProblem {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("The Amount of water that can be trapped is: " + rainwaterTrapping(arr) + " units");

    }

    //Function to calculate the amount of water that can be trapped
    public static int rainwaterTrapping(int[] arr) {

        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = arr[0];//Initialize the left and right pointers to the first and last elements of the array
        right[n - 1] = arr[n - 1];//Initialize the left and right pointers to the first and last elements of the array

        //Calculate the maximum height of the water between the left and right pointers
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);//If the current height is greater than the left pointer, move the left pointer to the right
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);//If the current height is greater than the right pointer, move the right pointer to the left
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Math.min(left[i], right[i]) - arr[i];//Add the difference between the minimum height and the current height
        }
        return answer;
    }
}
