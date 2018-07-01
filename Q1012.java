

import java.util.Scanner;

public class Q1012 {
	private static int[][] arr;
	private static int[] queuex;
	private static int[] queuey;
	private static int[][] distance;
	private static int[][] visited;
	private static int rear,front;
	private static int K;
	private static Scanner scan;

	public static void init() {
		arr = new int[50][50];
		visited = new int[50][50];
		queuex = new int[2500*4];
		queuey = new int[2500*4];
		distance = new int[50][50];
		rear = 0;
		front = 0;
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				arr[i][j] = 0;
				visited[i][j] = 0;
				distance[i][j] = 0;
			}
		}
	}
	
	public static void push(int x , int y) {
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
	
	public static void BFS2(int x, int y , int px , int py) {
		if(arr[px][py] == 1 && visited[px][py] == 0) {
			visited[px][py] = 1;
			arr[px][py] = 0;
			distance[px][py] = distance[x][y] + 1;
			push(px,py);
		}
	}
	public static void BFS(int x , int y) {
		for(int i = 0 ; i < 50 ; i++) {
			for(int j = 0 ; j < 50 ; j++) {
				if(!(i == x && j == y)) {
					visited[i][j] = 0;
					distance[i][j] = -1;
				}
			}
		}
		visited[x][y] = 1;
		distance[x][y] = 0;
		push(x,y);
		while (!(rear == front)) {
			int tempx = popx();
			int tempy = popy();
			if(tempx >= 1) 
				BFS2(tempx,tempy,tempx-1,tempy);
			if(tempx < 49)
				BFS2(tempx,tempy,tempx+1,tempy);
			if(tempy >= 1) 
				BFS2(tempx,tempy,tempx,tempy-1);
			if(tempy < 49)
				BFS2(tempx,tempy,tempx,tempy+1);
			visited[tempx][tempy] = 2;
		}
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] ansarr = new int[T];
		for (int i = 0; i < T; i++) {
			int ans = 0;
			int M = scan.nextInt();
			int N = scan.nextInt();
			K = scan.nextInt();
			init();
			for (int j = 0; j < K; j++) {
				int X = scan.nextInt();
				int Y = scan.nextInt();
				arr[X][Y] = 1;
			}
			for(int x = 0 ; x < 50 ; x++) {
				for(int y = 0 ; y < 50 ; y++) {
					if(arr[x][y] == 1) {
						BFS(x,y);
						ans++;
					}
				}
			}
			ansarr[i] = ans;
		}
		for(int i = 0 ; i < T ; i++) {
			System.out.println(ansarr[i]);
		}
	}
}
