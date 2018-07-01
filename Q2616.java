import java.util.Scanner;

public class Q2616 {
	int N, K;
	int[] arr, sum;
	int[][] dp;

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N + 1];
		sum = new int[N + 1];
		dp = new int[4][N + 1];
		arr[1] = scan.nextInt();
		sum[1] = arr[1];
		for (int i = 2; i <= N; i++) {
			arr[i] = scan.nextInt();
			sum[i] = sum[i - 1] + arr[i];
		}
		K = scan.nextInt();
		scan.close();
		for (int i = 1; i <= 3; i++) {
			for (int j = i * K; j <= N; j++) {
				if (i == 1) {
					dp[i][j] = Math.max(dp[i][j - 1], sum[j] - sum[j - K]);
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - K] + sum[j] - sum[j - K]);
				}
			}
		}
		System.out.println(dp[3][N]);

	}

	public static void main(String[] args) {
		new Q2616().solve();
	}
}