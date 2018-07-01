

import java.util.Scanner;

public class Q13417 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = Integer.parseInt(scan.nextLine());
		String[] arrs = new String[T];
		for(int i = 0 ; i < T ; i++) {
			int len = Integer.parseInt(scan.nextLine());
			int[] arr = new int[len+1];
			String str = scan.nextLine();
			for(int j = 1 ; j <= len ; j++) {
				arr[j] = str.charAt(2*(j-1));
			}
			String res = ""+(char)arr[1];
			for(int j = 2 ; j <= len ; j++) {
				if((char)arr[j] <= res.charAt(0)) {
					res = (char)arr[j] + "" + res;
				} else {
					res += ""+(char)arr[j];
				}
			}
			arrs[i] = res;
		}
		for(int i = 0 ; i < T  ; i++) {
			System.out.println(arrs[i]);
		}
	}
}
