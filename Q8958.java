

import java.util.Scanner;

public class Q8958 {

	private static Scanner scan;

	public static int foundNum(String str) {
		int sum = 0;
		int cnt;
		for (int i = 0; i < str.length(); i++) {
			cnt = 0;
			for(int j = i ; j >= 0 ; j--) {
				if(str.charAt(j) == 'X') {
					break;
				} else {
					cnt++;
				}
			}
			sum += cnt;
		}
		return sum;
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N+1];
		for (int i = 0; i <= N; i++) {
			String str = scan.nextLine();
			arr[i] = foundNum(str);
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(arr[i]);
		}
	}
}
