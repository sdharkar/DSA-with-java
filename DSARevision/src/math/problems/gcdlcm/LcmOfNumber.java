package math.problems.gcdlcm;

//Problem: Find the LCM (Least Common Multiple) of two numbers.

//Logic: 
//1. Calculate the GCD (Greatest Common Divisor) of the two numbers.
//2. The LCM is the product of the two numbers divided by the GCD.

//Algorithm:
//1. Define a function gcd(a, b) that returns the GCD of a and b.
//2. Define a function lcm(a, b) that returns the LCM of a and b.
//3. Call the lcm function with the two numbers as arguments and return the result.


public class LcmOfNumber {

    public static void main(String[] args) {

        int a = 3;
        int b = 14;
        System.out.println("The LCM of " + a + " and " + b + " is: " + findLcm(a, b));

    }

    public static int findLcm(int a, int b){
        return (a * b) / gcd(a, b);
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}
