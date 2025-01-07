package math.problems;


//General Approach to Solve Problems Using Recursion
//1. Identify the Base Case:
//Find the simplest possible sub-problem that can be solved trivially.
//This is where the recursion stops.
//2. Define the Recursive Case:
//Break the problem into smaller sub-problems of the same type.
//Ensure that each recursive call moves towards the base case.
//3. Combine Results:
//Combine the results of the recursive calls to solve the original problem.
//4. Ensure Termination:
//Ensure that each recursive call eventually reaches the base case to avoid infinite recursion.

//problem: Check if an array is sorted using recursion.

//logic:
//Base case: If the array is empty or has only one element, return true.
//Recursive case: Check if the current element is less than or equal to the next element. If it is, continue recursively checking the rest of the array. If it is not, return false.

//algorithm:      
//1. Define a function isSorted(arr, start, end).
//2. If start is greater than or equal to end, return true.
//3. If arr[start] is greater than arr[start+1], return false.
//4. Otherwise, return isSorted(arr, start+1, end).

public class RecursionGeneral {

 public static void main(String[] args) {

     int[] arr = {1, 2, 3, 4, 5};
     System.out.println(isSorted(arr, 0, arr.length - 1));

 }

 public static boolean isSorted(int[] arr, int start, int end) {
     if (start >= end) {
         return true;
     }
     if (arr[start] > arr[start + 1]) {
         return false;
     }
     return isSorted(arr, start + 1, end);
 }

}
