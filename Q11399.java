

import java.util.Arrays;
import java.util.Scanner;

public class Q11399 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		int res = 0;
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		for(int i = 1 ; i <= N ; i++) {
			sum[i] = sum[i-1] + arr[i];
			res += sum[i];
		}
		System.out.println(res);
	}
}
