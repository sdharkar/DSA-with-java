package backtracking;
import java.util.*;

//problem: Find all subsets of a given array that add up to a given target.
//logic: Use backtracking to find all subsets of the given array that add up to the given target.
//Algorithm:
//1. Define a function backtrack(start, nums, target, temp, result) that takes the current index, the array, the target, the temporary list of elements, and the result list.
//2. If the target is 0, add the current subset to the result list and return.
//3. For each element in the array, check if it is greater than the target. If it is, skip it.
//4. Add the element to the temporary list and call backtrack with the next index.
//5. Remove the element from the temporary list.
//6. Return the result list.

public class SubsetSum {
    static void findSubsets(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>(), result);
        System.out.println(result);
    }

    static void backtrack(int start, int[] nums, int target, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) continue;

            temp.add(nums[i]);
            backtrack(i + 1, nums, target - nums[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        findSubsets(nums, target);
    }
}
