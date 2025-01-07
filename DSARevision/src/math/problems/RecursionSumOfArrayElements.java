package math.problems;


//problem: Calculate the sum of all elements in an array using recursion.

//logic: 
//Base case: If the array is empty, return 0.
//Recursive case: Add the first element to the sum of the rest of the array.

//algorithm:
//1. Define a function sumArray(arr, n).
//2. If n is 0, return 0.
//3. Otherwise, return arr[n-1] + sumArray(arr, n-1).

public class RecursionSumOfArrayElements {

 public static void main(String[] args) {

     int[] arr = {1, 2, 3, 4, 5};
     System.out.println("Sum of array elements is: " + sumArray(arr, arr.length));
 }

 public static int sumArray(int[] arr, int n) {
     if(n == 0) return 0;
     return arr[n -1] + sumArray(arr, n - 1);
 }

}
