import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class lotto {
	List<Integer> truth;
	int secondBonus;
	int[] prize;

	void work() {
		Scanner scan = new Scanner(System.in);
		System.out.print("count:");
		int cnt = scan.nextInt();
		scan.nextLine();
		generateTruth();
		prize = new int[6];
		for (int i = 0; i < cnt; i++) {
			calc();
		}
		for(int i = 1 ; i < 6 ; i++) {
			System.out.println("["+i+"등 : " + prize[i] +" 회 ]");
		}

	}

	void generateTruth() {
		Random rand = new Random();
		truth = new ArrayList<>();
		secondBonus = 0;
		int[] chk = new int[46];
		do {
			int num = rand.nextInt(45) + 1;
			if (chk[num] == 0) {
				truth.add(num);
				chk[num] = 1;
			}
		} while (truth.size() < 6);

		do {
			int num = rand.nextInt(45) + 1;
			if (chk[num] == 0) {
				secondBonus = num;
			}
		} while (secondBonus == 0);
		Collections.sort(truth);
	}

	void calc() {
		Random rand = new Random();
		List<Integer> ans = new ArrayList<>();
		int[] chk = new int[46];
		do {
			int num = rand.nextInt(45) + 1;
			if (chk[num] == 0) {
				ans.add(num);
				chk[num] = 1;
			}
		} while (ans.size() < 6);
		Collections.sort(ans);

		int num = 0;
		boolean second = false;
		for (Integer i : ans) {
			if (truth.contains(i)) {
				num++;
			}
			if (i == secondBonus)
				second = true;
		}

		switch (num) {
		case 3:
			prize[5]++;
			break;
		case 4:
			prize[4]++;
			break;
		case 5:
			if (second) {
				prize[2]++;
			} else {
				prize[3]++;
			}
			break;
		case 6:
			prize[1]++;
			break;
		default:
			break;
		}

	}

	public static void main(String[] args) {
		new lotto().work();
	}
}
