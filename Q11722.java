import java.util.Scanner;

public class Q11722 {
	int N, gmax = 1;
	int[] arr, dp;

	void process(int idx) {
		boolean chk = false;
		int max = 0;
		for (int i = idx + 1; i <= N; i++) {
			if (arr[i] < arr[idx]) {
				chk = true;
				max = Math.max(max, dp[i]);
			}
		}
		if (!chk) {
			dp[idx] = 1;
		} else {
			dp[idx] = max + 1;
		}
		gmax = Math.max(gmax, dp[idx]);
	}

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		dp[N] = 1;
		for (int i = N - 1; i > 0; i--) {
			process(i);
		}
		System.out.println(gmax);
	}

	public static void main(String[] args) {
		new Q11722().solve();
	}
}
