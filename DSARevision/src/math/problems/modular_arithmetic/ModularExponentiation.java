package math.problems.modular_arithmetic;

import java.util.Scanner;

// Problem: Compute  (a^b)% m  for very large  a  and  b  (Modular Exponentiation).

// Logic: Use the method of exponentiation by squaring to efficiently calculate the power modulo a number.

// Algorithm:
// 1. Initialize: Set result = 1.
// 2. Reduce Base: Set a = a % m.
// 3. Loop through Exponent:
// While b > 0:
// If b is odd, multiply result with a and take modulo m.
// Divide b by 2.
// Square a and take modulo m.
// 4. Return Result: result.

public class ModularExponentiation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter value of a: ");
		long a = sc.nextInt();
		System.out.print("Enter value of b: ");
		long b = sc.nextInt();
		System.out.print("Enter value of m: ");
		long m = sc.nextInt();

		long result = modularExponentiation(a, b, m);
		System.out.println(result);
	}

	public static long modularExponentiation(long a, long b, long m){
		long result = 1;
		a = a % m;
		while(b > 0) {
			if(b % 2 == 1) {
				result = (result * a) % m;
			}
			b = b >> 1;
			a = (a * a)% m;
		}
		return result;
	}

}
