import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2206 {
	int N, M;
	int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
	int[][] map;
	boolean[][][] visited;
	Queue<Node> q;

	int BFS() {
		while (!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x, y = node.y;
			if (x == N - 1 && y == M - 1)
				return node.cnt;
			if (visited[x][y][node.chance])
				continue;
			visited[x][y][node.chance] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (map[nx][ny] == 0) {
					q.add(new Node(nx, ny, node.cnt + 1, node.chance));
				} else {
					if (node.chance != 0) {
						q.add(new Node(nx, ny, node.cnt + 1, node.chance - 1));
					}
				}
			}
		}
		return -1;
	}

	void work() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M][2];
		q = new LinkedList<Node>();
		scan.nextLine();
		for (int i = 0; i < N; i++) {
			String str = scan.nextLine();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '0') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}
		scan.close();
		q.add(new Node(0, 0, 1, 1));
		System.out.println(BFS());
	}

	public static void main(String... args) {
		new Q2206().work();
	}

	class Node {
		int x, y, cnt, chance;

		public Node(int _x, int _y, int _cnt, int _chance) {
			this.x = _x;
			this.y = _y;
			this.cnt = _cnt;
			this.chance = _chance;
		}
	}
}