

import java.util.Scanner;

public class Q1010 {
	static int cnt = 0;
	public static void combination(int[] num, int index, int n, int r, int target) {
		if (r == 0)
			cnt++;
		else if (target == n)
			return;
		else {
			num[index] = target;
			combination(num, index + 1, n, r - 1, target + 1);
			combination(num, index, n, r, target + 1);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i = 0 ; i < T ; i++) {
			cnt = 0;
			int N = scan.nextInt();
			int M = scan.nextInt();
			int[] arr = new int[M];
			for(int j = 0 ; j < M ; j++) {
				arr[j] = j+1;
			}
			combination(arr, 0, M, N, 0);
			System.out.println(cnt);
		}
		scan.close();
	}
}
