

import java.util.Scanner;

public class Q2156 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N+1];
		long[] val = new long[N+1];
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		long max = 0;
		if(N==1) { // 1번째 잔을 마신다.
			max = arr[1];
		} else if(N==2) { // 1,2 번째 잔을 마신다.
			max = arr[1]+arr[2];
		} else {	// 3번째 잔까지는 (1,2),(1,3),(2,3) 중에 마시는게 최대.
			val[1] = arr[1];
			val[2] = arr[1]+arr[2];
			val[3] = arr[3] + Math.max(arr[1], arr[2]);
			val[3] = Math.max(val[3], val[2]);
			max = val[3];
			if(N == 3) {
				
			} else { // 4번째 잔 부터
				for(int i = 4 ; i <= N ; i++) {
					val[i] = arr[i] + Math.max(val[i-2], val[i-3]+arr[i-1]); // (i-2번쨰 까지 마시고 i번째 마실때 ,i-3번째 까지 마시고 , i-1,i번째 마실때
					val[i] = Math.max(val[i], val[i-1]); // i번째 잔 안마실때
					max = Math.max(max, val[i]); // 셋중의 최대값. 계속 갱신.
				}
			}
		}
		System.out.println(max);
	}
}