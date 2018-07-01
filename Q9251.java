
import java.util.Scanner;

public class Q9251 {
	void solve() {
		Scanner scan = new Scanner(System.in);
		String[] str = new String[2];
		int[] len = new int[2];
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		scan.close();
		int len1 = str1.length();
		int len2 = str2.length();
		if (len1 < len2) {
			str[0] = str1;
			str[1] = str2;
			len[0] = len1;
			len[1] = len2;
		} else {
			str[0] = str2;
			str[1] = str1;
			len[0] = len2;
			len[1] = len1;
		}
		int[][] arr = new int[len[0] + 1][len[1] + 1];
		for (int i = 0; i <= len[0]; i++) {
			for (int j = 0; j <= len[1]; j++) {
				if (i == 0 || j == 0)
					arr[i][j] = 0;
			}
		}
		for (int i = 1; i <= len[0]; i++) {
			for (int j = 1; j <= len[1]; j++) {
				if (str[0].charAt(i - 1) == str[1].charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
				}
			}
		}
		int max = 0;
		for (int i = 0; i <= len[0]; i++) {
			for (int j = 0; j <= len[1]; j++) {
				max = Math.max(max, arr[i][j]);
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new Q9251().solve();
	}
}
