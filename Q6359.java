
import java.util.Scanner;

public class Q6359 {
	void solve() {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		int[] ans = new int[tc + 1];
		for (int i = 1; i <= tc; i++) {
			int N = scan.nextInt();
			int[] arr = new int[N + 1];
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (k % j == 0) {
						arr[k] = Math.abs(1 - arr[k]);
					}
				}
			}
			for (int k = 1; k <= N; k++) {
				ans[i] += arr[k];
			}
		}
		for (int i = 1; i <= tc; i++) {
			System.out.println(ans[i]);
		}
		scan.close();
	}

	public static void main(String[] args) {
		new Q6359().solve();
	}
}
