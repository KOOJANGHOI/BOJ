

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576_2 {

	public static void main(String args[]) {
		Solver s = new Solver();
		s.solve();
	}
}

class Solver {
	private Scanner sc;

	Solver() {
	}

	public void solve() {
		sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] board = new int[n][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				board[i][j] = sc.nextInt();
			}
		}

		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (board[i][j] == 1)
					q.add(new Node(i, j));
			}
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int dx = -1; dx <= 1; ++dx) {
				for (int dy = -1; dy <= 1; ++dy) {
					if (Math.abs(dx) + Math.abs(dy) == 1) {
						int nx = cur.x + dx;
						int ny = cur.y + dy;
						if (0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 0) {
							board[nx][ny] = board[cur.x][cur.y] + 1;
							q.add(new Node(nx, ny));
						}
					}
				}
			}
		}
		int ans = 1;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (board[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				ans = Math.max(ans, board[i][j]);
			}
		}
		System.out.println(ans - 1);
		
		
		System.out.println("####################################################");
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("####################################################");
	}

	static class Node {
		int x, y;

		Node(int _x, int _y) {
			x = _x;
			y = _y;
		}
	}
}
