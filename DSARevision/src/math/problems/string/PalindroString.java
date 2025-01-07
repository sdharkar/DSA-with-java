package math.problems.string;

//Problem: Check if a string is a palindrome using recursion.

//logic: 
//Base case: If the string is empty or has only one character, return true.
//Recursive case: Check if the first and last characters are equal and recursively check the substring between them.

//Algorithm:
//1. Define a function isPalindrome(str).
//2. If the length of the string is less than or equal to 1, return true.
//3. If the first and last characters are not equal, return false.
//4. Otherwise, return isPalindrome(str.substring(1, str.length() - 1)).

public class PalindroString {

	public static void main(String[] args) {

		String str = "malayalam";
		System.out.println("String "+ str + " is palindrome: "+isPalindrome(str));
		
		String str2 = "colour";
		System.out.println("String "+ str2 + " is palindrome: "+isPalindrome(str2));

	}

	
	public static boolean isPalindrome(String str) {
		if(str.length() <= 1) return true;
		if(str.charAt(0) != str.charAt(str.length() - 1)) return false;
		return isPalindrome(str.substring(1, str.length() - 1));
	}
}
