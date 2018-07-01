

import java.util.Scanner;

public class Q11726 {
	static int[] arr;
	private static Scanner scan;
	
	// 중간에도 나머지를 취해줘야된다!!!!!!(오버플로 때문)
	static int findNum(int N) {
		if(arr[N] != 0)
			return arr[N];
		arr[N] = findNum(N-1)%10007 + findNum(N-2)%10007;
		return arr[N];
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		arr = new int[N+1];
		arr[0] = arr[1] = 1;
		findNum(N);
		System.out.println(arr[N]%10007);
	}
}
