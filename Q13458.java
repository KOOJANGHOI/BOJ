

import java.util.Scanner;
import java.math.*;

public class Q13458 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = scan.nextInt();
		}
		int B = scan.nextInt();
		int C = scan.nextInt();
		long sum = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(arr[i]<B) {
				sum += 1;
			} else {
				sum += (int)Math.ceil((double)(arr[i]-B)/C)+1;
			}
		}
		System.out.println(sum);
	}
}