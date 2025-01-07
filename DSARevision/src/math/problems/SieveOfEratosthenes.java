package math.problems;


import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 30; // Specify the range up to which you want to find primes
        boolean[] primes = sieveOfEratosthenes(n);
        
        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
    
    // Function to perform the Sieve of Eratosthenes
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Initialize all entries as true
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime numbers

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                // Mark all multiples of p from p^2 to n as false
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        return isPrime;
    }
}


//Algorithum
// 1. Create a list of integers from 2 to n.
// 2. Start with the first prime number, 2.
// 3. Mark all multiples of 2 (greater than 2) as non-prime.
// 4. Move to the next number in the list that is not marked and repeat the process.
// 5.Continue until you have processed each number up to n.



// Here's an explanation of the Sieve of Eratosthenes algorithm:

// 1. **Initialize**: Create a boolean array `isPrime` of size `n+1` and set all entries to `true`. Set `isPrime[0]` and `isPrime[1]` to `false`.
// 2. **Mark Non-Primes**: For each number `p` starting from 2, if `isPrime[p]` is `true`, mark all multiples of `p` from `p^2` to `n` as `false`.
// 3. **Output Primes**: After processing, all indices with `true` in the `isPrime` array are prime numbers.
