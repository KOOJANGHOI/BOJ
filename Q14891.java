

import java.util.Scanner;

public class Q14891 {
	private static Scanner scan;
	private static int[][] circle;

	public static void rotate(int top, int dir) {
		if (dir == 1) {
			int temp = circle[top][7];
			for (int i = 7; i >= 1; i--) {
				circle[top][i] = circle[top][i - 1];
			}
			circle[top][0] = temp;
		} else if (dir == -1) {
			int temp = circle[top][0];
			for (int i = 0; i < 7; i++) {
				circle[top][i] = circle[top][i + 1];
			}
			circle[top][7] = temp;
		}
	}

	public static int sum() {
		int res = 0;
		if (circle[1][0] == 1)
			res += 1;
		if (circle[2][0] == 1)
			res += 2;
		if (circle[3][0] == 1)
			res += 4;
		if (circle[4][0] == 1)
			res += 8;
		return res;
	}

	public static void func(int n, int d) {
		if (n == 1) {
			if (circle[n][2] != circle[2][6]) {
				if (circle[2][2] != circle[3][6]) {
					if (circle[3][2] != circle[4][6]) {
						rotate(2, (-1) * d);
						rotate(3, d);
						rotate(4, (-1) * d);
					}
					else {
						rotate(2, (-1) * d);
						rotate(3, d);
					}
				}
				else {
					rotate(2, (-1) * d);
				}
			}
		}
		else if (n == 2) {
			if (circle[n][6] != circle[1][2]) {
				rotate(1, (-1) * d);
			}
			if (circle[n][2] != circle[3][6]) {
				if (circle[3][2] != circle[4][6]) {
					rotate(3, (-1) * d);
					rotate(4, d);
				}
				else {
					rotate(3, (-1) * d);
				}
			}
		}
		else if (n == 3) {
			if (circle[n][2] != circle[4][6]) {
				rotate(4, (-1) * d);
			}
			if (circle[n][6] != circle[2][2]) {
				if (circle[2][6] != circle[1][2]) {
					rotate(2, (-1) * d);
					rotate(1, d);
				}
				else {
					rotate(2, (-1) * d);
				}
			}
		}
		else { // n == 4
			if (circle[n][6] != circle[3][2]) {
				if (circle[3][6] != circle[2][2]) {
					if (circle[2][6] != circle[1][2]) {
						rotate(3, (-1) * d);
						rotate(2, d);
						rotate(1, (-1) * d);
					}
					else {
						rotate(3, (-1) * d);
						rotate(2, d);
					}
				}
				else {
					rotate(3, (-1) * d);
				}
			}
		}
		rotate(n, d);
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		circle = new int[5][8];

		for (int i = 1; i < 5; i++) {
			String str = scan.next();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '1') {
					circle[i][j] = 1;
				} else {
					circle[i][j] = 0;
				}
			}
		}

		int N = scan.nextInt();
		for (int i = 0; i < N; i++) {
			int top = scan.nextInt();
			int dir = scan.nextInt();
			func(top, dir);
		}
		System.out.println(sum());
	}
}
