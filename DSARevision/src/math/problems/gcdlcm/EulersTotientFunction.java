package math.problems.gcdlcm;

// Problem: Count numbers less than  n  that are relatively prime to  n  (Euler’s Totient Function).

import java.util.Scanner;

// Logic: 
// Base Case: If n is less than or equal to 1, return false.	
// Recursive Case: If n is divisible by any number from 2 to the square root of n, return false.
// Otherwise, return true.

// Algorithm:
// 1. Define a function isPrime(n).
// 2. If n is less than or equal to 1, return false.
// 3. Otherwise, check if n is divisible by any number from 2 to the square root of n.
// 4. If it is divisible, return false.
// 5. Otherwise, return true.

public class EulersTotientFunction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("The count of numbers less than " + n + " that are relatively prime to " + n + " is: " + eulersTotientFunction(n));

    }

    /**
     * This function calculates Euler's totient function for a given number.
     * The function calculates the count of numbers less than n that are
     * relatively prime to n.
     * @param n the number to calculate Euler's totient function for
     * @return the count of numbers less than n that are relatively prime to n
     */
    public static int eulersTotientFunction(int n){
        int result = n;
        // Iterate through all numbers from 2 to the square root of n
        for(int i = 2; i * i <= n; i++){
            // If n is divisible by i
            if(n % i == 0){
                // Keep dividing n by i until it is no longer divisible
                while(n % i == 0){
                    n = n / i;
                }
                // Subtract the result divided by i from the result
                // This is because all multiples of i are not relatively prime
                result -= result / i;
            }
        }
        // If n is still greater than 1, it is a prime number
        // Subtract the result divided by n from the result
        // This is because n is not relatively prime to n
        if(n > 1){
            result -= result / n;
        }
        return result;
    }

}
