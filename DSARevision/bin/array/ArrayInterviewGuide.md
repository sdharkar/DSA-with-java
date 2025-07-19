# Array Interview Questions - Complete Study Guide

## 🎯 Overview

Arrays are the most fundamental data structure and appear in **80%+** of technical interviews. This guide covers all essential array problems with optimized solutions.

## 📊 Interview Statistics

- **Frequency**: Arrays appear in 85% of coding interviews
- **Difficulty Distribution**: 40% Easy, 40% Medium, 20% Hard
- **Most Common**: Two Sum, Maximum Subarray, Move Zeroes
- **Top Companies**: Google, Amazon, Microsoft, Apple, Facebook

## 🚀 Quick Start

### Essential Files
1. **`ArrayQuickReference.java`** - 15 most common problems
2. **`TwoSum.java`** - Multiple approaches to the #1 problem
3. **`FindPeakElement.java`** - Binary search optimization
4. **`ArrayRecall.java`** - Fundamental operations

### Run Everything
```bash
javac -d bin src/array/*.java
java -cp bin array.ArrayQuickReference
```

## 🏆 Top 10 Most Important Array Problems

### 1. Two Sum ⭐⭐⭐⭐⭐
**Frequency**: Extremely High  
**Companies**: All major tech companies  
**Approach**: Hash Map (O(n) time, O(n) space)

```java
public int[] twoSum(int[] nums, int target) {
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
```

### 2. Maximum Subarray (Kadane's) ⭐⭐⭐⭐⭐
**Frequency**: Very High  
**Companies**: Amazon, Google, Microsoft  
**Approach**: Kadane's Algorithm (O(n) time, O(1) space)

```java
public int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    int currentSum = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}
```

### 3. Best Time to Buy/Sell Stock ⭐⭐⭐⭐
**Frequency**: High  
**Companies**: Amazon, Google, Microsoft  
**Approach**: Single pass (O(n) time, O(1) space)

```java
public int maxProfit(int[] prices) {
    int minPrice = prices[0];
    int maxProfit = 0;
    
    for (int price : prices) {
        minPrice = Math.min(minPrice, price);
        maxProfit = Math.max(maxProfit, price - minPrice);
    }
    return maxProfit;
}
```

### 4. Move Zeroes ⭐⭐⭐⭐
**Frequency**: High  
**Companies**: Amazon, Google, Microsoft  
**Approach**: Two pointers (O(n) time, O(1) space)

```java
public void moveZeroes(int[] nums) {
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
```

### 5. Majority Element ⭐⭐⭐⭐
**Frequency**: High  
**Companies**: Amazon, Google, Microsoft  
**Approach**: Moore's Voting Algorithm (O(n) time, O(1) space)

```java
public int majorityElement(int[] nums) {
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
```

### 6. Find Peak Element ⭐⭐⭐
**Frequency**: Medium-High  
**Companies**: Google, Amazon, Microsoft  
**Approach**: Binary Search (O(log n) time, O(1) space)

```java
public int findPeakElement(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < nums[mid + 1]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}
```

### 7. Product of Array Except Self ⭐⭐⭐
**Frequency**: Medium  
**Companies**: Amazon, Google, Microsoft  
**Approach**: Prefix/Suffix products (O(n) time, O(1) space)

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    
    result[0] = 1;
    for (int i = 1; i < n; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }
    
    int rightProduct = 1;
    for (int i = n - 1; i >= 0; i--) {
        result[i] = result[i] * rightProduct;
        rightProduct *= nums[i];
    }
    
    return result;
}
```

### 8. Container With Most Water ⭐⭐⭐
**Frequency**: Medium  
**Companies**: Amazon, Google, Microsoft  
**Approach**: Two pointers (O(n) time, O(1) space)

```java
public int maxArea(int[] height) {
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
```

### 9. Trapping Rain Water ⭐⭐⭐
**Frequency**: Medium  
**Companies**: Amazon, Google, Microsoft  
**Approach**: Two pointers (O(n) time, O(1) space)

```java
public int trap(int[] height) {
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
```

### 10. Rotate Array ⭐⭐⭐
**Frequency**: Medium  
**Companies**: Amazon, Google, Microsoft  
**Approach**: Reverse method (O(n) time, O(1) space)

```java
public void rotate(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
```

## 🎯 Interview Strategy

### Before the Interview
1. **Master the top 5 problems** - Two Sum, Max Subarray, Buy/Sell Stock, Move Zeroes, Majority Element
2. **Practice edge cases** - Empty arrays, single elements, duplicates, negative numbers
3. **Understand time/space complexity** - Be able to explain trade-offs

### During the Interview
1. **Clarify the problem** - Ask about input constraints, edge cases, return format
2. **Start with brute force** - Show you can solve it, then optimize
3. **Explain your approach** - Walk through your thought process
4. **Handle edge cases** - Always check for null, empty, single element
5. **Test your code** - Walk through examples step by step

### Common Follow-up Questions
- "What if the array is sorted?"
- "What if we need to find all solutions?"
- "Can you optimize the space complexity?"
- "What if the array is very large?"

## 🔍 Problem Patterns

### 1. Two Pointers
- **Use case**: Sorted arrays, palindrome, container problems
- **Pattern**: One pointer from start, one from end
- **Examples**: Two Sum (sorted), Container with Most Water

### 2. Sliding Window
- **Use case**: Subarray problems, substring without repeating
- **Pattern**: Expand window, then shrink when condition met
- **Examples**: Maximum Subarray, Longest Substring Without Repeating

### 3. Hash Map
- **Use case**: Frequency counting, complement finding
- **Pattern**: Store elements/indices as you iterate
- **Examples**: Two Sum, Contains Duplicate, Group Anagrams

### 4. In-place Manipulation
- **Use case**: Array modification without extra space
- **Pattern**: Use write pointer to track position
- **Examples**: Move Zeroes, Remove Duplicates, Rotate Array

### 5. Binary Search
- **Use case**: Sorted arrays, peak finding
- **Pattern**: Divide search space in half each iteration
- **Examples**: Find Peak Element, Search in Rotated Array

## ⏱️ Time Complexity Guide

| Problem Type | Brute Force | Optimal | Space |
|--------------|-------------|---------|-------|
| Two Sum | O(n²) | O(n) | O(n) |
| Maximum Subarray | O(n³) | O(n) | O(1) |
| Buy/Sell Stock | O(n²) | O(n) | O(1) |
| Move Zeroes | O(n²) | O(n) | O(1) |
| Majority Element | O(n²) | O(n) | O(1) |
| Find Peak | O(n) | O(log n) | O(1) |
| Product Except Self | O(n²) | O(n) | O(1) |
| Container Water | O(n²) | O(n) | O(1) |
| Trap Water | O(n²) | O(n) | O(1) |
| Rotate Array | O(n) | O(n) | O(1) |

## 🏢 Company-Specific Focus

### Google
- Two Sum variations
- Maximum Subarray
- Product of Array Except Self
- Find Peak Element

### Amazon
- Best Time to Buy/Sell Stock
- Move Zeroes
- Majority Element
- Container With Most Water

### Microsoft
- Rotate Array
- Merge Sorted Array
- Trapping Rain Water
- Find All Duplicates

### Apple
- Maximum Product Subarray
- Find Peak Element
- Two Sum
- Move Zeroes

### Facebook
- Two Sum
- Maximum Subarray
- Product of Array Except Self
- Container With Most Water

## 📚 Study Plan

### Week 1: Fundamentals
- [ ] Master basic array operations
- [ ] Practice two pointer technique
- [ ] Learn hash map applications
- [ ] Solve: Two Sum, Move Zeroes, Contains Duplicate

### Week 2: Classic Algorithms
- [ ] Implement Kadane's algorithm
- [ ] Practice Moore's voting algorithm
- [ ] Master sliding window technique
- [ ] Solve: Maximum Subarray, Majority Element, Buy/Sell Stock

### Week 3: Advanced Problems
- [ ] Learn binary search on arrays
- [ ] Practice in-place manipulations
- [ ] Work on optimization techniques
- [ ] Solve: Find Peak Element, Product Except Self, Rotate Array

### Week 4: Complex Problems
- [ ] Solve dynamic programming array problems
- [ ] Practice two pointer variations
- [ ] Work on edge case handling
- [ ] Solve: Container With Most Water, Trap Water, Find All Duplicates

### Week 5: Mock Interviews
- [ ] Time yourself on problems (15-20 minutes each)
- [ ] Practice explaining solutions
- [ ] Focus on edge case handling
- [ ] Review all problems and patterns

## 🎯 Success Tips

1. **Practice Daily** - Solve at least 2-3 array problems daily
2. **Understand Patterns** - Don't memorize, understand the underlying patterns
3. **Handle Edge Cases** - Always consider null, empty, single element cases
4. **Explain Your Code** - Practice explaining your approach and code
5. **Time Yourself** - Get comfortable with time constraints
6. **Review Solutions** - After solving, review optimal solutions
7. **Mock Interviews** - Practice with real interview scenarios

## 📖 Additional Resources

- **LeetCode Array Problems**: 200+ problems with solutions
- **HackerRank Arrays**: Practice problems with test cases
- **GeeksforGeeks**: Detailed explanations and multiple approaches
- **InterviewBit**: Company-specific questions and solutions

---

**Remember**: Arrays are the foundation of most data structures. Master these problems, and you'll be well-prepared for any array-related interview question! 