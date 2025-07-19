# Array Interview Questions - Complete Guide

This directory contains comprehensive solutions to the most commonly asked array problems in technical interviews.

## 📋 Table of Contents

1. [Quick Reference](#quick-reference)
2. [Core Array Problems](#core-array-problems)
3. [Advanced Array Problems](#advanced-array-problems)
4. [Interview Tips](#interview-tips)
5. [Common Patterns](#common-patterns)
6. [Time & Space Complexity Guide](#time--space-complexity-guide)

## 🚀 Quick Reference

**File**: `ArrayQuickReference.java`
- Contains 15 most common array interview questions
- Optimized solutions with time/space complexity
- Ready-to-use code for quick review

### Most Common Questions (Top 5)
1. **Two Sum** - Find pair that sums to target
2. **Maximum Subarray** - Kadane's Algorithm
3. **Best Time to Buy/Sell Stock** - Single transaction
4. **Majority Element** - Moore's Voting Algorithm
5. **Move Zeroes** - In-place array manipulation

## 📚 Core Array Problems

### Basic Operations
- **ArrayRecall.java** - Fundamental array operations and concepts
- Array declaration, initialization, and manipulation
- Iteration techniques (for loop, enhanced for loop)
- Array utilities (sorting, searching, copying)

### Classic Algorithms
- **LargestSumContiguousSubarrayKaden.java** - Kadane's Algorithm
- **MajorityElementMoore.java** - Moore's Voting Algorithm
- **MajorityElementHashMap.java** - Hash Map approach
- **MajorityElementSimple.java** - Simple counting approach

### Advanced Problems
- **RainwaterTrappingProblem.java** - Two pointer technique
- **StocksBuyNSell.java** - Dynamic programming approach
- **HandlingEdgeCasesKadane.java** - Edge case handling

## 🎯 Interview Tips

### Before Starting
1. **Clarify the problem** - Ask about input constraints, edge cases
2. **Provide examples** - Walk through sample inputs/outputs
3. **Discuss approach** - Explain your thought process before coding

### During Implementation
1. **Start with brute force** - Show you can solve it, then optimize
2. **Handle edge cases** - Null arrays, empty arrays, single elements
3. **Test your code** - Walk through examples step by step

### Common Mistakes to Avoid
- ❌ Not handling null/empty arrays
- ❌ Array index out of bounds
- ❌ Forgetting to update pointers in two-pointer problems
- ❌ Not considering negative numbers in sum problems
- ❌ Ignoring space complexity trade-offs

## 🔍 Common Patterns

### 1. Two Pointers Technique
```java
// Used for: sorted arrays, palindrome, container with most water
int left = 0, right = array.length - 1;
while (left < right) {
    // Process elements from both ends
}
```

### 2. Sliding Window
```java
// Used for: subarray problems, substring without repeating characters
int left = 0, right = 0;
while (right < array.length) {
    // Expand window
    while (condition) {
        // Shrink window
        left++;
    }
    right++;
}
```

### 3. Hash Map for Frequency
```java
// Used for: duplicates, anagrams, two sum
Map<Integer, Integer> freq = new HashMap<>();
for (int num : array) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```

### 4. In-place Array Manipulation
```java
// Used for: move zeroes, remove duplicates, rotate array
int writeIndex = 0;
for (int readIndex = 0; readIndex < array.length; readIndex++) {
    if (condition) {
        array[writeIndex++] = array[readIndex];
    }
}
```

## ⏱️ Time & Space Complexity Guide

### Common Time Complexities
- **O(1)** - Constant time operations
- **O(n)** - Linear time - single pass through array
- **O(n log n)** - Sorting algorithms
- **O(n²)** - Nested loops, bubble sort
- **O(n³)** - Three nested loops (rare)

### Common Space Complexities
- **O(1)** - Constant extra space (in-place algorithms)
- **O(n)** - Linear extra space (hash maps, result arrays)
- **O(log n)** - Recursive call stack

### Problem-Specific Complexities

| Problem | Time | Space | Approach |
|---------|------|-------|----------|
| Two Sum | O(n) | O(n) | Hash Map |
| Max Subarray | O(n) | O(1) | Kadane's |
| Move Zeroes | O(n) | O(1) | Two Pointers |
| Rotate Array | O(n) | O(1) | Reverse Method |
| Product Except Self | O(n) | O(1) | Prefix/Suffix |
| Majority Element | O(n) | O(1) | Moore's Voting |

## 🎓 Study Strategy

### Week 1: Fundamentals
- Master basic array operations
- Practice two pointer technique
- Learn hash map applications

### Week 2: Classic Algorithms
- Implement Kadane's algorithm
- Practice Moore's voting algorithm
- Master sliding window technique

### Week 3: Advanced Problems
- Solve dynamic programming array problems
- Practice in-place manipulations
- Work on optimization techniques

### Week 4: Mock Interviews
- Time yourself on problems
- Practice explaining solutions
- Focus on edge case handling

## 🔧 Running the Code

```bash
# Compile
javac -d bin src/array/*.java

# Run Quick Reference
java -cp bin array.ArrayQuickReference

# Run specific problem
java -cp bin array.TwoSum
```

## 📖 Additional Resources

- **LeetCode Array Problems**: 200+ problems
- **HackerRank Arrays**: Practice problems
- **GeeksforGeeks**: Detailed explanations
- **InterviewBit**: Company-specific questions

## 🏆 Top Companies & Their Favorite Array Questions

### Google
- Two Sum variations
- Maximum Subarray
- Product of Array Except Self

### Amazon
- Best Time to Buy/Sell Stock
- Move Zeroes
- Majority Element

### Microsoft
- Rotate Array
- Merge Sorted Array
- Container With Most Water

### Apple
- Trapping Rain Water
- Find All Duplicates
- Maximum Product Subarray

---

**Remember**: Practice makes perfect! Focus on understanding the patterns rather than memorizing solutions. 