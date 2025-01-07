package math.problems;

//Modular Inverse
//Problem: Find x such that (𝑎∗𝑥)%𝑚=1

//Logic: Use the Extended Euclidean Algorithm to find the modular inverse.

//Algorithm:

//1. Extended GCD:
//Recursively apply the Euclidean algorithm to find the GCD of a and m.
//Return the coefficients that satisfy Bézout's identity: 𝑎𝑥+𝑚𝑦=𝑔𝑐𝑑(𝑎,𝑚)
//2. Check:
//If the GCD is 1, the inverse exists.
//Return x % m as the modular inverse.
//If the GCD is not 1, the inverse does not exist.
//Return -1.


public class ModularInverse {

 public static void main(String[] args) {

     int a = 3, m = 11;
     int inverse = modularInverse(a, m);
     System.out.println("The modular inverse of " + a + " modulo " + m + " is: " + inverse);
 }

 public static int modularInverse(int a, int m) {
     int[] result = extendedEuclideanAlgorithm(a, m);
             int gcd = result[0], x = result[1];
             if(gcd != 1) return -1;
             return (x % m + m) % m;
         }
     
         private static int[] extendedEuclideanAlgorithm(int a, int b) {
             if(b == 0) return new int[]{a, 1, 0};
             int[] result = extendedEuclideanAlgorithm(b, a % b);
             int x = result[2];
             int y = result[1] - (a / b) * result[2];
             return new int[]{result[0], x, y};
         }

}

