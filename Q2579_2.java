

import java.util.Scanner;

public class Q2579_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int max = 0;
		int[] arr = new int[N + 1];
		int[] val = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		if(N == 1) {
			max = arr[1];
		} else if(N == 2) {
			max = arr[1] + arr[2];
		} else {
			val[1] = arr[1];
			val[2] = arr[1]+arr[2];
			val[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
			for (int i = 4; i <= N; i++) {
				val[i] = Math.max(val[i-2]+arr[i], val[i-3]+arr[i-1]+arr[i]);
			}
			max = val[N];
		}
		System.out.println(val[N]);
	}
}