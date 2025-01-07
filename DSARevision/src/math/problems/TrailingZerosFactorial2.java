package math.problems;


public class TrailingZerosFactorial2 {

    public static void main(String[] args) {
        int n = 12;
        int rest = 0;
        for(int i = 5; i <= n; i = i*5){//5, 25, 125 etc most efficient way to solve trailing zeros in factorial
            rest = rest + n/i;
        }
        System.out.println("The number of trailing zeros in the factorial of {n} is: " + rest);
    }

}
