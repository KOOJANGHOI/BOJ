

import java.util.Scanner;

public class Q12100_2 {
	private static int N, max = 0;
	private static int[][] bool;
	private static Scanner scan;

	// up.
	public static int[][] moveup(int[][] arr) {
		int[][] res = new int[N][N];
		res = flushup(arr);
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (res[i][j] == res[i + 1][j] && bool[i][j] == 0 && bool[i + 1][j] == 0) {
					int[][] temp = new int[N][N];
					res[i][j] *= 2;
					res[i + 1][j] = 0;
					bool[i][j] = 1;
					temp = flushup(res);
					copy(temp,res);
				}
			}
		}
		int[][] tmp = new int[N][N];
		tmp = flushup(res);
		return tmp;
	}

	// 0을 제외하고 위로 정렬.
	public static int[][] flushup(int[][] arr) {
		int[][] temp = new int[N][N];
		copy(arr,temp);
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (temp[i][j] == 0) {
					temp[i][j] = temp[i + 1][j];
					temp[i + 1][j] = 0;
				}
			}
		}
		return temp;
	}

	// down
	public static int[][] movedown(int[][] arr) {
		int[][] res = new int[N][N];
		res = flushdown(arr);
		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i > 0; i--) {
				if (res[i][j] == res[i - 1][j] && bool[i][j] == 0 && bool[i - 1][j] == 0) {
					int[][] temp = new int[N][N];
					res[i][j] *= 2;
					res[i - 1][j] = 0;
					bool[i][j] = 1;
					temp = flushdown(res);
					copy(temp,res);
				}
			}
		}
		int[][] tmp = new int[N][N];
		tmp = flushdown(res);
		return tmp;
	}

	// 0을 제외하고 아래로 정렬.
	public static int[][] flushdown(int[][] arr) {
		int[][] temp = new int[N][N];
		copy(arr,temp);
		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i > 0; i--) {
				if (temp[i][j] == 0) {
					temp[i][j] = temp[i - 1][j];
					temp[i - 1][j] = 0;
				}
			}
		}
		return temp;
	}

	// left
	public static int[][] moveleft(int[][] arr) {
		int[][] res = new int[N][N];
		res = flushleft(arr);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (res[i][j] == res[i][j + 1] && bool[i][j] == 0 && bool[i][j + 1] == 0) {
					int[][] temp = new int[N][N];
					res[i][j] *= 2;
					res[i][j + 1] = 0;
					bool[i][j] = 1;
					temp = flushleft(res);
					copy(temp,res);
				}
			}
		}
		int[][] tmp = new int[N][N];
		tmp = flushleft(res);
		return tmp;
	}

	// 0을 제외하고 왼쪽으로 정렬.
	public static int[][] flushleft(int[][] arr) {
		int[][] temp = new int[N][N];
		copy(arr,temp);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (temp[i][j] == 0) {
					temp[i][j] = temp[i][j + 1];
					temp[i][j + 1] = 0;
				}
			}
		}
		return temp;
	}

	// right
	public static int[][] moveright(int[][] arr) {
		int[][] res = new int[N][N];
		res = flushright(arr);
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j > 0; j--) {
				if (res[i][j] == res[i][j - 1] && bool[i][j] == 0 && bool[i][j - 1] == 0) {
					int[][] temp = new int[N][N];
					res[i][j] *= 2;
					res[i][j - 1] = 0;
					bool[i][j] = 1;
					temp = flushright(res);
					copy(temp,res);
				}
			}
		}
		int[][] tmp = new int[N][N];
		tmp = flushright(res);
		return tmp;
	}

	// 0을 제외하고 오른쪽으로 정렬.
	public static int[][] flushright(int[][] arr) {
		int[][] temp = new int[N][N];
		copy(arr,temp);
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j > 0; j--) {
				if (temp[i][j] == 0) {
					temp[i][j] = temp[i][j - 1];
					temp[i][j - 1] = 0;
				}
			}
		}
		return temp;
	}

	// 방문했는지 배열 초기화
	public static void flush() {
		bool = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bool[i][j] = 0;
			}
		}
	}

	static void dfs(int[][] arr, int count) {
		if (count == 5) { // 5번 탐색했으면, 최대값 계산
			calc(arr);
			return;
		}
		for (int i = 0; i < 4; i++) { // 아니면, dfs 진행.
			int[][] mapCopy = new int[N][N];
			copy(arr, mapCopy);
			dfs(move(mapCopy, i), count + 1);
		}
	}

	public static int[][] move(int[][] arr, int dir) {
		int[][] res = new int[N][N];
		switch (dir) {
		case 0: // up
			res = moveup(arr);
			break;
		case 1: // down
			res = movedown(arr);
			break;
		case 2: // left
			res = moveleft(arr);
			break;
		case 3: // right
			res = moveright(arr);
			break;
		default:
			break;
		}
		flush();
		return res;
	}

	// 최대값 계산
	public static void calc(int[][] res) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max < res[i][j]) {
					max = res[i][j];
				}
			}
		}
	}

	// 배열 복사.
	public static void copy(int[][] original, int[][] copy) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = original[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		int[][] arr = new int[N][N];
		flush();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		dfs(arr, 0);
		System.out.println(max);
	}
}
