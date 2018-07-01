

import java.util.Arrays;
import java.util.Scanner;
// 로직은 맞는것같은데.. 왜 틀렸을까.....
public class Q2805 {
	static int N, M, cnt = 0, index = 0;
	static int[][] res;

	static void process(int[] arr, int s, int d) {
		int mid = 0, h = 0, cal = 0;
		if (s == d) {
			h = arr[s];
			for(int i = s+1 ; i <= N ; i++) {
				cal += (arr[i]-h);
			}
			res[cnt][0] = h;
			res[cnt][1] = cal;
			cnt++;
			return;
		}
		else if (d - s == 1) {
			process(arr, s, s);
			process(arr, d, d);
		} else {
			mid = (s + d) / 2;
			h = arr[mid];
			for (int i = mid + 1; i <= N; i++) {
				cal += (arr[i] - h);
			}
			res[cnt][0] = h;
			res[cnt][1] = cal;
			cnt++;
			if (cal < M) {
				process(arr, 1, mid - 1);
			} else {
				process(arr, mid + 1, N);
			}
		}
	}

	static void calc() {
		for (int i = 0; i < cnt; i++) {
			if (res[i][1] >= M) {
				index = Math.max(index, res[i][0]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		int[] tree = new int[N + 1];
		res = new int[1000][2];
		for (int i = 1; i <= N; i++) {
			tree[i] = scan.nextInt();
		}
		scan.close();
		Arrays.sort(tree);
		process(tree, 1, N);
		calc();
		System.out.println(index);
	}
}
