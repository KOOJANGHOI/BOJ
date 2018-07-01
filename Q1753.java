

import java.util.Scanner;

public class Q1753 {
	static int V, E, K,max;
	static long rear = 0, front = 0;
	static long[][] arr;
	static long[] queue;
	static int[] distance;
	private static Scanner scan;

	static void push(int v) {
		queue[(int) rear++] = v;
	}

	static long pop() {
		return queue[(int) front++];
	}

	static void BFS(int s) {
		for(int i = 1 ; i <= V ; i++) {
			distance[i] = max;
		}
		distance[s] = 0;
		push(s);
		while(rear != front) {
			int tmp = (int) pop();
			for(int i = 1 ; i <= V ; i++) {
				if(arr[tmp][i] != 0) {
					BFS2(tmp,i);
				}
			}
		}
	}
	
	static void BFS2(int s , int d) {
		distance[d] = (int) Math.min(distance[d], distance[s]+arr[s][d]);
		for(int i = 1 ; i <= V ; i++) {
			if(arr[d][i] != 0 && i != K) {
				distance[i] = (int) Math.min(distance[i], distance[d] + arr[d][i]);
				push(i);
			}
		}	
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		V = scan.nextInt();
		E = scan.nextInt();
		K = scan.nextInt();
		arr = new long[V + 1][V + 1];
		distance = new int[V + 1];
		queue = new long[V*E];
		max = (V-1)*11;
		for (int i = 0; i < E; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			int w = scan.nextInt();
			arr[u][v] = 11;
			arr[u][v] = Math.min(arr[u][v], w);
		}
		BFS(K);
		for(int i = 1 ; i <= V ; i++) {
			if(distance[i] == max) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);	
			}
		}
	}
}
