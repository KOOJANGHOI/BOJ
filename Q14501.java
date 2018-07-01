

import java.util.Scanner;

public class Q14501 {
	private static Scanner scan;
	private static int N;
	private static int[][] arr;
	
	public static void maxp(int k) {
		if(k == N) {
			if(arr[1][k] == 1) {
				arr[0][k] = arr[2][k];
				return ;
			}
			arr[0][k] = 0;
			return ;
		}
		if(k + arr[1][k] > N+1) {
			arr[0][k] = arr[0][k+1];
			return ;
		}
		if(k + arr[1][k] == N+1) {
			if(arr[2][k] > arr[0][k+1]) {
				arr[0][k] = arr[2][k];
				return;
			}
			arr[0][k] = arr[0][k+1];
			return ;
		}
		if(arr[2][k] + arr[0][k+arr[1][k]] > arr[0][k+1]) {
			arr[0][k] = arr[2][k] + arr[0][k+arr[1][k]];
			return ;
		} else {
			arr[0][k] = arr[0][k+1];
			return ;
		}
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[3][16];
		for(int i = 1 ; i <= N ; i++) {
			arr[0][i] = 0;
			arr[1][i] = scan.nextInt();
			arr[2][i] = scan.nextInt();
		}
		for(int i = N ; i >= 1 ; i--) {
			maxp(i);
		}
		System.out.println(arr[0][1]);
	}
}
