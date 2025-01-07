package math.problems;

//Problem: Calculate the factorial of a number n.
//Logic:
//Base Case: n = 0 or n = 1, return 1.
//Recursive Case: n = n * (n-1).

//Algorithm:
//1. Define a function factorial(n).
//2. If n is less than or equal to 1, return 1.
//3. Otherwise, return n * factorial(n-1).

public class RecursionFactorialOfNumber {

 public static void main(String[] args) {

     System.out.println(factorial(5));

 }

 public static int factorial(int n){
     if(n <= 1) return 1;
     return n * factorial(n-1);
 }

}
