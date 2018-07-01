

import java.util.Scanner;

public class Q4344 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		double[] res = new double[T];
		for(int i = 0 ; i < T ; i++) {
			int N = scan.nextInt();
			int[] arr = new int[N];
			int sum = 0;
			for(int j = 0 ; j < N ; j++) {
				arr[j] = scan.nextInt();
				sum += arr[j];
			}
			int cnt = 0;
			for(int k = 0 ; k < N ; k++) {
				if(arr[k] > sum/N)
					cnt++;
			}
			double ratio = (double)cnt*100/N;
			res[i] = ratio;
		}
		for(int i = 0 ; i < T ; i++) {
			System.out.printf("%.3f",res[i]);
			System.out.println("%");
		}
	}
}
