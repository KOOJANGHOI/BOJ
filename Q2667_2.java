

import java.util.Arrays;
import java.util.Scanner;

public class Q2667_2 {
	static int N,k=1;
	static int[][] arr,visited;
	static int[] cnt = new int[26*26];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	private static Scanner scan;

	public static void DFS(int x , int y) {
		visited[x][y] = k;
		cnt[k]++;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx < 0 || nx > N || ny < 0 || ny > N)
				continue;
			if(arr[nx][ny] == 1 && visited[nx][ny] == 0)
				DFS(nx,ny);
		}
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N + 1][N + 1];
		visited = new int[N + 1][N + 1];
		scan.nextLine();
		for (int i = 1; i <= N; i++) {
			String str = scan.nextLine();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '1') arr[i][j + 1] = 1;
				if (str.charAt(j) == '0') arr[i][j + 1] = 0;
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N ; j++) {
				if(arr[i][j] == 1 && visited[i][j] == 0) {
					DFS(i,j);
					k++;
				}
			}
		}
		for(int i = 0 ; i < cnt.length ; i++) {
			if(cnt[i] == 0)
				cnt[i] = 1000;
		}
		Arrays.sort(cnt);
		System.out.println(k-1);
		for(int i = 0 ; i < k-1 ; i++) {
			System.out.println(cnt[i]);
		}
	}
}
