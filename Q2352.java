import java.util.Scanner;

// fail...
class Q2352 {
	int N, gmax = 0;
	int[] num;
	int[][] dp;

	int calc(int i, int j) {
		if (dp[i][j] != -1)
			return dp[i][j];
		int si = Math.min(i, num[i]);
		int fi = Math.max(i, num[i]);
		int sj = Math.min(j, num[j]);
		int fj = Math.max(j, num[j]);

		if ((sj - si) * (fj - fi) <= 0) {
			dp[i][j] = 0;
		} else {
			for (int k = i + 1; k < j; k++) {
				dp[i][j] = Math.max(dp[i][j], calc(i, k) + calc(k + 1, j) + 1);
			}
		}
		gmax = Math.max(gmax, dp[i][j]);
		return dp[i][j];
	}

	void work() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		num = new int[N + 1];
		dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = scan.nextInt();
		}
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				dp[i][j] = -1;
			}
		}
		scan.close();
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				calc(i, j);
			}
		}
		System.out.println(gmax);
	}

	public static void main(String a[]) {
		new Q2352().work();
	}
}