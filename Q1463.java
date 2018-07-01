

import java.util.Scanner;

public class Q1463 {
	private static Scanner scan;
	private static int max = 1000000;
	private static int rear,front;
	
	private static int[] arr = new int[max+1];
	private static int[] queue = new int[max+1];
	private static int[] visited = new int[max+1];
	private static int[] distance = new int[max+1];
	
	public static void init() {
		for(int i = 1 ; i <= 1000000 ; i++) {
			arr[i] = -1;
		}
		rear = 0;
		front = 0;
		arr[1] = 1;
	}
	
	public static void push(int num) {
		queue[rear++] = num;
	}

	public static int pop() {
		return queue[front++];
	}
	
	public static void BFS2(int n , int k) {
		if(visited[k] == 0) {
			visited[k] = 1;
			distance[k] = distance[n] + 1;
			push(k);
		}
		visited[n] = 2;
	}
	
	public static void BFS(int s) {
		for (int i = 1; i <= max; i++) {
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
			if(temp%3 == 0)
				BFS2(temp,temp/3);
			if(temp%2 == 0)
				BFS2(temp,temp/2);
			if(temp >= 1)
				BFS2(temp,temp-1);
		}
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		BFS(N);
		System.out.println(distance[1]);
	}
}
