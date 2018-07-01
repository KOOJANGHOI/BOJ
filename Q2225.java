import java.util.Scanner;

public class Q2225 {

	void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		scan.close();
		long[][] dp = new long[N + 1][K + 1];
		for (int k = 1; k <= K; k++) {
			dp[0][k] = 1;
			dp[1][k] = k;
		}
		for (int n = 1; n <= N; n++) {
			dp[n][1] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= K; j++) {
				for (int k = 0; k <= i; k++) {
					dp[i][j] += dp[k][j - 1] % 1000000000;
				}
				dp[i][j] %= 1000000000;
			}
		}
		System.out.println(dp[N][K]);
	}

	public static void main(String[] args) {
		new Q2225().solve();
	}
}
