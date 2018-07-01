

import java.io.IOException;
import java.util.Scanner;

public class Q11718 {
	private static Scanner scan;
	public static void main(String[] args) throws IOException {
		scan = new Scanner(System.in);
		String line = " ";
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			System.out.println(line);
		}
	}
}
