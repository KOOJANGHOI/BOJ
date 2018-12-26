import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q15686 {
	int N, M, gmin = 5000;
	int[][] map;
	List<Node> house, chicken;

	void combination(int[] num, int index, int n, int r, int target) {
		if (r == 0) {
			calc(num);
		} else if (target == n) {
			return;
		} else {
			num[index] = target;
			combination(num, index + 1, n, r - 1, target + 1);
			combination(num, index, n, r, target + 1);
		}
	}

	void calc(int[] arr) {
		int ret = 0;
		for (int i = 0; i < house.size(); i++) {
			int temp = 101;
			for (int j = 0; j < M; j++) {
				int distance = Math.abs(house.get(i).i - chicken.get(arr[j]).i)
						+ Math.abs(house.get(i).j - chicken.get(arr[j]).j);
				temp = Math.min(temp, distance);
			}
			ret += temp;
		}
		gmin = Math.min(gmin, ret);
	}

	void work() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][N];
		house = new ArrayList<Node>();
		chicken = new ArrayList<Node>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scan.nextInt();
				if (map[i][j] == 1)
					house.add(new Node(i, j));
				if (map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}
		scan.close();
		int[] comb = new int[M];
		combination(comb, 0, chicken.size(), M, 0);
		System.out.println(gmin);

	}

	public static void main(String... args) {
		new Q15686().work();
	}

	public class Node {
		int i, j;

		public Node(int _i, int _j) {
			this.i = _i;
			this.j = _j;
		}
	}

}