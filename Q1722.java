import java.util.Scanner;

class Q1722 {
	long[] fac;

	long factorial(int n) {
		if (fac[n] != -1)
			return fac[n];
		fac[n] = n * factorial(n - 1);
		return fac[n];
	}

	void work() {
		fac = new long[21];
		for (int i = 2; i < 21; i++) {
			fac[i] = -1;
		}
		fac[0] = fac[1] = 1;
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long k = scan.nextInt();
		long[] arr = new long[N];
		if (k == 1) {
			long[] chk = new long[N + 1];
			long cnt = scan.nextLong();
			for (int i = 0; i < N - 1; i++) {
				long index = (cnt - 1) / factorial(N - i - 1) + 1;
				long temp = 0;
				for (int j = 1; j <= N; j++) {
					if (chk[j] == 0) {
						temp++;
						if (temp == index) {
							chk[j] = 1;
							arr[i] = j;
							break;
						}
					}
				}
				cnt = (cnt - 1) % factorial(N - i - 1) + 1;
			}
			for (int j = 1; j <= N; j++) {
				if (chk[j] == 0)
					arr[N - 1] = j;
			}
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < N; i++) {
				arr[i] = scan.nextInt();
			}
			long answer = 0;
			for (int i = 0; i < N; i++) {
				long index = 1;
				for (int j = i + 1; j < N; j++) {
					if (arr[i] > arr[j])
						index++;
				}
				if (i == N - 1) {
					answer++;
				} else {
					answer += (index - 1) * factorial(N - i - 1);
				}
			}
			System.out.println(answer);
		}
		scan.close();
	}

	public static void main(String a[]) {
		new Q1722().work();
	}
}