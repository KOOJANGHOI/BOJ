

import java.util.Arrays;
import java.util.Scanner;

public class Q1978 {

	static int[] process() {
		int[] arr = new int[1001];
		int[] ret = new int[1001];
		for (int i = 1; i <= 1000; i++) {
			arr[i] = i;
		}
		for (int i = 2; i < 1000; i++) {
			int temp = arr[i];
			if (temp != -1) {
				for (int j = i + 1; j <= 1000; j++) {
					if (arr[j] % temp == 0) {
						arr[j] = 1111;
					}
				}
			}
		}
		arr[0] = 1111;
		arr[1] = 1111;
		Arrays.sort(arr);
		for(int i = 0 ; i < 168 ; i++) {
			ret[arr[i]] = 1;
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		int[] res = new int[1001];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		res = process();
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			if(res[arr[i]] == 1)
				cnt++;
		}
		System.out.println(cnt);
	}
}