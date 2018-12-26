import java.text.DecimalFormat;
import java.util.Scanner;

class Q3053 {

	void work() {
		Scanner scan = new Scanner(System.in);
		int R = scan.nextInt();
		scan.close();
		DecimalFormat df = new DecimalFormat("0.000000");
		System.out.println(df.format(Math.PI * R * R));
		System.out.println(df.format(2 * R * R));
	}

	public static void main(String a[]) {
		new Q3053().work();
	}
}