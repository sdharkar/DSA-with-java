package math.problems.gcdlcm;

// Problem: Compute the LCM (Least Common Multiple) of an array of numbers.

// Logic: 
// Base case: If the array is empty, return 0.
// Recursive case: Find the LCM of the first two numbers in the array and recursively find the LCM of the rest of the array.

// Algorithm:      
// 1. Define a function gcd(arr).
// 2. If the array is empty, return 0.
// 3. Otherwise, find the LCM of the first two numbers in the array and recursively find the LCM of the rest of the array.
// 4. Return the result.

public class LcmOfArrayNumbers {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        System.out.println("LCM of array is: " + findLcm(arr));
    }

    public static int findLcm(int[] arr) {
        int result = arr[0];
        for(int i = 0; i <= arr.length -1; i++){
            result = lcm(result, arr[i]);
            if(result == 1){
                break;
            }
        }
        return result;
    }

    public static int lcm(int a, int b){
        return (a * b)/ gcd(a,b);
    }
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
