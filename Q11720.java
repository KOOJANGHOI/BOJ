

import java.util.Scanner;

public class Q11720 {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		String temp = scan.nextLine();
		String str = scan.nextLine();
		int sum = 0;
		for(int i = 0 ; i < str.length() ; i++) {
			char c = str.charAt(i);
			sum += c-'0';
		}
		System.out.println(sum);
	}
}
