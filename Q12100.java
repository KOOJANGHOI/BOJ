

import java.util.Arrays;
import java.util.Scanner;

public class Q12100 {
	private static int N, max = 0;
	private static int[][] bool;
	private static Scanner scan;

	public static void moveup(int[][] arr) {
		for (int j = 0; j < N; j++) {
			flushup(arr, j);
		}
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (arr[i][j] == arr[i + 1][j] && bool[i][j] == 0 && bool[i + 1][j] == 0) {
					arr[i][j] *= 2;
					arr[i + 1][j] = 0;
					bool[i][j] = 1;
					flushup(arr, j);
				}
			}
		}
		flush();
	}

	public static void flushup(int[][] arr, int j) {
		for (int i = 0; i < N - 1; i++) {
			if (arr[i][j] == 0) {
				arr[i][j] = arr[i + 1][j];
				arr[i + 1][j] = 0;
			}
		}
	}

	public static void movedown(int[][] arr) {
		for (int j = 0; j < N; j++) {
			flushdown(arr, j);
		}
		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i > 0; i--) {
				if (arr[i][j] == arr[i - 1][j] && bool[i][j] == 0 && bool[i - 1][j] == 0) {
					arr[i][j] *= 2;
					arr[i - 1][j] = 0;
					bool[i][j] = 1;
					flushdown(arr, j);
				}
			}
		}
		flush();
	}

	public static void flushdown(int[][] arr, int j) {
		for (int i = N - 1; i > 0; i--) {
			if (arr[i][j] == 0) {
				arr[i][j] = arr[i - 1][j];
				arr[i - 1][j] = 0;
			}
		}
	}

	public static void moveleft(int[][] arr) {
		for (int i = 0; i < N; i++) {
			flushleft(arr, i);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1] && bool[i][j] == 0 && bool[i][j + 1] == 0) {
					arr[i][j] *= 2;
					arr[i][j + 1] = 0;
					bool[i][j] = 1;
					flushleft(arr, i);
				}
			}
		}
		flush();
	}

	public static void flushleft(int[][] arr, int i) {
		for (int j = 0; j < N - 1; j++) {
			if (arr[i][j] == 0) {
				arr[i][j] = arr[i][j + 1];
				arr[i][j + 1] = 0;
			}
		}
	}

	public static void moveright(int[][] arr) {
		for (int i = 0; i < N; i++) {
			flushright(arr, i);
		}
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j > 0; j--) {
				if (arr[i][j] == arr[i][j - 1] && bool[i][j] == 0 && bool[i][j - 1] == 0) {
					arr[i][j] *= 2;
					arr[i][j - 1] = 0;
					bool[i][j] = 1;
					flushright(arr, i);
				}
			}
		}
		flush();
	}

	public static void flushright(int[][] arr, int i) {
		for (int j = N - 1; j > 0; j--) {
			if (arr[i][j] == 0) {
				arr[i][j] = arr[i][j - 1];
				arr[i][j - 1] = 0;
			}
		}
	}

	public static void flush() {
		bool = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bool[i][j] = 0;
			}
		}
	}

	static void dfs(int[][] arr, int count) {
		if (count == 5) {
			calc(arr);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int[][] mapCopy = new int[N][N];
			copy(arr,mapCopy);
			dfs(action(mapCopy, i), count + 1);
		}
	}

	static int[][] action(int[][] mapCopy, int dir) {

		switch (dir) {

		case 2:

			for (int row = 0; row < N; row++) {

				int nBlank = 0;
				// 왼쪽에서 오른쪽으로
				for (int col = 1; col < N; col++) {

					// 검사 노드 == 0
					if (mapCopy[row][col] == 0) {

						nBlank++;
						continue;
					} else {

						// 병합 가능 : 검사 노드 = 대상 노드
						if (mapCopy[row][col] == mapCopy[row][col - 1 - nBlank]) {

							mapCopy[row][col - 1 - nBlank] *= 2;
							mapCopy[row][col] = 0;
						}
						// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
						else if (mapCopy[row][col - 1 - nBlank] == 0) {

							mapCopy[row][col - 1 - nBlank] = mapCopy[row][col];
							mapCopy[row][col] = 0;
							nBlank++;
						}
						// 병합 불가능 : 검사 노드 != 0 && 대상 노드 != 0 && 검사노드 != 대상노드
						else {

							mapCopy[row][col - nBlank] = mapCopy[row][col];
							if (nBlank != 0)
								mapCopy[row][col] = 0;
						}
					}
				}
			}

			break;

		case 0:

			for (int col = 0; col < N; col++) {

				int nBlank = 0;
				// 위쪽에서 아래쪽으로
				for (int row = 1; row < N; row++) {

					// 검사 노드 == 0
					if (mapCopy[row][col] == 0) {

						nBlank++;
						continue;
					} else {

						// 병합 가능 : 검사 노드 = 대상 노드
						if (mapCopy[row - 1 - nBlank][col] == mapCopy[row][col]) {

							mapCopy[row - 1 - nBlank][col] *= 2;
							mapCopy[row][col] = 0;
						}
						// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
						else if (mapCopy[row - 1 - nBlank][col] == 0) {

							mapCopy[row - 1 - nBlank][col] = mapCopy[row][col];
							mapCopy[row][col] = 0;
							nBlank++;
						}
						// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
						else {

							mapCopy[row - nBlank][col] = mapCopy[row][col];
							if (nBlank != 0)
								mapCopy[row][col] = 0;
						}
					}
				}
			}
			break;

		case 3:

			for (int row = 0; row < N; row++) {

				int nBlank = 0;
				// 오른쪽에서 왼쪽으로
				for (int col = N - 2; col >= 0; col--) {

					// 검사 노드 == 0
					if (mapCopy[row][col] == 0) {

						nBlank++;
						continue;
					} else {

						// 병합 가능 : 검사 노드 = 대상 노드
						if (mapCopy[row][col] == mapCopy[row][col + 1 + nBlank]) {

							mapCopy[row][col + 1 + nBlank] *= 2;
							mapCopy[row][col] = 0;
						}
						// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
						else if (mapCopy[row][col + 1 + nBlank] == 0) {

							mapCopy[row][col + 1 + nBlank] = mapCopy[row][col];
							mapCopy[row][col] = 0;
							nBlank++;
						}
						// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
						else {

							mapCopy[row][col + nBlank] = mapCopy[row][col];
							if (nBlank != 0)
								mapCopy[row][col] = 0;
						}
					}
				}
			}
			break;

		case 1:

			for (int col = 0; col < N; col++) {

				int nBlank = 0;
				// 아래쪽에서 위쪽으로
				for (int row = N - 2; row >= 0; row--) {

					// 검사 노드 == 0
					if (mapCopy[row][col] == 0) {

						nBlank++;
						continue;
					} else {

						// 병합 가능 : 검사 노드 = 대상 노드
						if (mapCopy[row + 1 + nBlank][col] == mapCopy[row][col]) {

							mapCopy[row + 1 + nBlank][col] *= 2;
							mapCopy[row][col] = 0;
						}
						// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
						else if (mapCopy[row + 1 + nBlank][col] == 0) {

							mapCopy[row + 1 + nBlank][col] = mapCopy[row][col];
							mapCopy[row][col] = 0;
							nBlank++;
						}
						// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
						else {

							mapCopy[row + nBlank][col] = mapCopy[row][col];
							if (nBlank != 0)
								mapCopy[row][col] = 0;
						}
					}
				}
			}
			break;
		}

		return mapCopy;
	}

	/*
	 * public static int[][] move(int[][] arr, int dir) { switch (dir) { case 0:
	 * moveup(arr); return arr; case 1: movedown(arr); return arr; case 2:
	 * moveleft(arr); return arr; case 3: moveright(arr); return arr; default:
	 * break; } return null; }
	 */

	public static void calc(int[][] array) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max < array[i][j]) {
					max = array[i][j];
				}
			}
		}
	}

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
