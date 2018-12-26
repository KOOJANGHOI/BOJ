import java.util.Scanner;

class Q9084 {

	void work() {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		int[] answer = new int[tc];
		for (int i = 0; i < tc; i++) {
			int n = scan.nextInt();
			int[] coin = new int[n];
			int[] dp = new int[10001];
			for (int j = 0; j < n; j++) {
				coin[j] = scan.nextInt();
			}
			int target = scan.nextInt();
			dp[0] = 1;
			for (int j = 0; j < n; j++) {
				for (int k = coin[j]; k <= target; k++) {
					dp[k] += dp[k - coin[j]];
				}
			}
			answer[i] = dp[target];
		}
		scan.close();
		for (int i = 0; i < tc; i++) {
			System.out.println(answer[i]);
		}
	}

	public static void main(String a[]) {
		new Q9084().work();
	}
}