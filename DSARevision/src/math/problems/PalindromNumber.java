package math.problems;

public class PalindromNumber {

    public static void main(String[] args) {
        int n = 121;
        int rev = 0;
        int temp = n;
        while(n > 0){
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n /10;
        }
        if(temp == rev){
            System.out.println(temp + "The number is palindrom");
        }else{
            System.out.println(temp + "The number is not palindrom");
        }
    }

}
