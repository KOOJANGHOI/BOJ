

import java.util.Scanner;
import java.math.*;

public class Q13460 {
	static int N, M, hx, hy, min = 11, cn = 0;
	static int[][] arr, tarr, darr, larr;
	private static Scanner scan;

	private static boolean checkr(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 3)
					return true;
			}
		}
		return false;
	}

	private static boolean checkb(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 4)
					return true;
			}
		}
		return false;
	}

	private static void recover() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tarr[i][j] = arr[i][j];
			}
		}
	}

	private static void copy(int[][] pre, int[][] aft) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				aft[i][j] = pre[i][j];
			}
		}
	}

	private static int[][] move(int[][] pre, int dir) {
		int[][] carr = new int[N][M];
		boolean tmp = false;
		copy(pre, carr);
		switch (dir) {
		case 0: // left
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (carr[i][j] == 3 || carr[i][j] == 4) {
						int k = j;
						int temp = carr[i][j];
						while (k > 0 && carr[i][k - 1] == 0 || carr[i][k - 1] == 2) {
							if (carr[i][k - 1] == 2 && temp == 3) {
								carr[i][k] = 0;
								carr[i][k - 1] = temp;
								tmp = true;
								carr[hx][hy] = 2;
								break;
							} else {
								carr[i][k] = 0;
								k--;
							}
						}
						if (!tmp)
							carr[i][k] = temp;
					}
				}
			}
			break;
		case 1: // right
			for (int i = 0; i < N; i++) {
				for (int j = M - 1; j >= 0; j--) {
					if (carr[i][j] == 3 || carr[i][j] == 4) {
						int k = j;
						int temp = carr[i][j];
						while (k < M - 1 && carr[i][k + 1] == 0 || carr[i][k + 1] == 2) {
							if (carr[i][k + 1] == 2) {
								carr[i][k] = 0;
								carr[i][k + 1] = temp;
								tmp = true;
								carr[hx][hy] = 2;
								break;
							} else {
								carr[i][k] = 0;
								k++;
							}
						}
						if (!tmp)
							carr[i][k] = temp;
					}
				}
			}
			break;
		case 3: // down
			for (int j = 0; j < M; j++) {
				for (int i = 0; i < N; i++) {
					if (carr[i][j] == 3 || carr[i][j] == 4) {
						int k = i;
						int temp = carr[i][j];
						while (k < N - 1 && carr[k + 1][j] == 0 || carr[k + 1][j] == 2) {
							if (carr[k + 1][j] == 2) {
								carr[k][j] = 0;
								carr[k + 1][j] = temp;
								tmp = true;
								carr[hx][hy] = 2;
								break;
							} else {
								carr[k][j] = 0;
								k++;
							}
						}
						if (!tmp)
							carr[k][j] = temp;
					}
				}
			}
			break;
		case 2: // up
			for (int j = 0; j < M; j++) {
				for (int i = N - 1; i >= 0; i--) {
					if (carr[i][j] == 3 || carr[i][j] == 4) {
						int k = i;
						int temp = carr[i][j];
						while (k > 0 && carr[k - 1][j] == 0 || carr[k - 1][j] == 2) {
							if (carr[k - 1][j] == 2) {
								carr[k][j] = 0;
								carr[k - 1][j] = temp;
								tmp = true;
								carr[hx][hy] = 2;
								break;
							} else {
								carr[k][j] = 0;
								k--;
							}
						}
						if (!tmp)
							carr[k][j] = temp;

					}
				}
			}
			break;
		default:
			break;
		}
		return carr;
	}
	
	private static void print(int[][] arr) {
		System.out.println("###################################");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("###################################");
	}

	private static void dfs(int[][] map, int dir, int cnt) {
		int[][] temp = new int[N][M];
		copy(map, temp);
		if (cnt == 11) {
			return;
		}

		int[][] res = new int[N][M];
		res = move(temp, dir);
		if (!checkb(res)) {
			return;
		} else if (!checkr(res)) {
			larr = new int[N][M];
			copy(res, larr);
			min = Math.min(min, cnt);
		} else {
			for (int i = 0; i < 4; i++) {
				dfs(res, i, cnt + 1);
			}
		}
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[N][M];
		tarr = new int[N][M];
		darr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = scan.next();
			for (int j = 0; j < str.length(); j++) {
				switch (str.charAt(j)) {
				case '.':
					tarr[i][j] = 0;
					break;
				case '#':
					tarr[i][j] = 1;
					break;
				case 'O':
					tarr[i][j] = 2;
					hx = i;
					hy = j;
					break;
				case 'R':
					tarr[i][j] = 3;
					break;
				case 'B':
					tarr[i][j] = 4;
					break;
				default:
					break;
				}
			}
		}

		copy(tarr, arr);
		
		for (int i = 0; i < 4; i++) {
			dfs(tarr, i, 1);
			recover();
		}
		if (min == 11) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
}
