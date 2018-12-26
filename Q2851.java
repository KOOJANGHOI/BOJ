import java.util.Scanner;

class Q2851 {

	void work() {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		int[] sum = new int[10];
		int temp = 0;
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			arr[i] = scan.nextInt();
			temp += arr[i];
		}
		scan.close();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 - i; j++) {
				sum[i] += arr[j];
			}
			if (Math.abs(temp - 100) > Math.abs(sum[i] - 100)) {
				temp = sum[i];
				answer = Math.max(answer, i);
			}
		}
		System.out.println(sum[answer]);
	}

	public static void main(String a[]) {
		new Q2851().work();
	}
}