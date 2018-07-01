
import java.util.Scanner;

public class Q1965 {
	int N, ans = 0;
	int[] arr, dp;

	void LIS(int idx) {
		boolean chk = false;
		int max = 0;
		for (int i = idx + 1; i < N; i++) {
			if (arr[i] > arr[idx]) {
				chk = true;
				max = Math.max(max, dp[i]);
			}
		}
		if (!chk) {
			dp[idx] = 1;
		} else {
			dp[idx] = max + 1;
		}
		ans = Math.max(ans, dp[idx]);
	}

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		dp[N - 1] = 1;
		for (int i = N - 2; i >= 0; i--) {
			LIS(i);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new Q1965().solve();
	}
}
