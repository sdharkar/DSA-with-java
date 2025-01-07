package array;

//problem: Find the majority element in an array using Moore's Voting Algorithm.

//logic: 
//1. Initialize a count variable to 0.
//2. Initialize a candidate variable to 0.
//3. Iterate through the array and increment the count if the current element is equal to the candidate, otherwise decrement the count.
//4. If the count becomes 0, set the candidate to the current element.
//5. Count the number of times the candidate occurs in the array.
//6. If the count is greater than n/2, return the candidate, otherwise return -1.

//Time complexity = O(n), where n is the number of elements in the array.
//Space complexity = O(1), since the function does not use any additional data structures.

public class MajorityElementMoore {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority element is: "+majorityElement(nums));

    }

    public static int majorityElement(int[] nums){
        int count = 0;
        int candidate = 0;

        //Moore's Voting Algorithm
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        //Count the number of times the candidate occurs
        count = 0;
        for(int num : nums){
            if(num == candidate){
                count++;
            }
        }

        //Check if the candidate occurs more than n/2 times
        if(count > nums.length/2){
            return candidate;
        }
        return -1;
    }

}
