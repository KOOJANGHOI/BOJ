

import java.util.Scanner;

public class Q14503 {
	static int N,M,R,C,D,cnt=0;
	static int[][] arr;
	private static Scanner scan;
	
	public static void clean1(int x , int y , int d) {
		cnt++;
		arr[x][y] = 2;
		//System.out.println("cleaned!!!["+(x)+"]["+(y)+"]");
		//printarr();
		clean2(x,y,d);
	}
	public static void clean2(int x , int y , int d) {
		if(d == 0 && (x >= 1 && x <= N && y >= 1 && y <= M)) {
			if(arr[x][y-1] == 0) {
				clean1(x,y-1,(d+3)%4);
			} else if(arr[x][y-1] != 0){
				if((arr[x][y-1] != 0) && (arr[x+1][y] == 1) && (arr[x-1][y] != 0) && (arr[x][y+1] != 0)) {
					return ;
				} else if((arr[x][y-1] != 0) && (arr[x+1][y] == 2) && (arr[x-1][y] != 0) && (arr[x][y+1] != 0)) {
					clean2(x+1,y,d);
				} else {
					clean2(x,y,(d+3)%4);
				}
			}
		} else if(d == 1 && (x >= 1 && x <= N && y >= 1 && y <= M)) {
			if(arr[x-1][y] == 0) {
				clean1(x-1,y,(d+3)%4);
			} else if(arr[x-1][y] != 0){
				if((arr[x][y+1] != 0) && (arr[x][y-1] == 1) && (arr[x-1][y] != 0) && (arr[x+1][y] != 0)) {
					return ;
				} else if((arr[x][y+1] != 0) && (arr[x][y-1] == 2) && (arr[x-1][y] != 0) && (arr[x+1][y] != 0)) {
					clean2(x,y-1,d);
				} else {
					clean2(x,y,(d+3)%4);
				}
			}
		} else if(d == 2 && (x >= 1 && x <= N && y >= 1 && y <= M)) {
			if(arr[x][y+1] == 0) {
				clean1(x,y+1,(d+3)%4);
			} else if(arr[x][y+1] != 0){
				if((arr[x][y+1] != 0) && (arr[x-1][y] == 1) && (arr[x][y-1] != 0) && (arr[x+1][y] != 0)) {
					return ;
				} else if((arr[x][y+1] != 0) && (arr[x-1][y] == 2) && (arr[x][y-1] != 0) && (arr[x+1][y] != 0)) {
					clean2(x-1,y,d);
				} else {
					clean2(x,y,(d+3)%4);
				}
			}
		} else if(d == 3 && (x >= 1 && x <= N && y >= 1 && y <= M)) {
			if(arr[x+1][y] == 0) {
				clean1(x+1,y,(d+3)%4);
			} else if(arr[x+1][y] != 0){
				if((arr[x-1][y] != 0) && (arr[x][y+1] == 1) && (arr[x][y-1] != 0) && (arr[x+1][y] != 0)) {
					return ;
				} else if((arr[x-1][y] != 0) && (arr[x][y+1] == 2) && (arr[x][y-1] != 0) && (arr[x+1][y] != 0)) {
					clean2(x,y+1,d);
				} else {
					clean2(x,y,(d+3)%4);
				}
			}
		}
	}
	
	public static void printarr() {
		System.out.println("#############################################");
		for(int i = 0 ; i < N+2 ; i++) {
			for(int j = 0 ; j < M+2 ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("#############################################");
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		R = scan.nextInt();
		C = scan.nextInt();
		D = scan.nextInt();
		arr = new int[N+2][M+2];
		for(int i = 0 ; i < N+2 ; i++) {
			for(int j = 0 ; j < M+2 ; j++) {
				arr[i][j] = 1;
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				arr[i+1][j+1] = scan.nextInt();
			}
		}
		clean1(R+1,C+1,D);
		System.out.println(cnt);
		
	}
}
