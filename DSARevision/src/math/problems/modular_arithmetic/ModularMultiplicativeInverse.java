package math.problems.modular_arithmetic;

//Problem: Find the modular multiplicative inverse of  a  under modulus  m .

//Logic: Use the Extended Euclidean Algorithm to find the modular multiplicative inverse.

//Algorithm:
//1. Extended GCD:
//Recursively apply the Euclidean algorithm to find the GCD of a and m.
//Return the coefficients that satisfy Bézout's identity: a⋅x+b⋅y=m
//2. Check:
//If the GCD is 1, the inverse exists.
//Return x as the modular multiplicative inverse.
//If the GCD is not 1, the inverse does not exist.
//Return -1.

public class ModularMultiplicativeInverse {

	public static void main(String[] args) {
		

	}

	public static int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b, a % b);
	}

	


}
