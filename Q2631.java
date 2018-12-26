import java.util.Scanner;

class Q2631 {

	void work() {
		Scanner scan = new Scanner(System.in);
		int gmax = 0;
		int N = scan.nextInt();
		int[] num = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = scan.nextInt();
		}
		scan.close();
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			boolean chk = false;
			int max = 0;
			for (int j = 1; j < i; j++) {
				if (num[j] < num[i]) {
					chk = true;
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = chk ? max + 1 : 1;
			gmax = Math.max(gmax, dp[i]);
		}
		System.out.println(N-gmax);	
	}

	public static void main(String a[]) {
		new Q2631().work();
	}
}