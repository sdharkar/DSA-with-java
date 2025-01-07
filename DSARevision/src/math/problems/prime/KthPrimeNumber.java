package math.problems.prime;

// Problem: Find the kth prime number.
// logic: 
// Base case: If n is less than or equal to 1, return false.	
// Recursive case: If n is divisible by any number from 2 to the square root of n, return false.
// Otherwise, return true.

// Algorithm:
// 1. Define a function isPrime(n).
// 2. If n is less than or equal to 1, return false.
// 3. Otherwise, check if n is divisible by any number from 2 to the square root of n.
// 4. If it is divisible, return false.
// 5. Otherwise, return true.

public class KthPrimeNumber {

	public static void main(String[] args) {
		int k = 5;
		System.out.println(kthPrime(k));

	}

	public static int kthPrime(int k) {
		int count = 0;
		int num = 2;
		while (count < k) {
			if (isPrime(num)) {
				count++;
			}
			num++;
		}
		return num -1;
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
