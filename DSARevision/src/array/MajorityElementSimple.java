package array;

//Problem: Find the majority element in an array.

//Logic & Algorithm: 
//1. Iterate through the array and count the frequency of each element.
//2. If the frequency is greater than n/2, return the element.

//Time Complexity: O(n^2)
//Space Complexity: O(1)

public class MajorityElementSimple {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority element is: "+majorityElement(nums));
    }

    public static int majorityElement(int[] nums){
        int element = 0;
        for(int i = 0; i < nums.length; i++){
           int count = 0;
           for(int j = 0; j < nums.length; j++){
               if(nums[i] == nums[j]){
                   count++;
               }
           }
           if(count > nums.length/2){
               element = nums[i];
           }
        }
        return element;
    }

}
