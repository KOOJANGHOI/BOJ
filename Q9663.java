

import java.util.Scanner;

public class Q9663 {
	private static Scanner scan;
	static int[][] arr;
	static int res = 0, N;

	public static void findNum(int[][] arr, int k, int cnt) {
		if (cnt == N+1) {
			if(calc(arr)==1) {
				res++;
			}
			return;
		}
	
		int x = k / N;
		int y = k % N;
		arr[x][y] = 1;
		
		for (int i = 0 ; i < N * N; i++) {
			int nx = i / N;
			int ny = i % N;
			if (nx == x && arr[nx][ny] != 1)
				arr[nx][ny] = 2;
			if (ny == y && arr[nx][ny] != 1)
				arr[nx][ny] = 2;
			for (int j = 1; j < N; j++) {
				if(arr[nx][ny] == 1)
					continue;
				if (vaild(x-j,y-j) && nx == (x - j) && ny == (y - j))
					arr[nx][ny] = 2;
				if (vaild(x-j,y+j) && nx == (x - j) && ny == (y + j))
					arr[nx][ny] = 2;
				if (vaild(x+j,y-j) && nx == (x + j) && ny == (y - j))
					arr[nx][ny] = 2;
				if (vaild(x+j,y+j) && nx == (x + j) && ny == (y + j))
					arr[nx][ny] = 2;
			}
		}
		
		if(calc(arr)==1) {
			res++;
			return;
		}
		
		for (int i = k + 1; i < N * N; i++) {
			int nx = i / N;
			int ny = i % N;
			if (arr[nx][ny] == 0) {
				int[][] copy = new int[N][N];
				copymap(arr, copy);
				findNum(copy, i, cnt + 1);
			}
		}

	}

	public static void copymap(int[][] parent, int[][] child) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				child[i][j] = parent[i][j];
			}
		}
	}

	public static boolean vaild(int i ,int j) {
		if(i < 0 || i > N || j < 0 || j > N)
			return false;
		return true;
	}
	
	public static int calc(int[][] arr) {
		int chk = 0;
		for (int i = 0 ; i < N * N; i++) {
			int nx = i / N;
			int ny = i % N;
			if(arr[nx][ny] == 1) {
				chk++;
			}
		}
		if(chk == N) {
			return 1;
		} else {
			return 0;
		}	
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < N * N; i++) {
			findNum(arr, i, 1);
			arr = new int[N][N];
		}
		System.out.println(res);
	}
}
