import java.util.Scanner;

public class Q10942 {
	int N,M;
	int[] num;
	int[][] arr,list;
	
	void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		num = new int[N+1];
		arr = new int[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			num[i] = scan.nextInt();
			arr[i][i] = 1;
		}
		M = scan.nextInt();
		list = new int[M][2];
		for(int i = 0 ; i < M ; i++) {
			list[i][0] = scan.nextInt();
			list[i][1] = scan.nextInt();
		}
		scan.close();
		for(int len = 1 ; len <= 2 ; len++) {
			for(int i = 1 ; i <= N-len ; i++) {
				if(num[i]==num[i+len])
					arr[i][i+len]=1;
			}
		}
		for(int len = 3 ; len < N ; len++) {
			for(int i = 1 ; i <= N-len ; i++) {
				if(num[i]==num[i+len] && arr[i+1][i+len-1]==1)
					arr[i][i+len]=1;
			}
		}
		for(int i = 0 ; i < M ; i++) {
			System.out.println(arr[list[i][0]][list[i][1]]);
		}	
	}

	public static void main(String[] args) {
		new Q10942().solve();
	}
}