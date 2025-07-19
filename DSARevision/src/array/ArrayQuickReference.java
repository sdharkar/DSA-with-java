package array;

import java.util.*;

/**
 * Quick Reference for Array Interview Questions
 * 
 * This file contains the most commonly asked array problems
 * with concise solutions for quick review before interviews.
 */
public class ArrayQuickReference {

    public static void main(String[] args) {
        System.out.println("=== Array Interview Quick Reference ===\n");
        
        // Test all quick reference methods
        testQuickReference();
    }

    // ==================== MOST COMMON INTERVIEW QUESTIONS ====================

    /**
     * 1. Two Sum (Most Common)
     * Asked by: Google, Amazon, Microsoft, Apple, Facebook
     * Time: O(n), Space: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 2. Maximum Subarray Sum (Kadane's Algorithm) - Very Common
     * Asked by: Amazon, Google, Microsoft, Apple
     * Time: O(n), Space: O(1)
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    /**
     * 3. Best Time to Buy and Sell Stock (Common)
     * Asked by: Amazon, Google, Microsoft, Apple
     * Time: O(n), Space: O(1)
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    /**
     * 4. Majority Element (Moore's Voting Algorithm) - Common
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(1)
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    /**
     * 5. Move Zeroes (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(1)
     */
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }

    /**
     * 6. Contains Duplicate (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(n)
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    /**
     * 7. Missing Number (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(1)
     */
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }

    /**
     * 8. Rotate Array (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(1)
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 9. Product of Array Except Self (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(1) excluding output array
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Calculate right products and combine
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }

    /**
     * 10. Maximum Product Subarray (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(1)
     */
    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;
            currentMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(temp * nums[i], currentMin * nums[i]));
            maxProduct = Math.max(maxProduct, currentMax);
        }
        
        return maxProduct;
    }

    /**
     * 11. Find All Duplicates in Array (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(1) excluding output
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(num));
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }

    /**
     * 12. Container With Most Water (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(1)
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }

    /**
     * 13. Trapping Rain Water (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(1)
     */
    public static int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        
        return water;
    }

    /**
     * 14. Merge Sorted Array (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(m + n), Space: O(1)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

    /**
     * 15. Remove Duplicates from Sorted Array (Common)
     * Asked by: Amazon, Google, Microsoft
     * Time: O(n), Space: O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                nums[++uniqueIndex] = nums[i];
            }
        }
        
        return uniqueIndex + 1;
    }

    // ==================== QUICK REFERENCE METHODS ====================

    /**
     * Find Minimum and Maximum in Single Pass
     */
    public static int[] findMinMax(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return new int[]{min, max};
    }

    /**
     * Check if Array is Sorted
     */
    public static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }

    /**
     * Find Second Largest Element
     */
    public static int findSecondLargest(int[] nums) {
        if (nums.length < 2) return -1;
        
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }

    /**
     * Reverse Array In-Place
     */
    public static void reverseArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Find Kth Largest Element (Quick Select)
     */
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        
        int pivotIndex = partition(nums, left, right);
        
        if (k == pivotIndex) return nums[k];
        else if (k < pivotIndex) return quickSelect(nums, left, pivotIndex - 1, k);
        else return quickSelect(nums, pivotIndex + 1, right, k);
    }
    
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
        
        return i;
    }

    // ==================== TESTING ====================

    private static void testQuickReference() {
        System.out.println("1. Two Sum [2,7,11,15], target=9: " + Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println("2. Max Subarray [-2,1,-3,4,-1,2,1,-5,4]: " + maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("3. Max Profit [7,1,5,3,6,4]: " + maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("4. Majority Element [2,2,1,1,1,2,2]: " + majorityElement(new int[]{2,2,1,1,1,2,2}));
        
        int[] zeroArray = {0,1,0,3,12};
        moveZeroes(zeroArray);
        System.out.println("5. Move Zeroes [0,1,0,3,12]: " + Arrays.toString(zeroArray));
        
        System.out.println("6. Contains Duplicate [1,2,3,1]: " + containsDuplicate(new int[]{1,2,3,1}));
        System.out.println("7. Missing Number [3,0,1]: " + missingNumber(new int[]{3,0,1}));
        
        int[] rotateArray = {1,2,3,4,5,6,7};
        rotate(rotateArray, 3);
        System.out.println("8. Rotate Array [1,2,3,4,5,6,7] by 3: " + Arrays.toString(rotateArray));
        
        System.out.println("9. Product Except Self [1,2,3,4]: " + Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println("10. Max Product [2,3,-2,4]: " + maxProduct(new int[]{2,3,-2,4}));
        System.out.println("11. Find Duplicates [4,3,2,7,8,2,3,1]: " + findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println("12. Max Area [1,8,6,2,5,4,8,3,7]: " + maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println("13. Trap Water [0,1,0,2,1,0,1,3,2,1,2,1]: " + trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println("14. Merge Sorted Arrays: " + Arrays.toString(nums1));
        
        int[] dupArray = {0,0,1,1,1,2,2,3,3,4};
        int newLength = removeDuplicates(dupArray);
        System.out.println("15. Remove Duplicates: " + Arrays.toString(Arrays.copyOf(dupArray, newLength)));
        
        System.out.println("\n--- Quick Methods ---");
        System.out.println("Min/Max [3,1,4,1,5,9,2,6]: " + Arrays.toString(findMinMax(new int[]{3,1,4,1,5,9,2,6})));
        System.out.println("Is Sorted [1,2,3,4,5]: " + isSorted(new int[]{1,2,3,4,5}));
        System.out.println("Second Largest [12,35,1,10,34,1]: " + findSecondLargest(new int[]{12,35,1,10,34,1}));
        
        int[] reverseTest = {1,2,3,4,5};
        reverseArray(reverseTest);
        System.out.println("Reverse Array [1,2,3,4,5]: " + Arrays.toString(reverseTest));
        
        System.out.println("Kth Largest [3,2,1,5,6,4], k=2: " + findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
} 