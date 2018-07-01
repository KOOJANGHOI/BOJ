
import java.util.Scanner;

public class Q1002 {
	private static Scanner scan;

	public static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.abs(x2 - x1) * Math.abs(x2 - x1) + Math.abs(y2 - y1) * Math.abs(y2 - y1));
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] ans = new int[T];
		for (int i = 0; i < T; i++) {
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int r1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			int r2 = scan.nextInt();

			double dis = distance(x1, y1, x2, y2);

			if (dis == 0) { // 위치가 같은경우.
				if (r1 == r2) { // 반지름이 같으면.
					ans[i] = -1;
				} else { // 반지름이 다르면.
					ans[i] = 0;
				}
			} else {
				if (dis == r1 + r2 || dis == Math.abs(r1 - r2)) // 1개.
					ans[i] = 1;
				if (dis < r1 + r2 && dis > Math.abs(r1 - r2)) // 2개.
					ans[i] = 2;
				if (dis > r1 + r2 || dis < Math.abs(r1 - r2)) // 0개.
					ans[i] = 0;
			}
		}

		for (int i = 0; i < T; i++) {
			System.out.println(ans[i]);
		}
	}
}
