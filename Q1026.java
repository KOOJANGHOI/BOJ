

import java.util.Arrays;
import java.util.Scanner;

public class Q1026 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long[] arra = new long[N];
		long[] arrb = new long[N];
		long res = 0;
		for(int i = 0 ; i < N ; i++) {
			arra[i] = scan.nextInt();
			
		}
		for(int i = 0 ; i < N ; i++) {
			arrb[i] = scan.nextInt();
		}
		scan.close();
		Arrays.sort(arra);
		Arrays.sort(arrb);
		for(int i = 0 ; i < N ; i++) {
			res += arra[i]*arrb[N-1-i];
		}
		System.out.println(res);
	}
}
