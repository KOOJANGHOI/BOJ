

import java.util.Scanner;

public class Q1152 {

	private static Scanner scan;

	public static int findNum(String str) {
		String[] arr = new String[1000000];
		int num = 0;
		arr = str.split(" ");
		for(String a : arr) {
			//System.out.println(a);
			if(!a.equalsIgnoreCase(""))
				num++;
		}
		return num;
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String str = scan.nextLine();
		System.out.println(findNum(str));
	}
}
