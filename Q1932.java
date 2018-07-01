

import java.util.Scanner;

public class Q1932 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] arr = new int[N][N+1];
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 1 ; j <= i+1 ; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		scan.close();
		for(int i = 1 ; i < N ; i++) {
			for(int j = 1 ; j <= i+1 ; j++) {
				arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);		
			}
		}
		for(int j = 1 ; j <= N ; j++) {
			max = Math.max(max, arr[N-1][j]);
		}
		System.out.println(max);
	}
}