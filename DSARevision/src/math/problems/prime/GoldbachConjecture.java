package math.problems.prime;

//problem: Check if a number can be expressed as the sum of two prime numbers (Goldbach’s Conjecture).

//logic: 
//Step 1: Generate all prime numbers up to n using Sieve of Eratosthenes.
//Step 2: Check pairs of prime numbers to see if they add up to n.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class GoldbachConjecture {

    public static void main(String[] args) {

        int n = 123;
        System.out.println(isGoldbachConjecture(n));

    }

    public static boolean isGoldbachConjecture(int n) {
        // Step 1: Generate all prime numbers up to n using Sieve of Eratosthenes
        boolean[] isPrime = sieveOfEratosthenes(n);
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(isPrime[1]){
                primes.add(i);
            }
        }

        // Step 2: Check pairs of prime numbers
        for(int prime : primes){
            if(prime > n/2) break;
            if(isPrime[n-prime]){
                System.out.println(n + " = " + prime + " + " + (n - prime));
                return true;
            }            
        }

        return false;
    }

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
