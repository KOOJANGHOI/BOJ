import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Q7576 {
	int N, M, idx = 0;
	int[][] map, visited, distance;
	Queue<Node> queue;
	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };

	void work() {
		Scanner scan = new Scanner(System.in);
		M = scan.nextInt();
		N = scan.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		distance = new int[N][M];
		queue = new LinkedList<Node>();
		int temp = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
				temp *= map[i][j];
				distance[i][j] = -1;
				if (map[i][j] == 1) {
					distance[i][j] = 0;
					queue.add(new Node(i, j));
				}
			}
		}
		scan.close();
		if (temp == 1) {
			System.out.println(0);
		} else {
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				visited[node.i][node.j] = 1;
				for (int i = 0; i < 4; i++) {
					int ii = node.i + dx[i];
					int jj = node.j + dy[i];
					if (ii >= 0 && ii < N && jj >= 0 && jj < M) {
						if (visited[ii][jj] == 0 && map[ii][jj] == 0) {
							visited[ii][jj] = 1;
							map[ii][jj] = 1;
							distance[ii][jj] = distance[node.i][node.j] + 1;
							queue.add(new Node(ii, jj));
						}
					}
				}
			}
			boolean chk = false;
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						chk = true;
					}
					max = Math.max(max, distance[i][j]);
				}
			}
			System.out.println((chk) ? -1 : max);
		}
	}

	public static void main(String a[]) {
		new Q7576().work();
	}

	public class Node {
		int i, j;

		public Node(int _i, int _j) {
			this.i = _i;
			this.j = _j;
		}
	}
}