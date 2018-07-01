

import java.util.Scanner;

public class Q11052 {
	private static Scanner scan;
	private static int N;
	private static int[] arr = new int[10001];
	private static int[] tarr = new int[10001];
	
	public static int maxprofit(int n) {
		if(tarr[n] != -1)
			return tarr[n];
		
		int ans = Math.max(arr[1]*n, arr[n]);
		for(int i = 1 ; i <= n/2 ; i++) {
			ans = Math.max(ans, arr[i] + maxprofit(n-i));
		}
		
		
		tarr[n] = ans;
		return ans;
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		arr[0] = 0;
		tarr[0] = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
			tarr[i] = -1;
		}
		System.out.println(maxprofit(N));
	}
	
}
