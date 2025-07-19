package string;

import java.util.*;

/**
 * Comprehensive String Interview Questions Collection
 * 
 * This file contains solutions to common string manipulation problems
 * frequently asked in technical interviews.
 */
public class StringInterviewQuestions {

    public static void main(String[] args) {
        System.out.println("=== String Interview Questions ===\n");
        
        // Test all methods
        testBasicStringOperations();
        testPalindromeProblems();
        testAnagramProblems();
        testSubstringProblems();
        testAdvancedStringProblems();
    }

    // ==================== BASIC STRING OPERATIONS ====================

    /**
     * 1. Reverse a String
     * Time: O(n), Space: O(n)
     */
    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) return str;
        
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 2. Reverse a String (In-place for char array)
     * Time: O(n), Space: O(1)
     */
    public static void reverseStringInPlace(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 3. Count Character Frequency
     * Time: O(n), Space: O(k) where k is unique characters
     */
    public static Map<Character, Integer> countCharacterFrequency(String str) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        return frequency;
    }

    /**
     * 4. Find First Non-Repeating Character
     * Time: O(n), Space: O(k)
     */
    public static char findFirstNonRepeating(String str) {
        Map<Character, Integer> frequency = new HashMap<>();
        
        // Count frequency
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        
        // Find first non-repeating
        for (char c : str.toCharArray()) {
            if (frequency.get(c) == 1) {
                return c;
            }
        }
        
        return '\0'; // No non-repeating character found
    }

    // ==================== PALINDROME PROBLEMS ====================

    /**
     * 5. Check if String is Palindrome
     * Time: O(n), Space: O(1)
     */
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 6. Check if String is Palindrome (ignoring case and non-alphanumeric)
     * Time: O(n), Space: O(1)
     */
    public static boolean isPalindromeIgnoreCase(String str) {
        if (str == null) return false;
        
        int left = 0, right = str.length() - 1;
        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) right--;
            
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 7. Find Longest Palindromic Substring
     * Time: O(n²), Space: O(1)
     */
    public static String longestPalindrome(String str) {
        if (str == null || str.length() < 2) return str;
        
        int start = 0, maxLength = 1;
        
        for (int i = 0; i < str.length(); i++) {
            // Check odd length palindromes
            int len1 = expandAroundCenter(str, i, i);
            // Check even length palindromes
            int len2 = expandAroundCenter(str, i, i + 1);
            
            int maxLen = Math.max(len1, len2);
            if (maxLen > maxLength) {
                start = i - (maxLen - 1) / 2;
                maxLength = maxLen;
            }
        }
        
        return str.substring(start, start + maxLength);
    }
    
    private static int expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // ==================== ANAGRAM PROBLEMS ====================

    /**
     * 8. Check if Two Strings are Anagrams
     * Time: O(n), Space: O(k)
     */
    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        
        Map<Character, Integer> frequency = new HashMap<>();
        
        // Count characters in first string
        for (char c : str1.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        
        // Decrement for second string
        for (char c : str2.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) - 1);
            if (frequency.get(c) < 0) return false;
        }
        
        return true;
    }

    /**
     * 9. Group Anagrams
     * Time: O(n * k * log k), Space: O(n * k)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for (String str : strs) {
            // Sort characters to create key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(groups.values());
    }

    // ==================== SUBSTRING PROBLEMS ====================

    /**
     * 10. Find Longest Substring Without Repeating Characters
     * Time: O(n), Space: O(min(m, n))
     */
    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) return 0;
        
        Set<Character> set = new HashSet<>();
        int maxLength = 0, left = 0, right = 0;
        
        while (right < str.length()) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(str.charAt(left));
                left++;
            }
        }
        
        return maxLength;
    }

    /**
     * 11. Find Longest Common Substring
     * Time: O(m*n), Space: O(m*n)
     */
    public static String longestCommonSubstring(String str1, String str2) {
        if (str1 == null || str2 == null) return "";
        
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0, endIndex = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }
        
        return str1.substring(endIndex - maxLength + 1, endIndex + 1);
    }

    /**
     * 12. Find All Substrings
     * Time: O(n²), Space: O(n²)
     */
    public static List<String> getAllSubstrings(String str) {
        List<String> substrings = new ArrayList<>();
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                substrings.add(str.substring(i, j));
            }
        }
        
        return substrings;
    }

    // ==================== ADVANCED STRING PROBLEMS ====================

    /**
     * 13. String to Integer (atoi)
     * Time: O(n), Space: O(1)
     */
    public static int stringToInteger(String str) {
        if (str == null || str.length() == 0) return 0;
        
        str = str.trim();
        if (str.length() == 0) return 0;
        
        int sign = 1, i = 0;
        long result = 0;
        
        // Handle sign
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = str.charAt(0) == '-' ? -1 : 1;
            i++;
        }
        
        // Convert digits
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i) - '0');
            
            // Check overflow
            if (sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && result > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            
            i++;
        }
        
        return (int) (sign * result);
    }

    /**
     * 14. Valid Parentheses
     * Time: O(n), Space: O(n)
     */
    public static boolean isValidParentheses(String str) {
        if (str == null || str.length() == 0) return true;
        
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        
        for (char c : str.toCharArray()) {
            if (pairs.containsValue(c)) {
                stack.push(c);
            } else if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    /**
     * 15. Minimum Window Substring
     * Time: O(n), Space: O(k)
     */
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        
        Map<Character, Integer> targetFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();
        
        // Count target characters
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        int required = targetFreq.size(), formed = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            
            if (targetFreq.containsKey(c) && 
                windowFreq.get(c).equals(targetFreq.get(c))) {
                formed++;
            }
            
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                windowFreq.put(c, windowFreq.get(c) - 1);
                if (targetFreq.containsKey(c) && 
                    windowFreq.get(c) < targetFreq.get(c)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    // ==================== TESTING METHODS ====================

    private static void testBasicStringOperations() {
        System.out.println("--- Basic String Operations ---");
        
        System.out.println("1. Reverse 'hello': " + reverseString("hello"));
        
        char[] chars = "hello".toCharArray();
        reverseStringInPlace(chars);
        System.out.println("2. Reverse in-place: " + new String(chars));
        
        System.out.println("3. Character frequency in 'hello': " + countCharacterFrequency("hello"));
        System.out.println("4. First non-repeating in 'leetcode': " + findFirstNonRepeating("leetcode"));
    }

    private static void testPalindromeProblems() {
        System.out.println("\n--- Palindrome Problems ---");
        
        System.out.println("5. Is 'racecar' palindrome: " + isPalindrome("racecar"));
        System.out.println("6. Is 'A man, a plan, a canal: Panama' palindrome: " + 
                          isPalindromeIgnoreCase("A man, a plan, a canal: Panama"));
        System.out.println("7. Longest palindrome in 'babad': " + longestPalindrome("babad"));
    }

    private static void testAnagramProblems() {
        System.out.println("\n--- Anagram Problems ---");
        
        System.out.println("8. Are 'listen' and 'silent' anagrams: " + areAnagrams("listen", "silent"));
        
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("9. Group anagrams: " + groupAnagrams(words));
    }

    private static void testSubstringProblems() {
        System.out.println("\n--- Substring Problems ---");
        
        System.out.println("10. Longest substring without repeating in 'abcabcbb': " + 
                          lengthOfLongestSubstring("abcabcbb"));
        System.out.println("11. Longest common substring of 'ABCDGH' and 'ACDGHR': " + 
                          longestCommonSubstring("ABCDGH", "ACDGHR"));
        System.out.println("12. All substrings of 'abc': " + getAllSubstrings("abc"));
    }

    private static void testAdvancedStringProblems() {
        System.out.println("\n--- Advanced String Problems ---");
        
        System.out.println("13. String to integer '42': " + stringToInteger("42"));
        System.out.println("14. Valid parentheses '()[]{}': " + isValidParentheses("()[]{}"));
        System.out.println("15. Minimum window substring: " + minWindow("ADOBECODEBANC", "ABC"));
    }
} 