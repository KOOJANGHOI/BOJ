import java.util.Scanner;

public class Q5557 {
	int N, ans;
	int[] arr;
	long[][] dp;

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N];
		dp = new long[N][21];
		for (int i = 1; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		ans = scan.nextInt();
		scan.close();
		dp[1][arr[1]] = 1;
		for (int i = 2; i < N; i++) {
			for (int j = 0; j <= 20; j++) {
				if (dp[i - 1][j] > 0) {
					if (j + arr[i] >= 0 && j + arr[i] <= 20)
						dp[i][j + arr[i]] += dp[i - 1][j];
					if (j - arr[i] >= 0 && j - arr[i] <= 20)
						dp[i][j - arr[i]] += dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N - 1][ans]);
	}

	public static void main(String[] args) {
		new Q5557().solve();
	}
}