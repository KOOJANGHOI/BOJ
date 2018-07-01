

import java.util.Scanner;

public class Q1912 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		sum[1] = arr[1];
		for(int i = 1 ; i <= N ; i++) {
			if(sum[i-1]>0) {
				sum[i] = sum[i-1]+arr[i];
			} else {
				sum[i] = arr[i];
			}
		}
		
		int max = sum[1];
		for(int i = 2 ; i <= N ; i++) {
			max = Math.max(max, sum[i]);
		}
		System.out.println(max);
		
	}
}
