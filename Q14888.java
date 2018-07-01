

import java.util.Scanner;

public class Q14888 {
	private static Scanner scan;
	static int N;
	static long max = -1000000001, min = 1000000001;
	static long[] nums;

	private static void permute(int[] arr, int l, int r) {
		if (l == r) {
			calc(copy(nums), arr);
			return;
		} else {
			for (int i = l; i <= r; i++) {
				arr = swap(arr, l, i);
				permute(arr, l + 1, r);
				arr = swap(arr, l, i);
			}
			return;
		}
	}

	public static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static long[] copy(long[] original) {
		long[] temp = new long[N + 1];
		for (int i = 0; i <= N; i++) {
			temp[i] = original[i];
		}
		return temp;
	}

	public static void calc(long[] nums, int[] arr) {
		for (int i = 1; i <= N - 1; i++) {
			switch (arr[i - 1]) {
			case 0:
				nums[i + 1] = (nums[i] + nums[i + 1]);
				break;
			case 1:
				nums[i + 1] = (nums[i] - nums[i + 1]);
				break;
			case 2:
				nums[i + 1] = (nums[i] * nums[i + 1]);
				break;
			case 3:
				if (nums[i] < 0 && nums[i + 1] > 0) {
					nums[i + 1] = -((-nums[i]) / (nums[i + 1]) );
				} else {
					nums[i + 1] = ((nums[i]) / (nums[i + 1]));
				}
				break;
			}
		}
		max = Math.max(max, nums[N]);
		min = Math.min(min, nums[N]);
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		nums = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = scan.nextInt();
		}
		
		int[] calarr = new int[4];
		for(int i = 0 ; i < 4 ; i++) {
			calarr[i] = scan.nextInt();
		}

		int[] arr = new int[N - 1];
		for(int i = 0 ; i < N-1 ; i++) {
			if(i < calarr[0]) {
				arr[i] = 0;
			} else if(i < calarr[0]+calarr[1]) {
				arr[i] = 1;
			} else if(i < calarr[0] + calarr[1] + calarr[2]) {
				arr[i] = 2;
			} else {
				arr[i] = 3;
			}
		}
	
		permute(arr, 0, N - 2);
		System.out.println(max);
		System.out.println(min);
	}
}
