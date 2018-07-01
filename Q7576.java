

import java.util.Scanner;

public class Q7576 {
	private static int M, N, rear, front;
	private static int[][] arr, distance;
	private static int[] queuex, queuey;
	private static Scanner scan;

	public static void init() {
		rear = front = 0;
		queuex = new int[1000000];
		queuey = new int[1000000];
		distance = new int[N + 1][M + 1];
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

	public static void BFS2(int fx, int fy, int sx, int sy) {
		if (distance[sx][sy] == -1 && arr[sx][sy] == 0) {
			distance[sx][sy] = distance[fx][fy] + 1;
			push(sx, sy);
		}
	}

	public static void BFS() {
		while (rear != front) {
			int tx = popx();
			int ty = popy();
			if (tx > 1)
				BFS2(tx, ty, tx - 1, ty);
			if (tx < N)
				BFS2(tx, ty, tx + 1, ty);
			if (ty > 1)
				BFS2(tx, ty, tx, ty - 1);
			if (ty < M)
				BFS2(tx, ty, tx, ty + 1);
		}
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		M = scan.nextInt();
		N = scan.nextInt();
		arr = new int[N + 1][M + 1];
		init();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = scan.nextInt();
				distance[i][j] = -1;
				if (arr[i][j] == 1) {
					distance[i][j] = 0;
					push(i, j);
				}
			}
		}
		int temp = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				temp *= arr[i][j];
			}
		}
		if (temp == 1) {
			System.out.println(0);
		} else {
			BFS();
			int max = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (max < distance[i][j])
						max = distance[i][j];
				}
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (arr[i][j] == 0 && distance[i][j] == -1)
						max = -1;
				}
			}
			System.out.println(max);
		}
	}
}
