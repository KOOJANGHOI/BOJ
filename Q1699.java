import java.util.Scanner;

public class Q1699 {

	void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.close();
		int[] dp = new int[100001];
		dp[0]=0;
		for(int i = 1 ; i <= N ; i++) {
			int min = 100001;
			for(int j = 1 ; j <= Math.sqrt(i) ; j++) {
				min = Math.min(min, dp[i-j*j]+1);
			}
			dp[i]=min;
		}
		System.out.println(dp[N]);
		
	}

	public static void main(String[] args) {
		new Q1699().solve();
	}
}
