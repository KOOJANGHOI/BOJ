

import java.util.Scanner;

public class Q9095 {
	private static Scanner scan;
	private static int[] num, queue;
	private static int rear = 0, front = 0, cnt;

	public static void push(int num) {
		queue[rear++] = num;
	}

	public static int pop() {
		return queue[front++];
	}

	public static void BFS(int s) {
		push(s);
		while (rear != front) {
			int p = pop();
			if (p >= 1)
				BFS2(p, p - 1);
			if (p >= 2)
				BFS2(p, p - 2);
			if (p >= 3)
				BFS2(p, p - 3);
		}
	}

	public static void BFS2(int m, int n) {
		if ((n == 0 || n == 1) && m != 1) {
			cnt++;
		}
		push(n);
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[11];
		int[] res = new int[11];
		num = new int[11];
		queue = new int[100000];
		for (int i = 0; i <= 10; i++) {
			num[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			cnt = 0;
			BFS(arr[i]);
			res[arr[i]] = cnt;
		}
		res[1] = 1;
		res[2] = 2;
		res[3] = 4;
		for (int i = 1; i <= N; i++) {
			System.out.println(res[arr[i]]);
		}
	}
}
