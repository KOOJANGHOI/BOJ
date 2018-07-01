

import java.util.Scanner;

public class Q11721 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		for (int i = 0; i < str.length(); i++) {
			if(i!= 0 && i%10==0)
				System.out.println();
			System.out.print(str.charAt(i));
			
		}
	}
}
