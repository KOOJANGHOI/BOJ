

import java.util.Scanner;

public class Q10250 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		String[] res = new String[t];
		for (int i = 0 ; i < t; i++) {
			int h = scan.nextInt();
			int w = scan.nextInt();
			int n = scan.nextInt();
			int cnt = 0;
			for(int y = 1 ; y <= w ; y++) {
				for(int x = 1 ; x <= h ; x++) {
					cnt++;
					if(cnt==n) {
						if(y<10) {
							res[i] = ""+x+"0"+y+"";
						} else {
							res[i] = ""+x+""+y+"";
						}
						break;
					}
				}
			}
		}
		for(int i = 0 ; i < t ; i++) {
			System.out.println(res[i]);
		}
	}
}
