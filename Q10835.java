import java.util.Scanner;

public class Q10835 {
	int N, ans = 0;
	int[][] arr, dp;

	int calc(int x, int y) {
		if (x == N || y == N)
			return 0;
		if (dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = Math.max(calc(x + 1, y), calc(x + 1, y + 1));
		if (arr[x][0] > arr[y][1])
			dp[x][y] = Math.max(dp[x][y], calc(x, y + 1) + arr[y][1]);
		return dp[x][y];
	}

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N + 1][2];
		dp = new int[N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			arr[i][0] = scan.nextInt();
		}
		for (int i = 0; i < N; i++) {
			arr[i][1] = scan.nextInt();
		}
		scan.close();
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(calc(0, 0));
	}

	public static void main(String[] args) {
		new Q10835().solve();
	}
}