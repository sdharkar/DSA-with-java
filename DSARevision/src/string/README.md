# String Interview Questions - Complete Guide

This directory contains comprehensive solutions to common string manipulation problems frequently asked in technical interviews.

## 📁 Files Overview

### Core String Operations
- **`StringRecall.java`** - Basic string operations and methods
- **`CharFrequency.java`** - Character frequency counting
- **`KeyboardTyping.java`** - Amazon interview question (keyboard mapping)
- **`StringInterviewQuestions.java`** - Comprehensive collection of 15+ string problems

### Recursive String Problems (in math/problems/string/)
- **`PalindroString.java`** - Palindrome checking using recursion
- **`Permutations.java`** - Find all string permutations
- **`AllSubsequences.java`** - Generate all possible subsequences
- **`ReverseStringReecursion.java`** - String reversal using recursion

## 🎯 String Interview Questions Categories

### 1. Basic String Operations
| Problem | Solution | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| Reverse String | `reverseString()` | O(n) | O(n) | Easy |
| Reverse String (In-place) | `reverseStringInPlace()` | O(n) | O(1) | Easy |
| Count Character Frequency | `countCharacterFrequency()` | O(n) | O(k) | Easy |
| First Non-Repeating Character | `findFirstNonRepeating()` | O(n) | O(k) | Medium |

### 2. Palindrome Problems
| Problem | Solution | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| Check Palindrome | `isPalindrome()` | O(n) | O(1) | Easy |
| Palindrome (ignore case/special chars) | `isPalindromeIgnoreCase()` | O(n) | O(1) | Easy |
| Longest Palindromic Substring | `longestPalindrome()` | O(n²) | O(1) | Medium |
| Recursive Palindrome Check | `PalindroString.java` | O(n) | O(n) | Easy |

### 3. Anagram Problems
| Problem | Solution | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| Check if Anagrams | `areAnagrams()` | O(n) | O(k) | Easy |
| Group Anagrams | `groupAnagrams()` | O(n*k*log k) | O(n*k) | Medium |

### 4. Substring Problems
| Problem | Solution | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| Longest Substring Without Repeating | `lengthOfLongestSubstring()` | O(n) | O(min(m,n)) | Medium |
| Longest Common Substring | `longestCommonSubstring()` | O(m*n) | O(m*n) | Medium |
| All Substrings | `getAllSubstrings()` | O(n²) | O(n²) | Easy |
| All Subsequences | `AllSubsequences.java` | O(2ⁿ) | O(2ⁿ) | Medium |

### 5. Advanced String Problems
| Problem | Solution | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| String to Integer (atoi) | `stringToInteger()` | O(n) | O(1) | Medium |
| Valid Parentheses | `isValidParentheses()` | O(n) | O(n) | Easy |
| Minimum Window Substring | `minWindow()` | O(n) | O(k) | Hard |
| String Permutations | `Permutations.java` | O(n!) | O(n!) | Medium |

### 6. Special Problems
| Problem | Solution | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| Keyboard Typing (Amazon) | `KeyboardTyping.java` | O(n) | O(n) | Easy |
| Recursive String Reverse | `ReverseStringReecursion.java` | O(n) | O(n) | Easy |

## 🚀 How to Run

### Compile and Run All String Questions
```bash
# Compile
javac -d bin src/string/StringInterviewQuestions.java

# Run
java -cp bin string.StringInterviewQuestions
```

### Run Individual Files
```bash
# Basic string operations
java -cp bin string.StringRecall

# Character frequency
java -cp bin string.CharFrequency

# Amazon keyboard typing
java -cp bin string.KeyboardTyping

# Recursive palindrome
java -cp bin math.problems.string.PalindroString

# String permutations
java -cp bin math.problems.string.Permutations
```

## 📚 Key Concepts to Master

### 1. String Immutability
- Strings in Java are immutable
- Use `StringBuilder` for efficient string manipulation
- String concatenation creates new objects

### 2. Common String Methods
```java
str.length()           // Get length
str.charAt(index)      // Get character at index
str.substring(start, end) // Get substring
str.indexOf(char)      // Find first occurrence
str.lastIndexOf(char)  // Find last occurrence
str.equals(str2)       // Compare content
str.compareTo(str2)    // Lexicographical comparison
str.trim()             // Remove leading/trailing spaces
str.split(regex)       // Split string
str.replace(old, new)  // Replace characters/strings
```

### 3. Character Operations
```java
Character.isLetterOrDigit(ch)  // Check if alphanumeric
Character.isLetter(ch)         // Check if letter
Character.isDigit(ch)          // Check if digit
Character.toLowerCase(ch)      // Convert to lowercase
Character.toUpperCase(ch)      // Convert to uppercase
```

### 4. Data Structures for String Problems
- **HashMap**: Character frequency, anagram checking
- **HashSet**: Unique character tracking
- **Stack**: Parentheses matching, expression evaluation
- **Two Pointers**: Palindrome checking, substring problems
- **Sliding Window**: Longest substring problems

## 🎯 Interview Tips

### 1. Always Consider Edge Cases
- Null strings
- Empty strings
- Single character strings
- Case sensitivity
- Special characters
- Whitespace

### 2. Optimization Strategies
- **Two Pointers**: For palindrome and substring problems
- **Sliding Window**: For substring with constraints
- **Hash Maps**: For frequency counting and anagrams
- **Dynamic Programming**: For complex substring problems

### 3. Common Patterns
- **Expand Around Center**: For palindrome problems
- **Sliding Window**: For substring problems
- **Frequency Counting**: For anagram and character problems
- **Stack-based**: For parentheses and expression problems

### 4. Time/Space Complexity Analysis
- Always mention time and space complexity
- Consider both best and worst cases
- Explain trade-offs between different approaches

## 🔍 Practice Problems by Difficulty

### Easy Level
1. Reverse a string
2. Check if string is palindrome
3. Count character frequency
4. Find first non-repeating character
5. Valid parentheses
6. String to integer conversion

### Medium Level
1. Longest substring without repeating characters
2. Group anagrams
3. Longest palindromic substring
4. Longest common substring
5. String permutations
6. All subsequences

### Hard Level
1. Minimum window substring
2. Regular expression matching
3. Wildcard pattern matching
4. Edit distance
5. Longest valid parentheses

## 📖 Additional Resources

- **String DSA Patterns PDF**: Available in the main directory
- **LeetCode String Problems**: Practice on leetcode.com
- **HackerRank String Problems**: Additional practice problems
- **GeeksforGeeks**: Comprehensive string algorithms

## 🎯 Quick Reference

### Common Interview Questions
1. "Reverse a string without using extra space"
2. "Check if two strings are anagrams"
3. "Find the longest palindromic substring"
4. "Group anagrams from a list of strings"
5. "Find the longest substring without repeating characters"
6. "Convert string to integer (handle edge cases)"
7. "Check if parentheses are valid"
8. "Find minimum window substring"

### Key Algorithms
- **Manacher's Algorithm**: For longest palindromic substring (O(n))
- **KMP Algorithm**: For string pattern matching
- **Rabin-Karp**: For substring search
- **Suffix Trees**: For complex string problems

This comprehensive guide covers all essential string manipulation problems you'll encounter in technical interviews! 