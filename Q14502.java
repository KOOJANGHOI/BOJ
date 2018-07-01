

import java.util.Scanner;

public class Q14502 {
	private static int N, M, rear, front, max = 0;
	private static int[][] arr, narr, marr, visited;
	private static int[] queuex, queuey;
	private static Scanner scan;

	public static void init() {
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = 0;
			}
		}
	}

	public static void init2() {
		queuex = new int[64 * 64 * 64];
		queuey = new int[64 * 64 * 64];
		front = 0;
		rear = 0;
	}

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

	public static void DFS(int i, int j, int d) {
		if (d == 3) {
			marr = new int[N][M];
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < M; b++) {
					marr[i][j] = arr[i][j];
				}
			}
			
			BFS();
			
			max = Math.max(max, count());
			return;
		} else {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (visited[x][y] == 0 && arr[x][y] == 0) {
						arr[x][y] =1;
						visited[x][y] = 1;
						DFS(x, y, d + 1);
					}
						
				}
			}
		}
		arr[i][j] = 0;
		d--;

	}

	public static void recover() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = marr[i][j];
			}
		}
	}

	public static void copy() {
		
	}

	public static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (marr[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void printarr(int k) {
		System.out.println(k + "######################################");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("######################################");
	}

	public static void BFS() {
		init();
		init2();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (marr[i][j] == 2) {
					visited[i][j] = 1;
					push(i, j);
				}
			}
		}
		while (rear != front) {
			int tempx = popx();
			int tempy = popy();
			if (tempx > 0)
				BFS2(tempx, tempy, tempx - 1, tempy);
			if (tempx < N - 1)
				BFS2(tempx, tempy, tempx + 1, tempy);
			if (tempy > 0)
				BFS2(tempx, tempy, tempx, tempy - 1);
			if (tempy < M - 1)
				BFS2(tempx, tempy, tempx, tempy + 1);
		}
	}

	public static void BFS2(int fx, int fy, int sx, int sy) {
		if (visited[sx][sy] == 0 && marr[sx][sy] == 0) {
			visited[sx][sy] = 1;
			marr[sx][sy] = 2;
			push(sx, sy);
		}
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[N][M];
		narr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				narr[i][j] = arr[i][j] = scan.nextInt();
			}
		}
		init();
		init2();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					visited[i][j] = 1;
					DFS(i, j, 1);
					arr[i][j] = 0;
					visited[i][j] = 0;
				}

			}
		}
		System.out.println(max);
	}
}
