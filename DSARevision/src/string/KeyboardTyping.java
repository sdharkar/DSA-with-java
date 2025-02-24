package string;

//asked in amazon

import java.util.Scanner;

public class KeyboardTyping {

    public static void main(String[] args) {
        System.out.println("Keyboard Typing");
        System.out.println("Enter the string: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        System.out.println(printNumber(s, n));
    }

    public static String printNumber(String s, int n) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'c') {
                result.append('2'); 
            }else if (ch >= 'd' && ch <= 'f') {
                result.append('3'); 
            }else if (ch >= 'g' && ch <= 'i') {
                result.append('4'); 
            }else if (ch >= 'j' && ch <= 'l') {
                result.append('5'); 
            }else if (ch >= 'm' && ch <= 'o') {
                result.append('6'); 
            }else if (ch >= 'p' && ch <= 's') {
                result.append('7'); 
            }else if (ch >= 't' && ch <= 'v') {
                result.append('8'); 
            }else if (ch >= 'w' && ch <= 'z') {
                result.append('9');
            }
        }

        return result.toString();
    }

}
