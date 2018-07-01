

import java.util.Arrays;
import java.util.Scanner;

public class Q2667 {
	static int N, rear = 0, front = 0;
	static int[][] arr, distance, visited, parx, pary;
	static int[] queuex, queuey;
	private static Scanner scan;

	public static void push(int x, int y) {
		rear++;
		queuex[rear] = x;
		queuey[rear] = y;
	}

	public static int popx() {
		front++;
		return queuex[front];
	}

	public static int popy() {
		return queuey[front];
	}

	public static void BFS() {
		while (rear != front) {
			int x = popx();
			int y = popy();
			visited[x][y] = 1;
			if (x > 1)
				BFS2(x, y, x - 1, y);
			if (x < N)
				BFS2(x, y, x + 1, y);
			if (y > 1)
				BFS2(x, y, x, y - 1);
			if (y < N)
				BFS2(x, y, x, y + 1);
		}
	}

	public static void BFS2(int x, int y, int xx, int yy) {
		if (visited[xx][yy] == 0 && arr[xx][yy] == 1) {
			visited[xx][yy] = 1;
			distance[xx][yy] = distance[x][y] + 1;
			parx[xx][yy] = parx[x][y];
			pary[xx][yy] = pary[x][y];
			push(xx, yy);
		}
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N + 1][N + 1];
		visited = new int[N + 1][N + 1];
		distance = new int[N + 1][N + 1];
		parx = new int[N + 1][N + 1];
		pary = new int[N + 1][N + 1];
		queuex = new int[N * N * N];
		queuey = new int[N * N * N];
		scan.nextLine();
		for (int i = 1; i <= N; i++) {
			String str = scan.nextLine();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '1')
					arr[i][j + 1] = 1;
				if (str.charAt(j) == '0')
					arr[i][j + 1] = 0;
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] == 1 && visited[i][j] == 0) {
					distance[i][j] = 1;
					push(i, j);
					parx[i][j] = i;
					pary[i][j] = j;
					BFS();
				}
			}
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (distance[i][j] == 1)
					cnt++;
			}
		}

		int[] res = new int[cnt + 1];
		int[][] checked = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (parx[i][j] != 0 && pary[i][j] != 0 && checked[i][j] == 0) {
					int x = parx[i][j];
					int y = pary[i][j];
					for (int m = 1; m <= N; m++) {
						for (int n = 1; n <= N; n++) {
							if (parx[m][n] == x && pary[m][n] == y) {
								checked[m][n] = 1;
							}
						}
					}
					push(x, y);
				}
			}
		}
		int tmp = 0;
		while (rear != front) {
			int x = popx();
			int y = popy();
			int count = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (parx[i][j] == x && pary[i][j] == y)
						count++;
				}
			}
			res[tmp] = count;
			tmp++;
		}
	
		System.out.println(tmp);
		Arrays.sort(res);
		for(int i = 1 ; i <= tmp ; i++) {
			System.out.println(res[i]);
		}
	}
}
