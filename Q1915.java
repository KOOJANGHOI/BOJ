
import java.util.Scanner;

class Q1915 {
	int N, M, ans, cnt;
	int[][] arr;

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[N][M];
		scan.nextLine();
		for (int i = 0; i < N; i++) {
			String str = scan.nextLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == '1') {
					arr[i][j] = 1;
					cnt++;
				}
			}
		}
		scan.close();
		while (cnt != 0) {
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < M - 1; j++) {
					if (arr[i][j] == 1) {
						int chk = arr[i][j] * arr[i + 1][j] * arr[i][j + 1] * arr[i + 1][j + 1];
						arr[i][j] = chk;
					}
				}
			}
			for(int i = 0 ; i < N ; i++) {
				arr[i][M-1]=0;
			}
			for(int j = 0 ; j < M ; j++) {
				arr[N-1][j]=0;
			}
			cnt = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = 0; j < M-1; j++) {
					if (arr[i][j] == 1)
						cnt++;
				}
			}
			ans++;
		}
		System.out.println(ans * ans);
	}

	public static void main(String[] args) {
		new Q1915().solve();
	}
}