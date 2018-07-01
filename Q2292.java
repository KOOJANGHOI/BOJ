

import java.util.Scanner;

public class Q2292 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long N = scan.nextInt();
		scan.close();
		if (N == 1) {
			System.out.println(1);
		} else {
			for (long i = 0; i < 20000; i++) {
				if (1 + 3 * i * (i - 1) < N && N <= 1 + 3 * i * (i + 1))
					System.out.println(i + 1);
			}
		}
	}
}
