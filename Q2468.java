import java.util.Scanner;

public class Q2468 {
	int N, maxh = 0, gmax = 0;
	int[][] map, nmap, distance;
	boolean[][] visited;
	int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	void work() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scan.nextInt();
				maxh = Math.max(maxh, map[i][j]);
			}
		}
		scan.close();
		for (int i = 0; i <= maxh; i++) {
			rain(i);
		}
		System.out.println(gmax);
	}

	void rain(int h) {
		nmap = copymap(map);
		visited = new boolean[N][N];
		distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				distance[i][j] = -1;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (nmap[i][j] > h) {
					dfs(i, j, h);
				}
			}
		}
		int[] chk = new int[N * N];
		for (int i = 0; i < N * N; i++) {
			if (distance[i / N][i % N] != -1)
				chk[distance[i / N][i % N]] = 1;
		}
		int ret = 0;
		for (int i = 0; i < N * N; i++) {
			if (chk[i] == 1)
				ret++;
		}
		gmax = Math.max(gmax, ret);
	}

	void dfs(int x, int y, int h) {
		if (!visited[x][y]) {
			visited[x][y] = true;
			nmap[x][y] = -1;
			distance[x][y] = x * N + y;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (!visited[nx][ny] && nmap[nx][ny] > h) {
					visited[nx][ny] = true;
					nmap[nx][ny] = -1;
					distance[nx][ny] = distance[x][y];
					dfs(nx, ny, h);
				}
			}
		}
	}

	int[][] copymap(int[][] arr) {
		int[][] ret = new int[N][N];
		for (int i = 0; i < N * N; i++) {
			ret[i / N][i % N] = arr[i / N][i % N];
		}
		return ret;
	}

	public static void main(String... args) {
		new Q2468().work();
	}

	public class Node {
		int x, y;

		public Node(int _x, int _y) {
			this.x = _x;
			this.y = _y;
		}
	}
}