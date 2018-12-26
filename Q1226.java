import java.util.Scanner;

class Q1226 {
	int N, M, K;
	long[][] dpc;
	long[] dpf;

	long factorial(int n) {
		if (dpf[n] != -1) {
			return dpf[n];
		} else {
			dpf[n] = n * factorial(n - 1);
			return dpf[n];
		}
	}

	long combination(int n, int r) {
		System.out.println(n + "," + r);
		if (dpc[n][r] != -1) {
			return dpc[n][r];
		} else {
			dpc[n][r] = factorial(n) / (factorial(r) * factorial(n - r));
			return dpc[n][r];
		}
	}

	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		K = scan.nextInt();
		scan.close();
		dpf = new long[N + M + 1];
		for (int i = 0; i <= N + M; i++) {
			dpf[i] = -1;
		}
		dpf[0] = 1;
		dpf[1] = 1;
		dpc = new long[N + M + 1][N + 1];
		for (int i = 0; i <= N + M; i++) {
			for (int j = 0; j <= N; j++) {
				dpc[i][j] = -1;
			}
		}
		dpc[0][0] = 1;
		String ans = "";
		int alpha = N + M - 1;
		int beta = N - 1;
		if (combination(N + M, N) < K) {
			System.out.println(-1);
		} else {
			while (ans.length() != (N + M)) {
				System.out.println(K + "," + alpha + "," + beta);
				if (K <= combination(alpha, beta)) {
					ans += "a";
					alpha--;
					beta--;
					if (beta == -1) {
						while (ans.length() != (N + M)) {
							ans += "z";
						}
					}
				} else {
					ans += "z";
					K -= combination(alpha, beta);
					alpha--;
				}
			}
			System.out.println(ans);
		}
	}

	public static void main(String a[]) {
		new Q1226().solve();
	}
}