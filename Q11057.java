import java.util.Scanner;

public class Q11057 {
	void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.close();
		int[][] dp = new int[10][1001];
		for (int i = 0; i < 10; i++) {
			dp[i][1] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					dp[j][i] += dp[k][i - 1] % 10007;
				}
			}
		}
		int ret = 0;
		for (int i = 0; i < 10; i++) {
			ret += dp[i][N];
		}
		System.out.println(ret % 10007);
	}

	public static void main(String[] args) {
		new Q11057().solve();
	}
}
