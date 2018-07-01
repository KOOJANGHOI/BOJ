

import java.util.Scanner;

public class Q2438 {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		for (int i = 1 ; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
