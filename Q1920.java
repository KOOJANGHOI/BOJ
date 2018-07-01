

import java.util.Arrays;
import java.util.Scanner;

public class Q1920 {

	private static int bsearch(int[] arr, int val, int lo, int hi) {
		if (lo > hi)
			return -1;
		int mid = (lo + hi) / 2;
		if (val == arr[mid])
			return mid;
		if (arr[mid] < val)
			return bsearch(arr, val, mid + 1, hi);
		else
			return bsearch(arr, val, lo, mid - 1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		int M = scan.nextInt();
		int[] num = new int[M];
		int[] res = new int[M];
		for (int i = 0; i < M; i++) {
			num[i] = scan.nextInt();
		}
		scan.close();
		for (int i = 0; i < M; i++) {
			res[i] = bsearch(arr, num[i], 0 , N-1);
		}
		for (int i = 0; i < M; i++) {
			System.out.println(res[i]== -1 ? 0 : 1);
		}
	}
}
