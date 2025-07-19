package string;

import java.util.*;

/**
 * Quick Reference for String Interview Questions
 * 
 * This file contains the most commonly asked string problems
 * with concise solutions for quick review before interviews.
 */
public class StringQuickReference {

    public static void main(String[] args) {
        System.out.println("=== String Interview Quick Reference ===\n");
        
        // Test all quick reference methods
        testQuickReference();
    }

    // ==================== MOST COMMON INTERVIEW QUESTIONS ====================

    /**
     * 1. Reverse String (Most Common)
     * Asked by: Google, Amazon, Microsoft, Apple
     */
    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) return str;
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * 2. Check Palindrome (Very Common)
     * Asked by: Facebook, Google, Amazon
     */
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }

    /**
     * 3. Check Anagrams (Common)
     * Asked by: Amazon, Google, Microsoft
     */
    public static boolean areAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        
        int[] freq = new int[26]; // Assuming lowercase letters
        for (char c : s1.toCharArray()) freq[c - 'a']++;
        for (char c : s2.toCharArray()) {
            if (--freq[c - 'a'] < 0) return false;
        }
        return true;
    }

    /**
     * 4. First Non-Repeating Character (Common)
     * Asked by: Amazon, Google, Microsoft
     */
    public static char firstNonRepeating(String str) {
        int[] freq = new int[256];
        for (char c : str.toCharArray()) freq[c]++;
        for (char c : str.toCharArray()) {
            if (freq[c] == 1) return c;
        }
        return '\0';
    }

    /**
     * 5. Longest Substring Without Repeating (Very Common)
     * Asked by: Google, Amazon, Microsoft, Apple
     */
    public static int longestSubstringWithoutRepeating(String str) {
        if (str == null || str.length() == 0) return 0;
        
        Set<Character> set = new HashSet<>();
        int maxLen = 0, left = 0, right = 0;
        
        while (right < str.length()) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right++));
                maxLen = Math.max(maxLen, right - left);
            } else {
                set.remove(str.charAt(left++));
            }
        }
        return maxLen;
    }

    /**
     * 6. Valid Parentheses (Common)
     * Asked by: Google, Amazon, Microsoft
     */
    public static boolean validParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 7. String to Integer (Common)
     * Asked by: Amazon, Google, Microsoft
     */
    public static int stringToInt(String str) {
        if (str == null || str.trim().isEmpty()) return 0;
        
        str = str.trim();
        int sign = 1, i = 0;
        long result = 0;
        
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = str.charAt(0) == '-' ? -1 : 1;
            i = 1;
        }
        
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i) - '0');
            if (sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && result > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        
        return (int) (sign * result);
    }

    /**
     * 8. Group Anagrams (Common)
     * Asked by: Amazon, Google, Microsoft
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(groups.values());
    }

    /**
     * 9. Longest Palindromic Substring (Common)
     * Asked by: Amazon, Google, Microsoft
     */
    public static String longestPalindrome(String str) {
        if (str == null || str.length() < 2) return str;
        
        int start = 0, maxLen = 1;
        
        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCenter(str, i, i);
            int len2 = expandAroundCenter(str, i, i + 1);
            
            int maxLenCurr = Math.max(len1, len2);
            if (maxLenCurr > maxLen) {
                start = i - (maxLenCurr - 1) / 2;
                maxLen = maxLenCurr;
            }
        }
        
        return str.substring(start, start + maxLen);
    }
    
    private static int expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 10. Minimum Window Substring (Hard but Common)
     * Asked by: Google, Amazon, Microsoft
     */
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        
        Map<Character, Integer> targetFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();
        
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

    // ==================== QUICK REFERENCE METHODS ====================

    /**
     * Count Character Frequency (Quick Method)
     */
    public static Map<Character, Integer> countChars(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }

    /**
     * Check if String Contains Only Digits
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    /**
     * Remove Duplicates from String
     */
    public static String removeDuplicates(String str) {
        if (str == null) return null;
        Set<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Check if String is Rotation of Another
     */
    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }

    // ==================== TESTING ====================

    private static void testQuickReference() {
        System.out.println("1. Reverse 'hello': " + reverseString("hello"));
        System.out.println("2. Is 'racecar' palindrome: " + isPalindrome("racecar"));
        System.out.println("3. Are 'listen' and 'silent' anagrams: " + areAnagrams("listen", "silent"));
        System.out.println("4. First non-repeating in 'leetcode': " + firstNonRepeating("leetcode"));
        System.out.println("5. Longest substring without repeating in 'abcabcbb': " + longestSubstringWithoutRepeating("abcabcbb"));
        System.out.println("6. Valid parentheses '()[]{}': " + validParentheses("()[]{}"));
        System.out.println("7. String to int '42': " + stringToInt("42"));
        System.out.println("8. Group anagrams: " + groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println("9. Longest palindrome in 'babad': " + longestPalindrome("babad"));
        System.out.println("10. Min window: " + minWindow("ADOBECODEBANC", "ABC"));
        
        System.out.println("\n--- Quick Methods ---");
        System.out.println("Character frequency 'hello': " + countChars("hello"));
        System.out.println("Is '123' numeric: " + isNumeric("123"));
        System.out.println("Remove duplicates from 'hello': " + removeDuplicates("hello"));
        System.out.println("Is 'erbottlewat' rotation of 'waterbottle': " + isRotation("erbottlewat", "waterbottle"));
    }
} 