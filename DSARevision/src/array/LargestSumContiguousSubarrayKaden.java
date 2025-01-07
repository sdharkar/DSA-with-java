package array;

//Problem: Find the largest sum contiguous subarray using Kadane's algorithm.
//Logic: Use Kadane's algorithm to find the largest sum contiguous subarray.
//Algorithm:
//1. Initialize a variable maxSum to Integer.MIN_VALUE.
//2. Initialize a variable currentSum to 0.
//3. Iterate through the array and add each element to the currentSum.
//4. If the currentSum is greater than the maxSum, update the maxSum.
//5. If the currentSum is less than 0, set the currentSum to 0.
//6. Return the maxSum.

//Time Complexity: O(n)
//Space Complexity: O(1)

public class LargestSumContiguousSubarrayKaden {

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum is: "+findMaxSubarraySum(nums));

    }

    public static int findMaxSubarraySum(int[] nums ){
        int maxSum = Integer.MIN_VALUE; //initialize the maxSum to Integer.MIN_VALUE
        int currentSum = 0;

        for(int num : nums){//iterate through the array
            currentSum += num; //add each element to the currentSum 
            if(currentSum > maxSum){ //if the currentSum is greater than the maxSum
                maxSum = currentSum; //update the maxSum
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }

}
