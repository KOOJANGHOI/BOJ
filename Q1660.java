import java.util.Scanner;

public class Q1660 {
	int N;
	int[] dp, t;

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		scan.close();
		dp = new int[300001];
		t = new int[1000];
		for (int i = 0; i <= 300000; i++) {
			dp[i] = 300001;
		}
		for (int i = 1; i <= 200; i++) {
			t[i] = ((i + 1) * (i + 1) * (i + 1) - (i + 1)) / 6;
			if (t[i] > 300000)
				break;
			dp[t[i]] = 1;
		}
		for (int i = 1; i <= N; i++) {
			if (dp[i] != 300001)
				continue;
			for (int j = 1; j <= 200; j++) {
				if (i <= t[j])
					break;
				dp[i] = Math.min(dp[i], dp[i - t[j]] + 1);
			}
		}
		System.out.println(dp[N]);

	}

	public static void main(String[] args) {
		new Q1660().solve();
	}
}