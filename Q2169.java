import java.util.Scanner;

public class Q2169 {
	int N, M;
	int[][] arr, res, temp;

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[N][M];
		res = new int[N][M];
		temp = new int[2][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		scan.close();
		res[0][0] = arr[0][0];
		for (int col = 1; col < M; col++) {
			res[0][col] = res[0][col - 1] + arr[0][col];
		}
		for (int row = 1; row < N; row++) {

			// ->
			temp[0][0] = res[row - 1][0] + arr[row][0];
			for (int col = 1; col < M; col++) {
				temp[0][col] = Math.max(temp[0][col - 1], res[row - 1][col]) + arr[row][col];
			}

			// <-
			temp[1][M - 1] = res[row - 1][M - 1] + arr[row][M - 1];
			for (int col = M - 2; col >= 0; col--) {
				temp[1][col] = Math.max(temp[1][col + 1], res[row - 1][col]) + arr[row][col];
			}

			for (int col = 0; col < M; col++) {
				res[row][col] = Math.max(temp[0][col], temp[1][col]);
			}
		}
		System.out.println(res[N-1][M-1]);
	}

	public static void main(String[] args) {
		new Q2169().solve();
	}
}