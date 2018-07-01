

import java.util.Scanner;

public class Q2579 {
	static int N, max = 0;
	static int[] arr;

	static void dfs(int[] visited, int cnt, int num) {
		if(cnt > N) {
			return ;
		} else if (cnt == N) {
			num += arr[N];
			max = Math.max(max, num);
			return;
		} else {
			visited[cnt] = 1;
			num += arr[cnt];
			int[] temp = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				temp[i] = visited[i];
			}
			if (cnt > 1 && visited[cnt - 1] == 1) {
				dfs(temp, cnt + 2, num);
			} else {
				dfs(temp, cnt + 1, num);
				dfs(temp, cnt + 2, num);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N + 1];
		int[] visited = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		dfs(visited, 0, 0);
		System.out.println(max);
	}
}
