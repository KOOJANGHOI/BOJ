import java.util.Scanner;

class Q11049 {
	int[][] dp;
	int[] p;
	int max = 987654321;

	int matmul(int i, int j) {
		if (dp[i][j] != max)
			return dp[i][j];
		for (int k = i; k < j; k++) {
			int temp = matmul(i, k) + matmul(k + 1, j) + p[i - 1] * p[k] * p[j];
			if (dp[i][j] > temp)
				dp[i][j] = temp;
		}
		return dp[i][j];
	}

	void work() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		p = new int[N + 1];
		for (int i = 0; i < N; i++) {
			p[i] = scan.nextInt();
			p[N] = scan.nextInt();
		}
		scan.close();

		dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = (i == j) ? 0 : max;
			}
		}

		for (int k = 1; k < N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (j - i == k) {
						matmul(i, j);
					}
				}
			}
		}

		System.out.println(dp[1][N]);

	}

	public static void main(String a[]) {
		new Q11049().work();
	}
}