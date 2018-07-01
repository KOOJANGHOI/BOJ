

import java.util.Scanner;

public class Q1546 {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		double[] arr = new double[N];
		double max = 0;
		double sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
			max = Math.max(max, arr[i]);
		}
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i] * 100 / max;
			sum += arr[i];
		}
		System.out.printf("%.2f",Math.round(sum/N*100d)/100d);
	}
}
