
import java.util.Scanner;

public class Q2096 {
	int N, maxans, minans;
	int[][] arr, maxdp, mindp;

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N + 1][3];
		maxdp = new int[N + 1][3];
		mindp = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = scan.nextInt();
				if (i == 1) {
					maxdp[i][j] = arr[i][j];
					mindp[i][j] = arr[i][j];
				}
			}
		}
		scan.close();
		if (N > 1) {
			for (int i = 2; i <= N; i++) {
				maxdp[i][0] = arr[i][0] + Math.max(maxdp[i - 1][0], maxdp[i - 1][1]);
				maxdp[i][1] = arr[i][1] + Math.max(maxdp[i - 1][0], Math.max(maxdp[i - 1][1], maxdp[i - 1][2]));
				maxdp[i][2] = arr[i][2] + Math.max(maxdp[i - 1][1], maxdp[i - 1][2]);

				mindp[i][0] = arr[i][0] + Math.min(mindp[i - 1][0], mindp[i - 1][1]);
				mindp[i][1] = arr[i][1] + Math.min(mindp[i - 1][0], Math.min(mindp[i - 1][1], mindp[i - 1][2]));
				mindp[i][2] = arr[i][2] + Math.min(mindp[i - 1][1], mindp[i - 1][2]);
				if (i == N) {
					maxans = Math.max(maxdp[N][0], Math.max(maxdp[N][1], maxdp[N][2]));
					minans = Math.min(mindp[N][0], Math.min(mindp[N][1], mindp[N][2]));
				}
			}
		} else {
			maxans = Math.max(maxdp[1][0], Math.max(maxdp[1][1], maxdp[1][2]));
			minans = Math.min(mindp[1][0], Math.min(mindp[1][1], mindp[1][2]));
		}
		System.out.println(maxans + " " + minans);
	}

	public static void main(String[] args) {
		new Q2096().solve();
	}
}
