

import java.util.Scanner;

public class Q2293 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		int[] num = new int[101];
		int[] dp = new int[10001];
		for(int i = 0 ; i < N ; i++) {
			num[i] = scan.nextInt();
		}
		dp[0]=1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = num[i] ; j <= K ; j++) {
				dp[j] += dp[j-num[i]];
			}
		}
		System.out.println(dp[K]);
		/*
		for(int i = 0 ; i <= K ; i++) {
			System.out.println("["+i+": "+dp[i]+"]");
		}
		*/
	}
}
