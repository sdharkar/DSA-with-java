package math.problems.prime;

// problem: Count the number of numbers with exactly two distinct prime factors in a given range.

// Algorithm and Logic
// Generate Primes:
// Use the Sieve of Eratosthenes to generate all prime numbers up to the square root of the upper limit of the range.
// Check Products:
// Iterate through pairs of these prime numbers.
// Check if the product of each pair falls within the given range.
// Count such products.

// Detailed Steps:
// Sieve of Eratosthenes:
// Initialize a boolean array isPrime to mark non-prime numbers.
// Mark multiples of each prime starting from 2.
// Count Numbers with Exactly Two Distinct Prime Factors:
// Use nested loops to multiply pairs of primes.
// Check if the product is within the range.
// Count the products.


import java.util.ArrayList;
import java.util.List;

public class CountNumbersithTwoDistinctPrimeFactorsInRange {

    public static void main(String[] args) {
        int lower = 10;
        int upper = 100;
        int count = countNumbersWithTwoDistinctPrimeFactors(lower, upper);
        System.out.println("Count of numbers with exactly two distinct prime factors between " + lower + " and " + upper + ": " + count);
    }

    public static int countNumbersWithTwoDistinctPrimeFactors(int lower, int upper) {
        // Generate all prime numbers up to the square root of the upper limit
        int limit = (int) Math.sqrt(upper);
        List<Integer> primes = sieveOfEratosthenes(limit);

        int count = 0;

        // Check all pairs of prime numbers
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                int product = primes.get(i) * primes.get(j);
                if (product >= lower && product <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        // Create a boolean array to mark whether each number from 0 to n is prime.
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;  // Initially assume all numbers are prime.
        }

        // Step 1: Apply the Sieve of Eratosthenes algorithm.
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {  // If p is prime, mark its multiples as non-prime.
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;  // Mark i as non-prime.
                }
            }
        }

        // Step 2: Collect and return all prime numbers from 2 to n.
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);  // Add prime numbers to the list.
            }
        }
        return primes;  // Return the list of prime numbers.
    }
}
