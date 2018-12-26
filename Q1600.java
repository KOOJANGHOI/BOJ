import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// row,col check
// principal of BFS

public class Q1600 {
	int K, W, H;
	int[][] map;
	int[] hx = { -2, -2, -1, -1, 1, 1, 2, 2 }, hy = { -1, 1, -2, 2, -2, 2, -1, 1 };
	int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
	boolean[][][] visited; // visited를 3차원으로 관라
	// Node는 x,y,chance,cnt를 관리
	Queue<Node> q;

	int BFS() {
		while (!q.isEmpty()) {
			Node node = q.poll();

			// 범위 검사
			if (node.x < 0 || node.x >= W || node.y < 0 || node.y >= H)
				continue;
			// 못 통과하는 경우
			if (map[node.y][node.x] == 1)
				continue;
			// 기저사례
			if (node.x == W - 1 && node.y == H - 1)
				return node.cnt;
			// 그위치에 그 찬수 갯수에 방문 했으면 패스 , 안했으면 했다고 체크
			if (visited[node.y][node.x][node.chance])
				continue;
			visited[node.y][node.x][node.chance] = true;

			// 갈수있는 방향에 올바른 좌표 push
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx >= 0 && nx < W && ny >= 0 && ny < H)
					q.add(new Node(nx, ny, node.cnt + 1, node.chance));
			}

			// 찬스가 남아있으면 찬스로 이동한곳에 push
			if (node.chance == 0)
				continue;
			for (int i = 0; i < 8; i++) {
				int nx = node.x + hx[i];
				int ny = node.y + hy[i];
				if (nx >= 0 && nx < W && ny >= 0 && ny < H)
					q.add(new Node(nx, ny, node.cnt + 1, node.chance - 1));
			}
		}
		return -1;

	}

	void work() {
		Scanner scan = new Scanner(System.in);
		K = scan.nextInt();
		W = scan.nextInt();
		H = scan.nextInt();
		map = new int[201][201];
		visited = new boolean[201][201][31];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		scan.close();
		q = new LinkedList<Node>();
		q.add(new Node(0, 0, 0, K));
		System.out.println(BFS());
	}

	public static void main(String... args) {
		new Q1600().work();
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