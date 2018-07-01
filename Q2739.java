

import java.util.Scanner;

public class Q2739 {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i = 1 ; i < 10 ; i++) {
			System.out.println(N+" * "+i+" = "+N*i);
		}
	}
}
