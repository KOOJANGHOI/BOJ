import java.util.Scanner;

class Q2602 {
	String str, str2;
	int ans = 0;
	int[] scroll;
	int[][] bridge;
	int[][][] dp;

	int dfs(int flag, int cur, int depth) {
		if (depth == scroll.length - 1)
			return 1;
		if (dp[flag][cur][depth] != -1)
			return dp[flag][cur][depth];
		dp[flag][cur][depth] = 0;
		for (int i = cur + 1; i < bridge[0].length; i++) {
			if (bridge[1 - flag][i] == scroll[depth + 1]) {
				dp[flag][cur][depth] += dfs(1 - flag, i, depth + 1);
			}
		}
		return dp[flag][cur][depth];
	}

	void work() {
		int ans = 0;
		Scanner scan = new Scanner(System.in);
		str = scan.nextLine();
		scroll = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			scroll[i] = str.charAt(i);
		}
		str = scan.nextLine();
		str2 = scan.nextLine();
		scan.close();
		bridge = new int[2][str.length()];
		for (int i = 0; i < str.length(); i++) {
			bridge[0][i] = str.charAt(i);
			bridge[1][i] = str2.charAt(i);
		}
		dp = new int[2][str.length()][scroll.length];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < bridge[0].length; j++) {
				for (int k = 0; k < scroll.length; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < bridge[0].length; j++) {
				if (bridge[i][j] == scroll[0])
					ans += dfs(i, j, 0);
			}
		}
		System.out.println(ans);
	}

	public static void main(String a[]) {
		new Q2602().work();
	}
}