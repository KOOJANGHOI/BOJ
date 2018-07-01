import java.util.Scanner;

public class Q1495 {
	int N, S, M;
	int[] V;
	int[][] dp;

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		S = scan.nextInt();
		M = scan.nextInt();
		V = new int[N + 1];
		dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			V[i] = scan.nextInt();
		}
		scan.close();
		dp[0][S] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (dp[i - 1][j] == 1) {
					if (j + V[i] >= 0 && j + V[i] <= M)
						dp[i][j + V[i]] = 1;
					if (j - V[i] >= 0 && j - V[i] <= M)
						dp[i][j - V[i]] = 1;
				}
			}
		}
		int ans = -1;
		for (int i = 0; i <= M; i++) {
			if (dp[N][i] == 1) {
				ans = Math.max(ans, i);
			}
		}
		System.out.println(ans);

	}

	public static void main(String[] args) {
		new Q1495().solve();
	}
}