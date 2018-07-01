import java.util.Scanner;

public class Q2294 {
	int n, k;
	int[] arr, dp;

	void dynamic(int num) {
		if (dp[num] != -1)
			return;
		int min = k + 1;
		for (int i = 1; i <= n; i++) {
			if (num - arr[i] >= 1)
				min = Math.min(min, dp[num - arr[i]]);
		}
		dp[num] = 1 + min;
	}

	void solve() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		arr = new int[n + 1];
		dp = new int[100001];
		for (int i = 0; i <= k; i++) {
			dp[i] = -1;
		}
		for (int i = 1; i <= n; i++) {
			arr[i] = scan.nextInt();
			dp[arr[i]] = 1;
		}
		scan.close();
		for(int i = 1 ; i <= k ; i++) {
			dynamic(i);
		}
		if (dp[k] > k) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
	}

	public static void main(String[] args) {
		new Q2294().solve();
	}
}
