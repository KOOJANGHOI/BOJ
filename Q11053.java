

import java.util.Scanner;

public class Q11053 {
	static int N, max = 0;
	static int[] arr, dp;
	static Scanner scan;

	static void calc(int index) {
		int temp = 0;
		for (int i = index + 1; i <= N; i++) {
			if (arr[i] > arr[index]) {
				temp = Math.max(temp, dp[i]);
			}
		}
		if (temp == 0) {
			dp[index] = 1;
		} else {
			dp[index] = temp + 1;
		}
		max = Math.max(max, dp[index]);
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[1001];
		dp = new int[1001];
		for (int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
		}
		dp[N] = 1;
		if (N != 1) {
			for (int i = N - 1; i >= 1; i--) {
				calc(i);
			}
			System.out.println(max);
		} else {
			System.out.println(1);
		}

	}
}
