package math.problems.modular_arithmetic;

// Problem: Solve ax≡ b (mod m) for x.

import java.util.Scanner;


// Logic: Use the Extended Euclidean Algorithm to find the modular inverse.

// Algorithm:
// 1. Extended GCD:
// Recursively apply the Euclidean algorithm to find the GCD of a and m.
// Return the coefficients that satisfy Bézout's identity: a⋅x+b⋅y=m
// 2. Check:
// If the GCD is 1, the inverse exists.
// Return x as the modular inverse.
// If the GCD is not 1, the inverse does not exist.
// Return -1.

// Time Complexity: O(log m)

public class ModularArithmetic2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of a: ");
        int a = sc.nextInt();
        System.out.print("Enter value of b: ");
        int b = sc.nextInt();
        System.out.print("Enter value of m: ");
        int m = sc.nextInt();
        solveCongruence(a, b, m);
        
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static int modInverse(int a, int m){
        int m0 = m, t, q;
        int x0 = 0, x1 = 1;
        if(m == 1) return 0;
        while(a > 1){
            q = a/m;
            t = m;
            m = a % m;
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t; 
        }

        if(x1 < 0) x1 += m0;
        return x1;
    }

    public static void solveCongruence(int a, int b, int m){
        int d = gcd(a, m);
        if(b % d != 0){
            System.out.println("No solution");
            return;
        }
        int a1 = a / d;
        int b1 = b / d;
        int m1 = m / d;
        int x = modInverse(a1, m1);
        System.out.println((b1 * x) % m1);
    }



}
