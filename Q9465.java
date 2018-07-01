

import java.util.Scanner;

public class Q9465 {
	int[][] dp;

	void solve() {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		int[] ans = new int[tc + 1];
		for (int i = 1; i <= tc; i++) {
			int N = scan.nextInt();
			int[][] arr = new int[N + 1][3];
			dp = new int[N + 1][3];
			for (int j = 1; j < 3; j++) {
				for (int k = 1; k <= N; k++) {
					arr[k][j] = scan.nextInt();
				}
			}
			dp[1][0] = 0;
			dp[1][1] = arr[1][1];
			dp[1][2] = arr[1][2];
			if (N > 1) {
				for (int j = 2; j <= N; j++) {
					dp[j][0] = Math.max(dp[j - 1][1], dp[j - 1][2]);
					dp[j][1] = arr[j][1] + Math.max(dp[j - 1][0], dp[j - 1][2]);
					dp[j][2] = arr[j][2] + Math.max(dp[j - 1][0], dp[j - 1][1]);
				}
			}
			ans[i] = Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]));
		}
		scan.close();
		for(int i = 1 ; i <= tc ; i++) {
			System.out.println(ans[i]);
		}

	}

	public static void main(String[] args) {
		new Q9465().solve();
	}
}
