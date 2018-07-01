
import java.util.Scanner;

public class Q11060 {
	int N;
	int[] arr, dp;

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
			dp[i] = 1001;
		}
		scan.close();
		dp[0] = dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (arr[i - j] >= j) {
					dp[i] = Math.min(dp[i], dp[i - j] + 1);
				}
			}
		}
		if (dp[N] == 1001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
	}

	public static void main(String[] args) {
		new Q11060().solve();
	}
}