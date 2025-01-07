package math.problems;


public class TrailingZerosFactorial {

    public static void main(String[] args) {
        int n = 12;
        int fact = 1;
        int count = 0;
        for(int i = 0; i < n; i++){
            fact = fact * (i + 1);
            while(fact % 10 == 0){
                count++;
                fact = fact / 10;
            }
        }
        System.out.println("The factorial of {n} is: " + fact);
        System.out.println("The number of trailing zeros in the factorial of {n} is: " + count);
    }   

}
