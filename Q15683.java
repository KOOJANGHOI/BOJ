import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q15683 {
	int N, M, cnt = 0, gmin = 65;
	int[][] map;
	List<Node> list;
	boolean[] ba1 = { false, false, false, true };
	boolean[] ba2 = { true, false, false, false };
	boolean[] ba3 = { false, false, true, false };
	boolean[] ba4 = { false, true, false, false };

	boolean[] ba5 = { false, false, true, true };
	boolean[] ba6 = { true, true, false, false };

	boolean[] ba7 = { true, false, false, true };
	boolean[] ba8 = { true, false, true, false };
	boolean[] ba9 = { false, true, true, false };
	boolean[] ba10 = { false, true, false, true };

	boolean[] ba11 = { true, false, true, true };
	boolean[] ba12 = { true, true, true, false };
	boolean[] ba13 = { false, true, true, true };
	boolean[] ba14 = { true, true, false, true };
	boolean[] ba15 = { true, true, true, true };

	void BFS(int[][] arr, int idx) {
		if (idx == list.size()) {
			int count = 0;
			// printarr(arr);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0)
						count++;
				}
			}
			gmin = Math.min(gmin, count);
			return;
		} else {
			Node node = list.get(idx);
			switch (node.type) {
			case 1:
				BFS(move(arr, node, ba1), idx + 1);
				BFS(move(arr, node, ba2), idx + 1);
				BFS(move(arr, node, ba3), idx + 1);
				BFS(move(arr, node, ba4), idx + 1);
				break;
			case 2:
				BFS(move(arr, node, ba5), idx + 1);
				BFS(move(arr, node, ba6), idx + 1);
				break;
			case 3:
				BFS(move(arr, node, ba7), idx + 1);
				BFS(move(arr, node, ba8), idx + 1);
				BFS(move(arr, node, ba9), idx + 1);
				BFS(move(arr, node, ba10), idx + 1);
				break;
			case 4:
				BFS(move(arr, node, ba11), idx + 1);
				BFS(move(arr, node, ba12), idx + 1);
				BFS(move(arr, node, ba13), idx + 1);
				BFS(move(arr, node, ba14), idx + 1);
				break;
			case 5:
				BFS(move(arr, node, ba15), idx + 1);
				break;
			default:
				break;
			}
		}

	}

	boolean isvalid(int i, int j) {
		return (i >= 0 && i < N && j >= 0 && j < M);
	}

	void printarr(int[][] arr) {
		System.out.println("==============================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==============================");
	}

	int[][] move(int[][] temp, Node node, boolean[] chk) {
		int[][] arr = copymap(temp);
		boolean chk0 = true, chk1 = true, chk2 = true, chk3 = true;
		for (int i = 1; i < 8; i++) {
			if (chk0 && chk[0] && isvalid(node.i - i, node.j)) {
				if (arr[node.i - i][node.j] == 0) {
					arr[node.i - i][node.j] = 7;
				} else if (arr[node.i - i][node.j] == 6) {
					chk0 = false;
				}
			}
			if (chk1 && chk[1] && isvalid(node.i + i, node.j)) {
				if (arr[node.i + i][node.j] == 0) {
					arr[node.i + i][node.j] = 7;
				} else if (arr[node.i + i][node.j] == 6) {
					chk1 = false;
				}
			}
			if (chk2 && chk[2] && isvalid(node.i, node.j - i)) {
				if (arr[node.i][node.j - i] == 0) {
					arr[node.i][node.j - i] = 7;
				} else if (arr[node.i][node.j - i] == 6) {
					chk2 = false;
				}
			}
			if (chk3 && chk[3] && isvalid(node.i, node.j + i)) {
				if (arr[node.i][node.j + i] == 0) {
					arr[node.i][node.j + i] = 7;
				} else if (arr[node.i][node.j + i] == 6) {
					chk3 = false;
				}
			}
		}
		return arr;
	}

	int[][] copymap(int[][] arr) {
		int[][] ret = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				ret[i][j] = arr[i][j];
			}
		}
		return ret;
	}

	void work() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][M];
		list = new ArrayList<Node>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
				if (map[i][j] != 0 && map[i][j] != 6)
					list.add(new Node(i, j, map[i][j]));
			}
		}
		scan.close();
		BFS(map, 0);
		System.out.println(gmin);

	}

	public static void main(String... args) {
		new Q15683().work();
	}

	class Node {
		int i, j, type;

		public Node(int _i, int _j, int _type) {
			this.i = _i;
			this.j = _j;
			this.type = _type;
		}
	}
}