package math.problems.gcdlcm;

// Problem: Find pairs of numbers in an array whose GCD is 1 (coprime pairs).
// Logic: 
// Step 1: Generate all pairs of numbers in the array.
// Step 2: Check if the GCD of each pair is 1.
// Algorithm:
// 1. Define a function gcd(a, b) that returns the GCD of a and b.
// 2. Define a function isCoprime(a, b) that returns true if a and b are coprime.
// 3. Iterate through all pairs of numbers in the array.
// 4. Check if the GCD of each pair is 1.
// 5. If it is, print the pair.
public class GcdCoprimePairs {

    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 5};
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isCoprime(arr[i], arr[j]) == 1) {
                    System.out.println(arr[i] + " and " + arr[j] + " are coprime.");
                }
            }
        }

    }

    public static int isCoprime(int a, int b) {
        if (gcd(a, b) == 1) {
            return 1;
        }
        return 0;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
