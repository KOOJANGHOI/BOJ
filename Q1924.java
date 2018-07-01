

import java.util.Scanner;

public class Q1924 {
	public static int[] arr = new int[13];
	private static Scanner scan;
	
	public static void init() {
		for(int i = 1 ; i <= 12 ; i++) {
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
				arr[i] = 31;
			if(i == 4|| i == 6 || i == 9 || i == 11)
				arr[i] = 30;
			if(i == 2)
				arr[i] = 28;
		}
	}
	
	public static String result(int x , int y) {
		int total = 0;
		if(x == 1) {
			total = y;
		} else {
			for(int i = 1 ; i < x ; i++) {
				total += arr[i];
			}
			total += y;
		}
		
		switch((total-1)%7) {
		case 0:
			return "MON";
		case 1:
			return "TUE";
		case 2:
			return "WED";
		case 3:
			return "THU";
		case 4:
			return "FRI";
		case 5:
			return "SAT";
		case 6:
			return "SUN";
		}
		return null;
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		init();
		System.out.println(result(x,y));
		
	}
}
