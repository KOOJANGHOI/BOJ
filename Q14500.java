

import java.util.Scanner;

public class Q14500 {
	private static int N,M;
	private static int[][] arr,res;
	private static Scanner scan;
	
	public static void solve(int x , int y) {
		res[x][y] = Math.max(Math.max(Math.max(termo_1(x,y), termo_2(x,y)), Math.max(termo_3(x,y), termo_4(x,y))),termo_5(x,y));
	}
	public static int ans() {
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				max = Math.max(max, res[i][j]);
			}
		}
		return max;
	}
	public static int termo_1(int x , int y) {
		int i = x+3;
		int j = y+3;
		int fir = arr[i][j] + arr[i-1][j-1] + arr[i-1][j] + arr[i][j-1];
		int sec = arr[i][j] + arr[i-1][j+1] + arr[i-1][j] + arr[i][j+1];
		int thi = arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i][j-1];
		int fou = arr[i][j] + arr[i+1][j+1] + arr[i+1][j] + arr[i][j+1];
		return Math.max(Math.max(fir, sec), Math.max(thi, fou));
	}
	public static int termo_2(int x , int y) {
		int i = x+3;
		int j = y+3;
		int fir = arr[i][j] + arr[i-1][j] + arr[i-2][j] + arr[i-3][j];
		int sec = arr[i][j] + arr[i][j-1] + arr[i][j-2] + arr[i][j-3];
		int thi = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
		int fou = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
		return Math.max(Math.max(fir, sec), Math.max(thi, fou));
	}
	public static int termo_3(int x , int y) {
		int i = x+3;
		int j = y+3;
		int fir = arr[i][j] + arr[i-1][j] + arr[i][j+1] + arr[i+1][j+1];
		int sec = arr[i][j] + arr[i-1][j] + arr[i][j-1] + arr[i+1][j-1];
		int thi = arr[i][j] + arr[i+1][j] + arr[i][j-1] + arr[i-1][j-1];
		int fou = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i-1][j+1];
		int fif = arr[i][j] + arr[i][j-1] + arr[i-1][j] + arr[i-1][j+1];
		int six = arr[i][j] + arr[i][j-1] + arr[i+1][j] + arr[i+1][j+1];
		int sev = arr[i][j] + arr[i][j+1] + arr[i-1][j] + arr[i-1][j-1];
		int eig = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j-1];
		return Math.max(Math.max(Math.max(fir, sec), Math.max(thi, fou)), Math.max(Math.max(fif, six), Math.max(sev, eig)));
	}
	public static int termo_4(int x , int y) {
		int i = x+3;
		int j = y+3;
		int fir = arr[i][j] + arr[i-1][j] + arr[i-1][j+1] + arr[i-1][j+2];
		int sec = arr[i][j] + arr[i-1][j] + arr[i-1][j-1] + arr[i-1][j-2];
		int thi = arr[i][j] + arr[i+1][j] + arr[i+1][j-1] + arr[i+1][j-2];
		int fou = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
		int fif = arr[i][j] + arr[i][j-1] + arr[i-1][j-1] + arr[i-2][j-1];
		int six = arr[i][j] + arr[i][j-1] + arr[i+1][j-1] + arr[i+2][j-1];
		int sev = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-2][j+1];
		int eig = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
		return Math.max(Math.max(Math.max(fir, sec), Math.max(thi, fou)), Math.max(Math.max(fif, six), Math.max(sev, eig))); 
	}
	public static int termo_5(int x , int y) {
		int i = x+3;
		int j = y+3;
		int fir = arr[i][j] + arr[i-1][j] + arr[i][j-1] + arr[i][j+1];
		int sec = arr[i][j] + arr[i+1][j] + arr[i][j-1] + arr[i][j+1];
		int thi = arr[i][j] + arr[i][j-1] + arr[i-1][j] + arr[i+1][j];
		int fou = arr[i][j] + arr[i][j+1] + arr[i-1][j] + arr[i+1][j];
		return Math.max(Math.max(fir, sec), Math.max(thi, fou));
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[N+6][M+6];
		res = new int[N][M];
		for(int i = 0 ; i < N+6 ; i++) {
			for(int j = 0 ; j < M+6 ; j++) {
				arr[i][j] = 0;
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				res[i][j] = 0;
				arr[i+3][j+3] = scan.nextInt();
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				solve(i,j);
			}
		}
		System.out.println(ans());			
	}
}
