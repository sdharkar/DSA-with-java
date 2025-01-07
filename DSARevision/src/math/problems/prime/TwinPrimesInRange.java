package math.problems.prime;

// problem: Find twin primes in a given range.

// logic: 
// Base case: If n is less than or equal to 1, return false.
// Recursive case: If n is divisible by any number from 2 to the square root of n, return false.
// Otherwise, return true.

// algo:
// 1. Define a function isPrime(n).
// 2. If n is less than or equal to 1, return false.
// 3. Otherwise, check if n is divisible by any number from 2 to the square root of n.
// 4. If it is divisible, return false.
// 5. Otherwise, return true.

public class TwinPrimesInRange {

    public static void main(String[] args) {
        int start = 2;
        int end = 30;
        for (int i = start; i <= end; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.println(i + " and " + (i + 2) + " are twin primes.");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
