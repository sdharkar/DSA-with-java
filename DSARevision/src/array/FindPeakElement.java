package array;

/**
 * Find Peak Element Problem
 * 
 * Problem: A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * 
 * Asked by: Google, Amazon, Microsoft, Apple
 * Frequency: High
 */
public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println("=== Find Peak Element Problem ===\n");
        
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {5, 4, 3, 2, 1};
        
        System.out.println("Array 1: [1, 2, 3, 1]");
        System.out.println("Peak element index: " + findPeakElement(nums1));
        
        System.out.println("\nArray 2: [1, 2, 1, 3, 5, 6, 4]");
        System.out.println("Peak element index: " + findPeakElement(nums2));
        
        System.out.println("\nArray 3: [1, 2, 3, 4, 5]");
        System.out.println("Peak element index: " + findPeakElement(nums3));
        
        System.out.println("\nArray 4: [5, 4, 3, 2, 1]");
        System.out.println("Peak element index: " + findPeakElement(nums4));
        
        // Test all approaches
        System.out.println("\n=== All Approaches Comparison ===");
        testAllApproaches(nums2);
    }

    /**
     * Approach 1: Linear Scan
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * Simple approach - check each element with its neighbors.
     */
    public static int findPeakElementLinear(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isPeak = true;
            
            // Check left neighbor
            if (i > 0 && nums[i] <= nums[i - 1]) {
                isPeak = false;
            }
            
            // Check right neighbor
            if (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                isPeak = false;
            }
            
            if (isPeak) {
                return i;
            }
        }
        
        return -1; // No peak found (shouldn't happen for valid input)
    }

    /**
     * Approach 2: Binary Search (Optimal)
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * Key insight: If nums[mid] < nums[mid + 1], then peak is in right half.
     * If nums[mid] > nums[mid + 1], then peak is in left half.
     */
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Compare with right neighbor
            if (nums[mid] < nums[mid + 1]) {
                // Peak is in right half
                left = mid + 1;
            } else {
                // Peak is in left half (including mid)
                right = mid;
            }
        }
        
        return left; // left == right at this point
    }

    /**
     * Approach 3: Recursive Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) due to recursion stack
     */
    public static int findPeakElementRecursive(int[] nums) {
        return binarySearchRecursive(nums, 0, nums.length - 1);
    }
    
    private static int binarySearchRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        
        int mid = left + (right - left) / 2;
        
        if (nums[mid] < nums[mid + 1]) {
            return binarySearchRecursive(nums, mid + 1, right);
        } else {
            return binarySearchRecursive(nums, left, mid);
        }
    }

    /**
     * Approach 4: Find Global Maximum
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * Since we can return any peak, we can simply find the global maximum.
     * This works because the global maximum is always a peak.
     */
    public static int findPeakElementGlobalMax(int[] nums) {
        int maxIndex = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }

    /**
     * Approach 5: Check for Local Peaks
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * Find all local peaks and return the first one.
     */
    public static int findPeakElementLocalPeaks(int[] nums) {
        // Handle edge cases
        if (nums.length == 1) return 0;
        
        // Check first element
        if (nums[0] > nums[1]) return 0;
        
        // Check middle elements
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        
        // Check last element
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        
        return -1;
    }

    /**
     * Approach 6: Binary Search with Custom Comparator
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * More explicit binary search approach.
     */
    public static int findPeakElementBinarySearch(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is a peak
            boolean isPeak = true;
            
            if (mid > 0 && nums[mid] <= nums[mid - 1]) {
                isPeak = false;
            }
            
            if (mid < nums.length - 1 && nums[mid] <= nums[mid + 1]) {
                isPeak = false;
            }
            
            if (isPeak) {
                return mid;
            }
            
            // Decide which half to search
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                // Peak is in left half
                right = mid - 1;
            } else {
                // Peak is in right half
                left = mid + 1;
            }
        }
        
        return -1;
    }

    /**
     * Test all approaches on the same array
     */
    private static void testAllApproaches(int[] nums) {
        System.out.println("Testing array: " + java.util.Arrays.toString(nums));
        
        System.out.println("1. Linear Scan: " + findPeakElementLinear(nums));
        System.out.println("2. Binary Search: " + findPeakElement(nums));
        System.out.println("3. Recursive Binary Search: " + findPeakElementRecursive(nums));
        System.out.println("4. Global Maximum: " + findPeakElementGlobalMax(nums));
        System.out.println("5. Local Peaks: " + findPeakElementLocalPeaks(nums));
        System.out.println("6. Binary Search with Comparator: " + findPeakElementBinarySearch(nums));
    }

    /**
     * Performance comparison of different approaches
     */
    public static void performanceComparison() {
        System.out.println("\n=== Performance Comparison ===");
        
        // Create large test array
        int[] largeArray = new int[1000000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i;
        }
        // Make it have a peak in the middle
        largeArray[500000] = 1000000;
        
        long startTime, endTime;
        
        // Test Binary Search (should be fastest)
        startTime = System.nanoTime();
        findPeakElement(largeArray);
        endTime = System.nanoTime();
        System.out.println("Binary Search: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Test Linear Scan
        startTime = System.nanoTime();
        findPeakElementLinear(largeArray);
        endTime = System.nanoTime();
        System.out.println("Linear Scan: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Test Global Maximum
        startTime = System.nanoTime();
        findPeakElementGlobalMax(largeArray);
        endTime = System.nanoTime();
        System.out.println("Global Maximum: " + (endTime - startTime) / 1000000.0 + " ms");
    }

    /**
     * Edge cases testing
     */
    public static void testEdgeCases() {
        System.out.println("\n=== Edge Cases Testing ===");
        
        // Single element
        int[] single = {5};
        System.out.println("Single element [5]: " + findPeakElement(single));
        
        // Two elements
        int[] two = {1, 2};
        System.out.println("Two elements [1, 2]: " + findPeakElement(two));
        
        // All same elements
        int[] same = {3, 3, 3, 3};
        System.out.println("All same [3, 3, 3, 3]: " + findPeakElement(same));
        
        // Strictly increasing
        int[] increasing = {1, 2, 3, 4, 5};
        System.out.println("Strictly increasing [1, 2, 3, 4, 5]: " + findPeakElement(increasing));
        
        // Strictly decreasing
        int[] decreasing = {5, 4, 3, 2, 1};
        System.out.println("Strictly decreasing [5, 4, 3, 2, 1]: " + findPeakElement(decreasing));
    }
} 