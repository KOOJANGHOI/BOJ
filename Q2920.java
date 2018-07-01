

import java.util.Arrays;
import java.util.Scanner;

public class Q2920 {
	
	static String chk(int[] arr, int[] check) {
		if(equals(arr,check)) {
			return "descending";
		}
		Arrays.sort(check);
		if(equals(arr,check)) {
			return "ascending";
		}
		return "mixed";
	}
	
	static boolean equals(int[] arr , int[] arr2) {
		for(int i = 0 ; i < 8 ; i++) {
			if(arr[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[8];
		int[] tmp = new int[8];
		for(int i = 0 ; i < 8 ; i++) {
			arr[i] = scan.nextInt();
			tmp[i] = 8-i;
		}
		System.out.println(chk(arr,tmp));
	}
}
