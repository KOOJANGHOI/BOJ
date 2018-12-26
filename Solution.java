import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();

		List<Integer> a = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		sc.close();
		for (int i = d; i < d + n; i++) {
			System.out.print(a.get(i % n) + " ");
		}
	}
}