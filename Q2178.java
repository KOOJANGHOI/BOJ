

import java.util.Scanner;

public class Q2178 {
	static int[][] visited,distance,arr;
	static int[] queuex,queuey;
	static int rear = 0, front = 0,N,M;
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
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				visited[i][j] = 0;
				distance[i][j] = -1;
			}
		}
		visited[1][1] = 1;
		distance[1][1] = 1;
		push(1,1);
		while(rear != front) {
			int tmpx = popx();
			int tmpy = popy();
			if(tmpx > 1)
				BFS2(tmpx,tmpy,tmpx-1,tmpy);
			if(tmpx < N)
				BFS2(tmpx,tmpy,tmpx+1,tmpy);
			if(tmpy > 1)
				BFS2(tmpx,tmpy,tmpx,tmpy-1);
			if(tmpy < M)
				BFS2(tmpx,tmpy,tmpx,tmpy+1);
			visited[tmpx][tmpy] = 2;	
		}
	}
	
	public static void BFS2(int fx , int fy , int sx , int sy) {
		if(visited[sx][sy] == 0 && arr[sx][sy] == 1) {
			visited[sx][sy] = 1;
			distance[sx][sy] = distance[fx][fy] + 1;
			push(sx,sy);
		}
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[N+1][M+1];
		visited = new int[N+1][M+1];
		distance = new int[N+1][M+1];
		queuex = new int[(N+1)*(M+1)];
		queuey = new int[(N+1)*(M+1)];
		scan.nextLine();
		for(int i = 1 ; i <= N ; i++) {
			String str = scan.nextLine();
			for(int j = 0 ; j < str.length() ; j++) {
				if(str.charAt(j) == '1')
					arr[i][j+1] = 1;
				if(str.charAt(j) == '0')
					arr[i][j+1] = 0;
			}
		}
		BFS();
		System.out.println(distance[N][M]);	
	}
}
