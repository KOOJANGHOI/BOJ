

import java.util.Scanner;

public class Q10844 {
	private static Scanner scan;
	private static int N;
	private static long[][] cnt;

	public static void process(int d) {
		for(int i = 1 ; i <= 8 ; i++) {
			cnt[i][d] = (cnt[i-1][d-1] + cnt[i+1][d-1])%1000000000; // 나누기를 안해줘서 틀렸었다.
		}
		cnt[0][d] = cnt[1][d-1];
		cnt[9][d] = cnt[8][d-1];
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		cnt = new long[10][N+1];
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			cnt[i][1] = 1;
		}
		for(int i = 2 ; i <= N ; i++) {
			process(i);
		}

		for(int i = 1 ; i < 10 ; i++) {
			sum += cnt[i][N];
		}
		
		System.out.println(sum%1000000000);
	}
}
