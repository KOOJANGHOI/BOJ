

import java.util.Scanner;

public class Q10809 {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int[] arr = new int[26];
		for(int i = 0 ; i < 26 ; i++) {
			arr[i] = -2;
		}
		String str = scan.next();
		for(int i = 0 ; i < str.length() ; i++) {
			if(arr[(int)str.charAt(i)-97] == -2)
				arr[(int)str.charAt(i)-97] = i;
		}
		for(int i = 0 ; i < 26 ; i++) {
			if(arr[i] == -2) {
				System.out.print("-1 ");
			} else {
				System.out.print(arr[i]+" ");
			}
		}
	}
}
