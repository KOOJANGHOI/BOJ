

import java.util.Scanner;

public class Q2193 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long[][] dp = new long[91][2];
		if (N == 1) {
			System.out.println(1);
		} else {
			dp[1][0] = 1;
			dp[1][1] = 1;
			for (int len = 2; len <= N; len++) {
				dp[len][0] = dp[len - 1][0] + dp[len - 1][1];
				dp[len][1] = dp[len - 1][0];
			}
			System.out.println(dp[N][1]);
		}
	}
}
