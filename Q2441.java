

import java.util.Scanner;

public class Q2441 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i = 0 ; i < N ; i++) {
			for(int j = i ; j > 0 ; j--) {
				System.out.print(" ");
			}
			for(int j = N ; j > i ; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
