

import java.util.Arrays;
import java.util.Scanner;

public class Q2751 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		for(int i = 0 ; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}
