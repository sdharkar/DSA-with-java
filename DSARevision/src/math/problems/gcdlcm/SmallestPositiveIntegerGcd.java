package math.problems.gcdlcm;

import java.util.Scanner;

//Problem : Find the smallest positive integer  x  such that  GCD(x, n) = k .

//Logic:
//1. Find the smallest positive integer  x  such that  GCD(x, n) = k .
//2. Return  x  modulo  n  (the result of the division of x by n).      

//Algorithm:
//1. Define a function gcd(x, n) that returns the GCD of x and n.
//2. Define a function smallestPositiveIntegerGcd(n, k) that returns the smallest positive integer  x  such that  GCD(x, n) = k .
//3. Call the smallestPositiveIntegerGcd function with the two numbers as arguments and return the result.

public class SmallestPositiveIntegerGcd {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.print("Enter a number: ");
        int k = sc.nextInt();
        System.out.println("The smallest positive integer  x  such that  GCD(x, n) = k is: " + smallestPositiveIntegerGcd(n, k));

    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static int smallestPositiveIntegerGcd(int n, int k){
        for(int i = 0; i<= n; i++){
            if(gcd(i,n) == k){
                return i % n;
            }
        }
        return -1;
    }



}
