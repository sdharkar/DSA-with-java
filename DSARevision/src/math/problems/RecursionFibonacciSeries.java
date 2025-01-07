package math.problems;

//Problem: Calculate the nth Fibonacci number using recursion.

//Logic:
//Base Case: F(0) = 0, F(1) = 1.
//Recursive Case: F(n) = F(n-1) + F(n-2).

//Algorithm:
//1. Define a function fibonacci(n).
//2. If n is 0 or 1, return 0 or 1.
//3. Otherwise, return fibonacci(n-1) + fibonacci(n-2).

public class RecursionFibonacciSeries {

 public static void main(String[] args) {
     int n = 10;
     System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
 }

 public static int fibonacci(int n) {
     if (n == 0) {
         return 0;
     
     }if (n == 1) {
         return 1;
     
     }return fibonacci(n - 1) + fibonacci(n - 2);
 }
}
