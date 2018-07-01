

import java.util.Scanner;

public class Q2960 {

	private static Scanner scan;

	static int process(int[][] arr, int n, int k) {
		int cnt = 0;
		while (cnt != n - 1) {
			int index = 0;
			int val = 0;
			for (int i = 2; i <= n; i++) {
				if (arr[i][0] != 0) {
					arr[i][1] = ++cnt;
					index = i;
					val = arr[index][0];
					arr[index][0] = 0;
					break;
				}
			}
			for (int i = index + 1; i <= n; i++) {
				if (arr[i][0] % val == 0 && arr[i][0] != 0) {
					arr[i][0] = 0;
					arr[i][1] = ++cnt;
				}
			}
		}
		int ans = 0;
		for (int i = 2; i <= n; i++) {
			if (arr[i][1] == k) {
				ans = i;
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		int[][] arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			arr[i][0] = i;
		}
		System.out.println(process(arr, N, K));
	}
}
