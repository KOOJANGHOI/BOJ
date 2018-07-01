

import java.util.Scanner;

public class Q11727 {
	int[] dp;

	void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.close();
		dp = new int[1001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		if (N > 2) {
			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
			}
		}
		System.out.println(dp[N]);
	}

	public static void main(String[] args) {
		new Q11727().solve();
	}
}
