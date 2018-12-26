import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class NEEXTRACT {

	void work() throws Exception {
		BufferedReader bf = new BufferedReader(
				new FileReader("/Users/KJH/NewLibrec/data/citeulike/u1_OCCF.test.predict"));
		BufferedReader bf2 = new BufferedReader(new FileReader("/Users/KJH/NewLibrec/data/citeulike/u1.base"));
		BufferedReader bf3 = new BufferedReader(new FileReader("/Users/KJH/NewLibrec/data/citeulike/test/u1.test"));
		PrintWriter pw = new PrintWriter("/Users/KJH/NewLibrec/data/interesting/citeulike/interesting.txt");

		String str;
		List<List<Node>> pos = new ArrayList<>();
		List<List<Node>> list = new ArrayList<>();
		List<Node> list2 = new ArrayList<>();
		List<Node> test = new ArrayList<>();
		System.out.println("START");
		for (int i = 0; i < 6000; i++) {
			pos.add(new ArrayList<>());
			list.add(new ArrayList<>());
		}
		int MAXU = -1;

		while ((str = bf2.readLine()) != null) {
			String[] ss = str.split("\t");
			int user = Integer.parseInt(ss[0]);
			int item = Integer.parseInt(ss[1]);
			pos.get(user).add(new Node(user, item, 1));

			MAXU = Math.max(MAXU, user);

		}

		while ((str = bf3.readLine()) != null) {
			String[] ss = str.split("\t");
			int user = Integer.parseInt(ss[0]);
			int item = Integer.parseInt(ss[1]);
			test.add(new Node(user, item, 1));
		}

		int tcnt = 0;
		while ((str = bf.readLine()) != null) {
			String[] ss = str.split(" ");
			if(tcnt < 3) {
				System.out.println(str);
				tcnt++;
				continue;
			}
			int user = Integer.parseInt(ss[0]);
			int item = Integer.parseInt(ss[1]);
			double value = Double.parseDouble(ss[ss.length - 1]);

			boolean check = false;
			for (int i = 0; i < pos.get(user).size() && !check; i++) {
				if (pos.get(user).get(i).right == item)
					check = true;
			}

			if (check) {
				continue;
			}
			// list.get(user).add(new Node(user, item, value));
			list2.add(new Node(user, item, value));
		}
		Collections.sort(list2);
		List<Node> interesting = new ArrayList<>();
		// 75,87,92,94,95
		// 18, 30, 40, 47, 54, 59, 63, 67, 70
		int cnt = 0;
		for (int i = 0; i < list2.size() * 0.1; i++) {
			pw.printf("%d\t%d\t%f\n", list2.get(i).left, list2.get(i).right, list2.get(i).value);
			if (test.contains(list2.get(i)))
				cnt++;

		}

		System.out.println(100.0 * cnt / 20000);
		// System.out.println("DONE");
		// for (int u = 1; u <= MAXU; u++) {
		// Collections.sort(list.get(u));
		// for (int i = 0; i < pos.get(u).size(); i++) {
		// pw.printf("%d\t%d\t%f\n", list.get(u).get(i).left, list.get(u).get(i).right,
		// list.get(u).get(i).value);
		// }
		// }
		pw.close();
		bf.close();
		bf2.close();
	}

	public class Node implements Comparable<Node> {

		int left;
		int right;
		double value;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}

		public Node(int left, int right, double value) {
			this(left, right);
			this.value = value;
		}

		public int getLeft() {
			return left;
		}

		public int getRight() {
			return right;
		}

		public double getValue() {
			return value;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (value < o.value)
				return 1;
			else if (value == o.value) {
				return 0;
			}
			return -1;
		}

		// @Override
		// public int compareTo(Node o) {
		// // TODO Auto-generated method stub
		// if (left < o.left)
		// return -1;
		// else if (left == o.left) {
		// if (value < o.value)
		// return 1;
		// else if (value == o.value)
		// return 0;
		// else
		// return -1;
		// }
		// return 1;
		// }
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("%d\t%d\t%f", left, right, value);

		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if (obj instanceof Node) {
				Node o = (Node) obj;
				if (o.left == this.left && o.right == this.right) {
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new NEEXTRACT().work();
	}

}