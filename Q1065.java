

import java.util.Scanner;

public class Q1065 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		if (N < 100) {
			System.out.println(N);
		} else {
			int[] chk = new int[N + 1];
			int cnt = 0;
			for (int i = 100; i <= N; i++) {
				String str = Integer.toString(i);
				int[] arr = new int[str.length()];
				for (int j = 0; j < str.length(); j++) {
					arr[j] = (int) str.charAt(j) - 48;
				}
				int r = arr[1] - arr[0];
				for (int j = 1; j < str.length() - 1; j++) {
					if (arr[j + 1] - arr[j] != r) {
						chk[i] = 1;
						break;
					}
				}
			}
			for (int i = 100; i <= N; i++) {
				if (chk[i]==0)
					cnt++;
			}
			System.out.println(99 + cnt);
		}
	}
}
