import java.util.Scanner;

class Q9252 {

	void work() {
		int[][] arr = new int[1009][1009];
		int answer = 0;
		String str = "";

		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		for (int i = 2; i <= str1.length() + 1; i++) {
			arr[0][i] = str1.charAt(i - 2);
		}
		String str2 = scan.nextLine();
		for (int i = 2; i <= str2.length() + 1; i++) {
			arr[i][0] = str2.charAt(i - 2);
		}
		scan.close();

		for (int i = 2; i <= str2.length() + 1; i++) {
			for (int j = 2; j <= str1.length() + 1; j++) {
				if (arr[i][0] == arr[0][j]) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}

		answer = arr[str2.length() + 1][str1.length() + 1];
		int x = str2.length() + 1;
		int y = str1.length() + 1;
		while (x * y > 0) {
			if (arr[x][0] == arr[0][y]) {
				str += (char) arr[x][0];
				x = x - 1;
				y = y - 1;
			} else {
				if (arr[x][y - 1] > arr[x - 1][y]) {
					y = y - 1;
				} else {
					x = x - 1;
				}
			}
		}

		System.out.println(answer);
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) != '0') {
				System.out.print(str.charAt(i));
			}
		}
		System.out.println();
	}

	public static void main(String a[]) {
		new Q9252().work();
	}
}