package math.problems.prime;

// Problem: Find the prime factors of a given number.

// Logic: 
// Step 1: Divide the number by 2 until it is not divisible by 2.
// Step 2: Divide the number by odd numbers until it is not divisible by them.
// Step 3: If the number is greater than 2, it is a prime factor.

// Algorithm:
// 1. Divide the number by 2 until it is not divisible by 2.
// 2. Divide the number by odd numbers until it is not divisible by them.
// 3. If the number is greater than 2, it is a prime factor.

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public static void main(String[] args) {

        int n = 315;
        System.out.println(primeFactors(n));

    }
        


    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        //step1: divide by 2
         while(n % 2==0){
            factors.add(2);
            n = n/2;
         }

         //step2: divide by odd numbers
         for(int i = 3; i*i <= n; i+=2){
            while(n % i == 0){
                factors.add(i);
                n = n/i;
            }
         }
        //step3: if n is greater than 2
         if(n >2){
            factors.add(n);
         }

        return factors;
    }
}
