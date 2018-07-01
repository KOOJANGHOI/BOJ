

import java.util.Scanner;

public class Q9498 {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		String ans = "";
		ans = ( ((N>=90)&&(N<=100)) ? "A" : ((N>=80)&&(N<90)) ? "B" : ((N>=70)&&(N<80)) ? "C" : ((N>=60)&&(N<70)) ? "D" : "F");
		System.out.println(ans);
	}
}
