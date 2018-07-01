

import java.util.Scanner;

public class Q11659 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] arr = new int[N + 1];
		int[] sum = new int[N + 1];
		int[] res = new int[M];
		for (int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
		}
		sum[1] = arr[1];
		for(int i = 2 ; i <= N ; i++) {
			sum[i] += sum[i-1]+arr[i];
		}
		for (int i = 0; i < M; i++) {
			int s = scan.nextInt();
			int d = scan.nextInt();
			res[i] = sum[d]-sum[s-1];
		}
		scan.close();
		for (int i = 0; i < M; i++) {
			System.out.println(res[i]);
		}
	}
}
