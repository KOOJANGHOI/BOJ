

import java.util.Scanner;

public class Q13699 {
	static long[] dp;
	static long dy(int n) {
		if(dp[n] != 0)
			return dp[n];
		long res = 0;
		for(int i = 0 ; i < n ; i++) {
			res += dy(i)*dy(n-i-1);
		}
		dp[n] = res;
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.close();
		dp = new long[36];
		dp[0] = 1;
		System.out.println(dy(N));
	}
}
