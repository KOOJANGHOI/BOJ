
import java.util.Scanner;

public class Q11051 {
	int[][] dp;

	void comb(int n, int k) {
		if (n == k || k == 0) {
			dp[n][k] = 1;
		} else {
			dp[n][k] = (dp[n - 1][k - 1] % 10007 + dp[n - 1][k] % 10007) % 10007;
		}
	}

	void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		scan.close();
		dp = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				if (i >= j)
					comb(i, j);
			}
		}
		System.out.println(dp[N][K]);

	}

	public static void main(String[] args) {
		new Q11051().solve();
	}
}
