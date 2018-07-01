

import java.util.Scanner;

public class Q10039 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		for(int i = 0 ; i < 5 ; i++) {
			int score = scan.nextInt();
			if(score <= 40) {
				sum += 40;
			} else {
				sum += score;
			}
		}
		System.out.println(sum/5);
	}
}
