

import java.util.Scanner;

public class Q2805_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] tree = new int[N + 1];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			tree[i] = scan.nextInt();
			max = Math.max(max, tree[i]);
		}
		scan.close();
		int left = 1,right=max;
		while(left <= right) {
			int mid = (left+right)/2;
			long sum = 0;
			for(int i = 1 ; i <= N ; i++) {
				if(tree[i] > mid)
					sum += (tree[i]-mid);
			}
			if(sum < M) {
				right = mid-1;
			} else {
				left = mid+1;
			}	
		}
		System.out.println(right);
	}
}
