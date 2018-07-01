
import java.util.Arrays;
import java.util.Scanner;


public class Combination {
	// 삼성 sw 역량테스트 2017-2 1번.
	private static Scanner scan;
	static int N,k=1;
	static int[][] arr;
	static int[] res;

	public static void combination(int[] num, int index, int n, int r, int target) {
		if (r == 0)
			calc(num, index);
		else if (target == n)
			return;
		else {
			num[index] = target;
			combination(num, index + 1, n, r - 1, target + 1);
			combination(num, index, n, r, target + 1);
		}
	}

	public static void calc(int[] num, int length) {
		for(int i = 0 ; i < N ; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		
		
		int[] num2 = new int[N+1];
		for (int i = 0; i < length; i++) {
			num2[i+1]= num[i];
		}
		for (int i = 1; i <= length; i++) {
			num2[i]++;
		}
		int[] tmp = new int[N+1];
		for (int i = 1 ; i <= length; i++) {
			if(num2[i] != 0) {
				tmp[num2[i]] = 1;
			}
		}
		int sum1 = 0 , sum2 = 0;
		for(int i = 1 ; i < N ; i++) {
			for(int j = i+1 ; j <= N ; j++) {
				if(tmp[i] == 1 && tmp[j] == 1) {
					sum1 += arr[i][j];
					sum1 += arr[j][i];
				} else if(tmp[i] == 0 && tmp[j] == 0) {
					sum2 += arr[i][j];
					sum2 += arr[j][i];
				}
			}
		}
		res[k] = Math.abs(sum1-sum2);
		k++;
	}	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			arr = new int[N + 1][N + 1];
			res = new int[N*N];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = scan.nextInt();
				}
			}
			
			int[] num = new int[N];
			combination(num, 0, N, N/2, 0);
			
			for(int i = 0 ; i < N*N ; i++) {
				if(res[i] == 0)
					res[i] = 10000;
			}
			Arrays.sort(res);
			System.out.println("#"+t+" "+res[0]);
		}
	}
}
