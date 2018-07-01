

import java.util.Scanner;

public class Q23 {
	private static Scanner sc;
	public static void main(String args[]) throws Exception {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = sc.nextInt();
					arr[i][j] += arr[i][j - 1];
				}
			}
			int ans = 0;
			for(int i = 1 ; i <= N ; i++) {
				for(int j = i ; j <= N ; j++) {
					int temp = 0;
					for(int r = 1 ; r <= N ; r++) {
						temp = Math.max(temp, 0) + arr[r][j] - arr[r][i-1];
						ans = Math.max(ans, temp);
					}
				}
			}
			System.out.println("Case #" + (test_case + 1));
			System.out.println(ans);
		}
	}
}
