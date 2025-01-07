package math.problems;

public class Factorial {

    public static void main(String[] args) {
        int n = 12;
        int fact = 1;
        for(int i = 0; i < n; i++){
            fact = fact * (i + 1);
        }    
        System.out.println("The factorial of {n} is: " + fact);
    }
}
