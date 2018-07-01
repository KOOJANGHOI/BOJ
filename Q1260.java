

import java.util.Scanner;

public class Q1260 {
	private static int N,M,V;
	
	private static int rear,front;
	private static int[][] arr;
	private static int[] queue;
	private static int[] visited;
	private static int[] distance;
	
	private static Scanner scan;
	
	
	public static void init() {
		arr = new int[N+1][N+1];
		queue = new int[10000];
		visited = new int[N+1];
		distance = new int[N+1];
		rear = 0;
		front = 0;
		for(int i = 0 ; i <= N ; i++) {
			visited[i] = 0;
			distance[i] = 0;
			for(int j = 0 ; j <= N ; j++) {
				arr[i][j] = 0;
			}
		}
	}
	
	public static void push(int k) {
		queue[rear++] = k;
	}
	
	public static int pop() {
		return queue[front++];
	}
	
	public static void BFS(int s) {
		for(int i = 1 ; i <= N ; i++) {
			if(i != s) {
				visited[i] = 0;
				distance[i] = -1;
			}
		}
		visited[s] = 1;
		distance[s] = 0;
		push(s);
		while(rear != front) {
			int temp = pop();
			if(temp != 0)
				System.out.print(temp+ " ");
			for(int i = 1 ; i <= N ; i++) {
				if(arr[temp][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					distance[i] = distance[temp] + 1;
					push(i);
				}
			}
			visited[temp] = 2;
		}	
	}
	
	public static void DFS(int s) {
		visited[s] = 1;
		System.out.print(s+" ");
		for(int i = 1 ; i <= N ; i++) {
			if(arr[s][i] == 1 && visited[i] == 0)
				DFS(i);
		}
	}
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();
		init();
		for(int i = 0 ; i < M ; i++) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			arr[n][k] = 1;
			arr[k][n] = 1;
		}
		DFS(V);
		visited = new int[N+1];
		System.out.println();
		BFS(V);
		
	
		
	}
}
