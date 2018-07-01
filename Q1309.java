import java.util.Scanner;

public class Q1309 {
	void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.close();
		int[][] dp = new int[N + 1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][1] % 9901 + dp[i - 1][2] % 9901) % 9901;
			dp[i][1] = (dp[i - 1][0] % 9901 + dp[i - 1][2] % 9901) % 9901;
			dp[i][2] = (dp[i - 1][0] % 9901 + dp[i - 1][1] % 9901 + dp[i - 1][2] % 9901) % 9901;
		}
		System.out.println((dp[N][0] % 9901 + dp[N][1] % 9901 + dp[N][2] % 9901) % 9901);
	}

	public static void main(String[] args) {
		new Q1309().solve();
	}
}
