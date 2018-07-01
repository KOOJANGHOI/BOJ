
import java.util.Scanner;

public class Q1890 {
	int N;
	int[][] arr;
	long[][] dp;
	int[] dx = { 0, -1 }, dy = { -1, 0 };

	long dfs(int x, int y) {
		if ((x == 1 && y - arr[1][1] == 1) || (x - arr[1][1] == 1) && y == 1)
			return 1;
		if (dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 0;
		for (int i = 1; i < x; i++) {
			if (arr[i][y] == (x - i)) {
				dp[x][y] += dfs(i, y);
			}
		}
		for (int j = 1; j < y; j++) {
			if (arr[x][j] == (y - j)) {
				dp[x][y] += dfs(x, j);
			}
		}
		return dp[x][y];
	}

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N + 1][N + 1];
		dp = new long[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = scan.nextInt();
				dp[i][j] = -1;
			}
		}
		scan.close();
		arr[N][N] = 1;
		System.out.println(dfs(N, N));
	}

	public static void main(String[] args) {
		new Q1890().solve();
	}
}
