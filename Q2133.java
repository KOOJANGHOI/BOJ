import java.util.Scanner;

public class Q2133 {

	void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.close();
		int[] dp = new int[31];
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			if (i % 2 != 0) {
				dp[i] = 0;
			} else {
				dp[i] = dp[i - 2] * 3;
				for (int j = 4; j <= i; j += 2) {
					dp[i] += dp[i - j] * 2;
				}
			}
		}
		System.out.println(dp[N]);
	}

	public static void main(String[] args) {
		new Q2133().solve();
	}
}
