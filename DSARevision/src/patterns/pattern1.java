package patterns;

//Problem: Print the following patterns using nested loops:

public class pattern1 {
	
	public static void main(String[] args) {

		System.out.println("Pattern 1");
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}


		System.out.println("Pattern 2");
		for(int k = 1; k<=4; k++) {
			for(int l = 4; l>=k; l--) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("Pattern 3");
		for(int m = 1; m<=5; m++){
			for(int n = 1; n<=m; n++){
				System.out.print(n);
			}
			System.out.println();
		}

		System.out.println("Pattern 4");
		for(int o = 5; o>=0;o--){
			for(int p =1; p<=o;p++){
				System.out.print(p);
			}
			System.out.println();
		}

		System.out.println("Pattern 5");
		for(int q = 1; q<=5;q++){
			for(int r =1; r<=q;r++){
				System.out.print(q);
			}
			System.out.println();
		}

		System.out.println("Pattern 6");
		for(int s = 5; s>=0;s--){
			for(int t =1; t<=s;t++){
				System.out.print(s);
			}
			System.out.println();
		}

		System.out.println("Pattern 7");
		for(int u = 1; u<=5; u++){
			for(int v = 5; v>=u; v--){
				System.out.print(" ");
			}
			for(int w = 1; w<=u; w++){
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("Pattern 8");
		for(int u = 5; u>=0; u--){
			for(int v = 5; v>=u; v--){
				System.out.print(" ");
			}
			for(int w = 1; w<=u; w++){
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("Pattern 9");
		for(int x = 1; x<=5; x++){
			for(int y = 1; y<=x; y++){
				System.out.print("*");
			}
			for(int z = 5; z>=x; z--){
				System.out.print(" ");
			}
			for(int z = 1; z<=x; z++){
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("Pattern 10");
		for(int x = 5; x>=0; x--){
			for(int y = 1; y<=x; y++){
				System.out.print("*");
			}
			for(int z = 5; z>=x; z--){
				System.out.print(" ");
			}
			for(int z = 1; z<=x; z++){
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("Pattern 11");
		for(int x = 1; x<=5; x++){
			for(int y = 1; y<=x; y++){
				System.out.print(y);
			}
			for(int z = 5; z>=x; z--){
				System.out.print(" ");
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			System.out.println();
		}

		System.out.println("Pattern 12");
		for(int u = 1; u<=5; u++){
			for(int v = 5; v>=u; v--){
				System.out.print(" ");
			}
			for(int w = 1; w<=u; w++){
				System.out.print("*");
			}
			for(int y = 1; y<=u; y++){
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("Pattern 13");
		for(int u = 5; u>=0; u--){
			for(int v = 5; v>=u; v--){
				System.out.print(" ");
			}
			for(int w = 1; w<=u; w++){
				System.out.print("*");
			}
			for(int y = 1; y<=u; y++){
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("Pattern 14");
		for(int x = 1; x<=5; x++){
			for(int y = 1; y<=x; y++){
				System.out.print("*");
			}
			for(int z = 5; z>=x; z--){
				System.out.print(" ");
			}
			for(int z = 1; z<=x; z++){
				System.out.print("*");
			}
			for(int z = 1; z<=x; z++){
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("Pattern 15");
		for(int x = 5; x>=0; x--){
			for(int y = 1; y<=x; y++){
				System.out.print("*");
			}
			for(int z = 5; z>=x; z--){
				System.out.print(" ");
			}
			for(int z = 1; z<=x; z++){
				System.out.print("*");
			}
			for(int z = 1; z<=x; z++){
				System.out.print("*");
			}
			System.out.println();
		}	

		System.out.println("Pattern 16");
		for(int x = 1; x<=5; x++){
			for(int y = 1; y<=x; y++){
				System.out.print(y);
			}
			for(int z = 5; z>=x; z--){
				System.out.print(" ");
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			System.out.println();
		}

		System.out.println("Pattern 17");
		for(int x = 5; x>=0; x--){
			for(int y = 1; y<=x; y++){
				System.out.print(y);
			}
			for(int z = 5; z>=x; z--){
				System.out.print(" ");
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			System.out.println();
		}

		System.out.println("Pattern 18");
		for(int x = 1; x<=5; x++){
			for(int y = 1; y<=x; y++){
				System.out.print(y);
			}
			for(int z = 5; z>=x; z--){
				System.out.print(" ");
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			System.out.println();
		}

		System.out.println("Pattern 19");
		for(int x = 5; x>=0; x--){
			for(int y = 1; y<=x; y++){
				System.out.print(y);
			}
			for(int z = 5; z>=x; z--){
				System.out.print(" ");
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			for(int z = 1; z<=x; z++){
				System.out.print(z);
			}
			System.out.println();
		}













		
		
	}

}
