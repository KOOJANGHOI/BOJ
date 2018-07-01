

import java.util.Scanner;

public class Q1697 {
	private static final int max = 100000; 
	private static int[] queue; 
	private static int[] visited; 
	private static int[] distance; 
	private static int rear; 
	private static int front; 
	private static int N,K;
	private static Scanner scan;
	

	public static void push(int num) {
		queue[rear++] = num;
	}

	public static int pop() {
		return queue[front++];
	}

	public static void BFS2(int n, int k) {
		if(visited[k] == 0) {
			visited[k] = 1;
			distance[k] = distance[n] + 1;
			push(k);
		}
	}
	public static void BFS(int s) {
		for (int i = 0; i <= max; i++) {
			if (i != s) {
				visited[i] = 0;
				distance[i] = -1;
			}
		}
		visited[s] = 1;
		distance[s] = 0;
		push(s);
		while (!(rear == front)) {
			int temp = pop();
			if(temp >= 1) 
				BFS2(temp,temp-1);
			if(temp < 100000)
				BFS2(temp,temp+1);
			if(temp <= 50000)
				BFS2(temp,temp*2);
			visited[temp] = 2;
		}
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();	
		queue = new int[max+1];
		visited = new int[max+1];
		distance = new int[max+1];
		BFS(N);
		System.out.println(distance[K]);
	}
	

	
}
