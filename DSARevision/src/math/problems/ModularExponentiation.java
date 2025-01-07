package math.problems;

//Modular Exponentiation
//Problem: Calculate (a^b)%c.
//Logic: Use the method of exponentiation by squaring to efficiently calculate the power modulo a number.
//Algorithm:
//1.Initialize: Set result = 1.
//2.Reduce Base: Set a = a % c.
//3. Loop through Exponent:
//While b > 0:
//If b is odd, multiply result with a and take modulo c.
//Divide b by 2.
//Square a and take modulo c.
//4. Return Result: result.

public class ModularExponentiation {

 public static void main(String[] args) {

     int base = 2;
     int exponent = 5;
     int modulus = 13;
     int result = modularExponentiation(base, exponent, modulus);
     System.out.println(result);

 }

 public static int modularExponentiation(long  base, long exponent, int modulus) {
     long result = 1;
     base = base % modulus; //Reduce base to a value between 0 and modulus-1
     while(exponent > 0) {
         if((exponent & 1) == 1) { //If exponent is odd
             result = (result * base) % modulus;
         }
         exponent = exponent >> 1; // Divide exponent by 2
         base = (base * base) % modulus; //Square base
     }
     return (int) result;
 }

}






