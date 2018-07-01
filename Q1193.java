

import java.util.Scanner;

public class Q1193 {
	static int[] sum = new int[10000];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int X = scan.nextInt();
		scan.close();
		sum[0] = 0;
		sum[1] = 1;
		for (int i = 2; i < 10000; i++) {
			sum[i] = sum[i - 1] + i;
		}
		int n = 0;
		for (int i = 1; i < 10000; i++) {
			if (sum[i - 1] < X && sum[i] >= X) {
				n = i;
				break;
			}
		}
		int cnt = X - sum[n - 1]-1;
		int a = 0;
		int b = 0;
		if (n % 2 == 0) {
			a = 1;
			b = n;
		} else {
			a = n;
			b = 1;
		}
		if (cnt == 0) {
			System.out.println(a + "/" + b);
		} else {
			for (int i = 0; i < cnt; i++) {
				if (n % 2 == 0) {
					a++;
					b--;
				} else {
					a--;
					b++;
				}
			}
			System.out.println(a + "/" + b);
		}
	}
}
