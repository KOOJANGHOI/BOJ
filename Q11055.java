
import java.util.Scanner;

public class Q11055 {
	int N;
	int[] arr, dp;

	void process(int idx) {
		boolean chk = false;
		int max = -1;
		for (int i = idx + 1; i <= N; i++) {
			if (arr[i] > arr[idx]) {
				chk = true;
				max = Math.max(max, dp[i]);
			}
			if (!chk) {
				dp[idx] = arr[idx];
			} else {
				dp[idx] = arr[idx] + max;
			}
		}
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
		dp[N] = arr[N];
		for (int i = N - 1; i > 0; i--) {
			process(i);
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new Q11055().solve();
	}
}
