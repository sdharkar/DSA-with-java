package math.problems;

//problem: Reverse a string using recursion.

//logic:
//Base case: If the string is empty or has only one character, return the string.
//Recursive case: Reverse the rest of the string and append the first character to the reversed string.

//algorithm:
//1. Define a function reverseString(str).
//2. If the length of the string is less than or equal to 1, return the string.
//3. Otherwise, return reverseString(str.substring(1)) + str.charAt(0).

public class RecursionReverseString {

 public static void main(String[] args) {

     String str = "Hello";
     System.out.println("The reverse of " + str + " is: " + reverseString(str));

 }

 public static String reverseString(String str){
     if(str.length() <= 1) return str;
     return reverseString(str.substring(1)) + str.charAt(0);
 }

}
