
import java.util.Scanner;

public class Q10164 {
	int calc(int n, int m) {
		int[][] arr = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			arr[i][0] = 1;
		}
		for (int j = 0; j <= m; j++) {
			arr[0][j] = 1;
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0)
					continue;
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		return arr[n][m];
	}

	void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int I = scan.nextInt();
		scan.close();
		int ans = 1;
		if (I != 0) {
			I -= 1;
			int x = I / M;
			int y = I % M;
			ans = calc(x, y) * calc(N - x - 1, M - y - 1);
		} else {
			ans = calc(N - 1, M - 1);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new Q10164().solve();
	}
}