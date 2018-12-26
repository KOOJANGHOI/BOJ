import java.util.Scanner;

class Q2482 {
	int N, K, mod = 1000000003;
	int[][] dp;

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		scan.close();
		dp = new int[1001][1001];
		dp[0][0]=dp[1][0]=dp[1][1]=1;
		for(int i = 2 ; i <= N ; i++) {
			dp[i][0]=1;
			for(int j = 1 ; j <= i ; j++) {
				dp[i][j] = (dp[i-2][j-1]+dp[i-1][j])%mod;
			}
		}
		System.out.println((dp[N-3][K-1]+dp[N-1][K])%mod);
	}

	public static void main(String a[]) {
		new Q2482().solve();
	}
}