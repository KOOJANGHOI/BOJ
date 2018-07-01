

import java.util.Scanner;

public class Q2839 {
	private static Scanner scan;
	public static int findNum(int N) {
		if(N%5 == 0) return N/5;
		int min = 5000;
		for(int i = 0 ; i <= N/5 ; i++) {
			if((N-5*i)%3 == 0 && min > i + (N-5*i)/3) {
				min = i + (N-5*i)/3;
			}
		}
		if(min == 5000)
			return -1;
		return min;
	}
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.println(findNum(N));
	}
}
