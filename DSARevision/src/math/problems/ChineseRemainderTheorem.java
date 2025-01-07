package math.problems;

//Chinese Remainder Theorem
//Problem: Solve the system of simultaneous congruences.
//Logic: Use the Chinese Remainder Theorem to find a solution.
//Algorithm:
//Input:
//Given a set of congruences: 𝑥≡𝑎1mod  𝑛1, 𝑥≡𝑎2mod  𝑛2, ..., 𝑥≡𝑎𝑘mod  𝑛𝑘.
//Calculate Product: 𝑁=𝑛1∗𝑛2∗...∗𝑛𝑘.
//Find Partial Product: 𝑁𝑖=𝑁/𝑛𝑖.
//Find Modular Inverse: Find the modular inverse of 𝑁𝑦𝑖 such that 𝑁𝑖∗𝑦𝑖≡1mod  𝑛𝑖.
//Compute Result: 𝑥=(𝑎1∗𝑁1∗𝑦1+𝑎2∗𝑁2∗𝑦2+...+𝑎𝑘∗𝑁𝑘∗𝑦𝑘)mod  𝑁.

public class ChineseRemainderTheorem {

 public static void main(String[] args) {

     int[] num = {3, 4, 5};
     int[] rem = {2, 3, 1};
     System.out.println("The value of x is: " + chineseRemainderTheorem(num, rem));

 }

 public static int chineseRemainderTheorem(int[] num, int[] rem) {
     int prod = 1;
     for(int n : num) prod *= n;
     int sum = 0;
     for(int i = 0; i < num.length; i++){
         int p = prod / num[i];
         sum += rem[i] * modInverse(p, num[i]) * p;
     }
     return sum % prod;
 }

 private static int modInverse(int a, int m) {
     for(int x = 1; x < m; x++){
         if((a * x) % m == 1) return x;
     }
     return 1;
 }

}





