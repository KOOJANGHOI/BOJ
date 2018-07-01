

import java.util.Scanner;

public class Q11091 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = Integer.parseInt(scan.nextLine());
		String[] result = new String[T];
		for(int i = 0 ; i < T ; i++) {
			String str = scan.nextLine().toLowerCase();
			String res = "";
			boolean chk = true;
			int[] arr = new int[10000];
			for(int j = 0 ; j < str.length() ; j++) {
				arr[str.charAt(j)] = 1;
			}
			for(int j = 97 ; j < 123 ; j++) {
				if(arr[j] != 1) {
					chk = false;
					res+= ""+(char) j;
				}
			}
			if(chk) {
				result[i] = "pangram";
			} else {
				result[i] = "missing "+ res;
			}
		}
		for(int i = 0 ; i < T ; i++) {
			System.out.println(result[i]);
		}
	}
}
