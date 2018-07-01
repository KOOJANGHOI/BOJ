import java.util.Scanner;

public class Q1520 {
	int N, M;
	int[][] arr, dp;
	int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	int dfs(int x, int y) {
		if (x == 1 && y == 1) {
			return 1;
		}
		if (dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 0;
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if ((nx >= 1 && nx <= N && ny >= 1 && ny <= M) && arr[nx][ny] > arr[x][y]) {
				dp[x][y] += dfs(nx, ny);
			}

		}
		return dp[x][y];
	}

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= M; ++j) {
				arr[i][j] = scan.nextInt();
				dp[i][j] = -1;
			}
		}
		scan.close();
		System.out.println(dfs(N, M));
	}

	public static void main(String[] args) {
		new Q1520().solve();
	}
}
