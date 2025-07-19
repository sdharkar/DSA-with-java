package array;

import java.util.*;

/**
 * Two Sum Problem - Most Common Array Interview Question
 * 
 * Problem: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * 
 * Asked by: Google, Amazon, Microsoft, Apple, Facebook
 * Frequency: Very High
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println("=== Two Sum Problem ===\n");
        
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        
        // Test all approaches
        System.out.println("\n1. Hash Map Approach (Optimal):");
        int[] result1 = twoSumHashMap(nums, target);
        System.out.println("Result: " + Arrays.toString(result1));
        
        System.out.println("\n2. Brute Force Approach:");
        int[] result2 = twoSumBruteForce(nums, target);
        System.out.println("Result: " + Arrays.toString(result2));
        
        System.out.println("\n3. Two Pointers (Sorted Array):");
        int[] sortedNums = {2, 7, 11, 15};
        int[] result3 = twoSumTwoPointers(sortedNums, target);
        System.out.println("Result: " + Arrays.toString(result3));
        
        // Test edge cases
        testEdgeCases();
    }

    /**
     * Approach 1: Hash Map (Optimal)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * This is the most efficient approach for unsorted arrays.
     * We use a hash map to store complements as we iterate.
     */
    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If complement exists in map, we found our pair
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // Store current number and its index
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1}; // No solution found
    }

    /**
     * Approach 2: Brute Force
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * 
     * Simple but inefficient. Used to show understanding
     * before optimizing.
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Approach 3: Two Pointers (For Sorted Arrays)
     * Time Complexity: O(n log n) if sorting needed, O(n) if already sorted
     * Space Complexity: O(1)
     * 
     * Efficient for sorted arrays. If array is not sorted,
     * we need to create a copy with indices to preserve original indices.
     */
    public static int[] twoSumTwoPointers(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1};
    }

    /**
     * Approach 4: Two Pointers with Original Indices (Unsorted Array)
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * 
     * Creates a copy with indices to preserve original positions
     * while using two pointer technique.
     */
    public static int[] twoSumTwoPointersWithIndices(int[] nums, int target) {
        // Create array of pairs (value, index)
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i]; // value
            pairs[i][1] = i;       // original index
        }
        
        // Sort by values
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Two pointer approach
        int left = 0, right = pairs.length - 1;
        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];
            
            if (sum == target) {
                return new int[]{pairs[left][1], pairs[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1};
    }

    /**
     * Approach 5: Binary Search (For Sorted Arrays)
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * 
     * For each element, search for its complement using binary search.
     */
    public static int[] twoSumBinarySearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            int complementIndex = binarySearch(nums, complement, i + 1);
            
            if (complementIndex != -1) {
                return new int[]{i, complementIndex};
            }
        }
        return new int[]{-1, -1};
    }
    
    private static int binarySearch(int[] nums, int target, int start) {
        int left = start, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    /**
     * Test various edge cases and scenarios
     */
    private static void testEdgeCases() {
        System.out.println("\n=== Edge Cases Testing ===");
        
        // Test 1: No solution
        int[] nums1 = {1, 2, 3, 4};
        int target1 = 10;
        System.out.println("No solution case: " + Arrays.toString(twoSumHashMap(nums1, target1)));
        
        // Test 2: Duplicate elements
        int[] nums2 = {3, 3};
        int target2 = 6;
        System.out.println("Duplicate elements: " + Arrays.toString(twoSumHashMap(nums2, target2)));
        
        // Test 3: Negative numbers
        int[] nums3 = {-1, -2, -3, -4, -5};
        int target3 = -8;
        System.out.println("Negative numbers: " + Arrays.toString(twoSumHashMap(nums3, target3)));
        
        // Test 4: Large array
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target4 = 19;
        System.out.println("Large array: " + Arrays.toString(twoSumHashMap(nums4, target4)));
    }

    /**
     * Performance Comparison
     */
    public static void performanceComparison() {
        System.out.println("\n=== Performance Comparison ===");
        
        // Create large test array
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i;
        }
        int target = 19998; // Should find 9999 + 9999
        
        long startTime, endTime;
        
        // Test Hash Map approach
        startTime = System.nanoTime();
        twoSumHashMap(largeArray, target);
        endTime = System.nanoTime();
        System.out.println("Hash Map: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Test Brute Force approach (will be much slower)
        startTime = System.nanoTime();
        twoSumBruteForce(largeArray, target);
        endTime = System.nanoTime();
        System.out.println("Brute Force: " + (endTime - startTime) / 1000000.0 + " ms");
    }
} 