

import java.util.Scanner;

public class Q10845 {
	private static Scanner scanner;

	public static void main(String[] args) {
		Queue queue = new Queue(10000);
		scanner = new Scanner(System.in);
		int commandCtr = scanner.nextInt();
		String command;

		for (int i = 1; i <= commandCtr; i++) {
			command = scanner.next();
			if (command.equals("push")) {
				int x = scanner.nextInt();
				queue.push(x);
			} else if (command.equals("pop")) {
				queue.pop();
			} else if (command.equals("size")) {
				queue.size();
			} else if (command.equals("empty")) {
				queue.empty();
			} else if (command.equals("front")) {
				queue.front();
			} else if (command.equals("back")) {
				queue.back();
			}
		}
	}

	static class Queue {
		private int rear, front;
		private int[] arr;

		public Queue(int size) {
			this.rear = -1;
			this.front = -1;
			this.arr = new int[size];
		}

		public void front() {
			if (rear == front) {
				System.out.println(-1);
			} else {
				System.out.println(arr[front+1]);
			}
		}

		public void back() {
			if (rear == front) {
				System.out.println(-1);
			} else {
				System.out.println(arr[rear]);
			}
		}

		public void empty() {
			if (rear == front) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

		public void size() {
			System.out.println(rear - front);
		}

		public void push(int x) {
			this.arr[++rear] = x;
		}

		public void pop() {
			if (rear == front) {
				System.out.println(-1);
			} else {
				System.out.println(arr[++front]);
			}
		}
	}
}