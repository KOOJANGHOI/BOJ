

import java.util.Scanner;

public class Q1010_2 {
	static int[][] dp;
	
	static int dynamic(int a , int b) {
		if(dp[a][b] != -1)
			return dp[a][b];
		dp[a][b] = 0;
		for(int i = a-1 ; i < b ; i++) {
			dp[a][b] += dynamic(a-1,i);
		}
		return dp[a][b];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		dp = new int[30][30];
		for(int i = 1 ; i < 30 ; i++) {
			for(int j = i ; j < 30 ; j++) {
				if(i==1) {
					dp[i][j] = j;
				} else {
					dp[i][j] = -1;
				}
			}
		}
		dp[1][1] = 1;
		dp[1][2] = 2;
		for (int i = 0; i < T; i++) {
			int N = scan.nextInt();
			int M = scan.nextInt();
			System.out.println(dynamic(N,M));
		}
		scan.close();
	}
}
