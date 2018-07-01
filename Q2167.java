

import java.util.Scanner;

public class Q2167 {
	void solve() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] arr = new int[301][301];
		int[][] dp = new int[301][301];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		for (int i = 0; i <= 300; i++) {
			for (int j = 0; j <= 300; j++) {
				dp[i][j] = 0;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}
		int k = scan.nextInt();
		int[] ans = new int[k];
		for (int t = 0; t < k; t++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();
			ans[t] = dp[x][y] - dp[x][j - 1] - dp[i - 1][y] + dp[i - 1][j - 1];
		}
		scan.close();
		for (int t = 0; t < k; t++) {
			System.out.println(ans[t]);
		}
	}

	public static void main(String[] args) {
		new Q2167().solve();
	}
}
