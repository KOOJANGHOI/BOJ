

import java.util.Scanner;

public class Q2577 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		int[] arr = new int[10];
		String str = Integer.toString(A*B*C);
		for(int i = 0 ; i < str.length() ; i++) {
			arr[str.charAt(i)-48]++;
		}
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(arr[i]);
		}
	}
}