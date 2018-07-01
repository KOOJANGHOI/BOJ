

import java.util.Scanner;

public class Q1475 {

	static int findNum(String str) {
		int[] arr = new int[10];
		for (int i = 0; i < str.length(); i++) {
			arr[(int)str.charAt(i)-48]++;
		}
		int max = 0;
		for (int i = 0; i < 10; i++) {
			if(i !=6 && i != 9) {
				max = Math.max(max, arr[i]);
			}
		}
		return Math.max(max,(arr[6]+arr[9])/2);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String N = scan.nextLine();
		scan.close();
		System.out.println(findNum(N));
	}
}
