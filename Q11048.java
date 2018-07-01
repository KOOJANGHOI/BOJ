import java.util.Scanner;

public class Q11048 {
	void solve() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] arr = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = scan.nextInt();
				dp[i][j] = 0;
			}
		}
		scan.close();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = arr[i][j] + Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
			}
		}
		System.out.println(dp[n][m]);
	}

	public static void main(String[] args) {
		new Q11048().solve();
	}
}
