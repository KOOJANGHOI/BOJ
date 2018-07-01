
import java.util.Scanner;

public class Q1157 {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String str = scan.nextLine().toUpperCase();
		int[] arr = new int[123];
		for(int i = 0 ; i < str.length() ; i++) {
			arr[(int)str.charAt(i)]++;
		}
		
		int max = 0;
		int key = 1;
		for(int i = 0 ; i < 123 ; i++) {
			max = Math.max(max, arr[i]);
		}
		int tmp = 0;
		for(int i = 0 ; i < 123 ; i++) {
			if(arr[i] == max) {
				tmp++;
				key = i;
			}
		}
		if(tmp == 1) {
			String test = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
			for(int i = 0 ; i < test.length() ; i++) {
				if((int)test.charAt(i) == key)
					System.out.println(Character.toUpperCase(test.charAt(i)));
			}
		} else {
			System.out.println("?");
		}
	}
}
