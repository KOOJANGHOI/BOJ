import java.util.Scanner;

public class Q1328 {
	int N, L, R;
	long[][][] dp;

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		L = scan.nextInt();
		R = scan.nextInt();
		scan.close();
		dp = new long[N + 1][N + 1][N + 1];
		dp[1][1][1] = 1;
		for (int n = 2; n <= N; n++) {
			for (int l = 1; l <= N; l++) {
				for (int r = 1; r <= N; r++) {
					dp[n][l][r] = dp[n - 1][l - 1][r] + dp[n - 1][l][r - 1] + (n - 2) * dp[n - 1][l][r];
					dp[n][l][r] %= 1000000007;
				}
			}
		}

		System.out.println(dp[N][L][R]);
	}

	public static void main(String[] args) {
		new Q1328().solve();
	}
}