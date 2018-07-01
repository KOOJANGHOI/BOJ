

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Q1753_3 {

	static int V,E,K,max=Integer.MAX_VALUE-1; 
	static int[] distance,visited; 
	static HashMap<Integer, LinkedList<Edge>> map;
	private static Scanner scan; 

	public static void shortestpath() {
		distance[K] = 0;
		for (int i = 0; i < V; i++) {
			int min = max+1;
			int u = -1;
			for (int j = 1; j <= V; j++) {
				if (visited[j] == 0 && distance[j] < min) {
					u = j;
					min = distance[j];
				}
			}
			visited[u] = 1;
			if (map.containsKey(u)) {
				for (Edge e : map.get(u)) {
					int v = e.v;
					int w = e.w;
					if (distance[u] != max && distance[v] > distance[u] + w) {
						distance[v] = distance[u] + w;
					}
				}
			}
		}	
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		V = scan.nextInt();
		E = scan.nextInt();
		K = scan.nextInt();
		map = new HashMap<>();
		distance = new int[V + 1];
		visited = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			distance[i] = max;
		}
		for (int i = 0; i < E; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			int w = scan.nextInt();
			if (!map.containsKey(u))
				map.put(u, new LinkedList<>());
			map.get(u).add(new Edge(u, v, w));
		}
		shortestpath();
		for (int i = 1; i <= V; i++) {
			if(distance[i] == max) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}
}

class Edge {
	public int u,v,w;
	public Edge(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
}

