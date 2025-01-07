package math.problems;

//Problem: Find the survivor of a Josephus problem. (recursion)

//Logic: Use the Josephus problem to find the survivor.

//Algorithm:
//1. Define a function josephus(n, k).
//2. If n == 1, return 0.
//3. Otherwise, return (josephus(n-1, k) + k) % n.	

import java.util.Scanner;

public class JosephusProblem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of people: ");
		int n = sc.nextInt();
		System.out.print("Enter step count: ");
		int k = sc.nextInt();
		int survivor = josephus(n,k) + 1; // Adding 1 to convert to 1-based index
		System.out.println("The survivor is at position: " + survivor);
		
	}
	
	public static int josephus(int n, int k) {
		if(n == 1) {
			return 0;
		}
		return (josephus(n-1,k) + k) % n; // Josephus problem
	}

}
