

import java.util.Scanner;

public class Q1654 {
	static long[] len;
	static long N, max = 0;

	static void bsearch(long lo, long hi) {
		while (lo <= hi) {
			long mid = (lo + hi) / 2;
			long cnt = 0;
			for (int i = 0; i < len.length; i++) {
				cnt += len[i] / mid;
			}
			if (cnt >= N) {
				max = Math.max(max, mid);
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();
		N = scan.nextInt();
		len = new long[K];
		long sum = 0;
		for (int i = 0; i < K; i++) {
			len[i] = scan.nextInt();
			sum += len[i];
		}
		scan.close();
		int s = (int) (sum / N);
		bsearch(1, s);
		System.out.println(max);
	}
}
