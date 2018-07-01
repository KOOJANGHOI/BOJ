

import java.util.Scanner;

public class Q9461 {
	long[] dp;

	long dynamic(int num) {
		if(dp[num]!=-1)
			return dp[num];
		dp[num]=dynamic(num-1)+dynamic(num-5);
		return dp[num];
	}

	void solve() {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		long[] ans = new long[tc + 1];
		dp = new long[101];
		for (int i = 1; i <= 100; i++) {
			dp[i] = -1;
		}
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for (int i = 1; i <= tc; i++) {
			int N = scan.nextInt();
			ans[i]=dynamic(N);

		}
		scan.close();
		for (int i = 1; i <= tc; i++) {
			System.out.println(ans[i]);
		}

	}

	public static void main(String[] args) {
		new Q9461().solve();
	}
}
