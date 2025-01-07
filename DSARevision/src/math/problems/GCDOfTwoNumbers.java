package math.problems;

public class GCDOfTwoNumbers {

    public static void main(String[] args) {
        int a = 12;
        int b = 70;
        System.out.println("The GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

// Here's a short explanation of the GCD algorithm used in your code:

// 1. **Base Case**: If `b` is 0, the GCD is `a`.
// 2. **Recursive Case**: Otherwise, recursively call the `gcd` function with `b` and the remainder of `a` divided by `b` (i.e., `a % b`).

// ### Example:
// - To find GCD of 12 and 70:
//   - `gcd(12, 70)` becomes `gcd(70, 12)` (since 70 % 12 = 10)
//   - `gcd(70, 12)` becomes `gcd(12, 10)` (since 12 % 10 = 2)
//   - `gcd(12, 10)` becomes `gcd(10, 2)` (since 10 % 2 = 0)
//   - `gcd(10, 2)` returns `2` because `b` is 0.

// Thus, the GCD of 12 and 70 is 2.