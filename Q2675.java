

import java.util.Scanner;

public class Q2675 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] cnt = new int[N];
		String[] arr = new String[N+1];
		for(int i = 0 ; i < N ; i++) {
			cnt[i] = scan.nextInt();
			String str = scan.nextLine();
			for(int j = 0 ; j < str.length() ; j++) {
				for(int k = 0 ; k < cnt[i] ; k++) {
					arr[i] += ""+str.charAt(j);		
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 4 ; j < arr[i].length() ; j++) {
				if(arr[i].charAt(j) != ' ')
				System.out.print(arr[i].charAt(j));
			}
			System.out.println();
		}
	}
}
