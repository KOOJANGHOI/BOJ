import java.util.Scanner;

class Q4883 {
	int N, tc = 0;
	int[][] arr;

	void solve() {
		Scanner scan = new Scanner(System.in);
		while ((N = scan.nextInt()) != 0) {
			arr = new int[N][3];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					arr[i][j] = scan.nextInt();
				}
			}
			arr[1][0] += arr[0][1];
			arr[0][2] += arr[0][1];
			arr[1][1] += Math.min(arr[1][0], Math.min(arr[0][1], arr[0][2]));
			arr[1][2] += Math.min(arr[1][1], Math.min(arr[0][1], arr[0][2]));
			for (int i = 2; i < N; i++) {
				arr[i][0] += Math.min(arr[i - 1][0], arr[i - 1][1]);
				arr[i][1] += Math.min(Math.min(arr[i][0], arr[i - 1][0]), Math.min(arr[i - 1][1], arr[i - 1][2]));
				arr[i][2] += Math.min(arr[i][1], Math.min(arr[i - 1][1], arr[i - 1][2]));
			}
			tc++;
			System.out.println(tc + ". " + arr[N - 1][1]);

			/*
			 * for(int i = 0 ; i < N ; i++) { for(int j = 0 ; j < 3 ; j++) {
			 * System.out.print(arr[i][j]+" "); } System.out.println(); }
			 */
		}
		scan.close();
	}

	public static void main(String a[]) {
		new Q4883().solve();
	}
}