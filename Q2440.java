

import java.util.Scanner;

public class Q2440 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i = N ; i > 0 ; i--) {
			for(int j = i ; j >= 1 ; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
