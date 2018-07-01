

import java.util.Scanner;

public class Q1110 {
	static int cnt = 0;
	private static Scanner scan;

	public static void findNum(Digit ori, Digit num) {
		if(cnt != 0 && ori.equals(num))
			return ;
		cnt++;
		Digit temp = new Digit(num.y, num.Sum() % 10);
		findNum(ori, temp);
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		Digit ori;
		if (N < 10) {
			ori = new Digit(0, N);
		} else {
			ori = new Digit(N / 10, N % 10);
		}
		findNum(ori, ori);
		System.out.println(cnt);
	}
}

class Digit {
	int x;
	int y;

	public Digit(int _x, int _y) {
		x = _x;
		y = _y;
	}

	public int Sum() {
		return x + y;
	}

	public boolean equals(Digit o) {
		return x == o.x && y == o.y;

	}
}
