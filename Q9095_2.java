

import java.util.Scanner;

public class Q9095_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[11];
		int[] res = new int[11];
		res[1] = 1;
		res[2] = 2;
		res[3] = 4;
		for(int i = 4 ; i <= 10 ; i++) {
			res[i] = res[i-1] + res[i-2] + res[i-3];
		}
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = scan.nextInt();
		}
		for(int i = 1 ; i <= N ; i++) {
			System.out.println(res[arr[i]]);
		}
		
	}
}
