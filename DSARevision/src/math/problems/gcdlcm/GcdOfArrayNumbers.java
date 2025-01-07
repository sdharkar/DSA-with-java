package math.problems.gcdlcm;

// problem: Compute the GCD of an array of numbers.

// logic:
// Base case: If the array is empty, return 0.
// Recursive case: Find the GCD of the first two numbers in the array and recursively find the GCD of the rest of the array.

// algorithm:
// 1. Define a function gcd(arr).
// 2. If the array is empty, return 0.
// 3. Otherwise, find the GCD of the first two numbers in the array and recursively find the GCD of the rest of the array.

public class GcdOfArrayNumbers {

    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 5};
        System.out.println("GCD of array is: " + findGCD(arr));

    }

    public static int findGCD(int[] arr){
        int result = arr[0];
        for(int i = 1; i<= arr.length -1;i++){
            result = gcd(result, arr[i]);
            if(result == 1){
                break;
            };
        }
        return result;
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b , a % b);
    }

}
