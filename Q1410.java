

import java.util.Scanner;

public class Q1410 {
	private static Scanner scan;
	private static int[] T = new int[16];
	private static int[] data = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
	private static String[] arr = new String[15];
	private static int N , K;
	private static String[] comb_arr = new String[10000];
	private static int comb_size = 0;

	private static void Comb(int n, int r, int q){
	    if(r == 0){
	    		String[] temp_arr = new String[q];
	    		for(int i = 0 ; i < q ; i++){
	    			temp_arr[i] = arr[T[i]];
	        }
	    		String temp2 = findPatternNum(temp_arr,q);
	    		comb_arr[comb_size] = temp2;
	    		comb_size++;
	        return;
	    }else if(n<r){
	        return;
	    }
	    else { 
	        T[r-1] = data[n-1];
	        Comb(n-1, r-1 , q); 
	        Comb(n-1, r , q);   
	    }
	}
	
	public static int combination(int n, int r) { 
		if(n == r || r == 0) 
			return 1; 
		else 
			return combination(n - 1, r - 1) + combination(n - 1, r); 
	}

	private static boolean isSamePattern(String str1 , String str2) {
		if(str1.length() != str2.length())
			return false;
		int len = str1.length();
		for(int i = 0 ; i < len ; i++) {
			if(!((str1.charAt(i) == str2.charAt(i)) || str1.charAt(i) == '?' || str2.charAt(i) == '?')) {
				return false;
			}
		}
		return true;
	}
	
	private static String findPatternNum(String[] arr, int N) {
		int size = arr[0].length();
		String answer = "";
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < N ; j++) {
				char temp = arr[j].charAt(i);
				if(temp != '?') {
					answer += temp;
					break;
				}
			}
			if(answer.length() != i+1) {
				answer += "?";
			}
		}
		return answer;
	}
	
	private static String[] findPatternNum2(String[] arr , int N, int K) {
		int tmp = combination(N,K);
		String[] ans = new String[tmp];
		int count = 0;
		Comb(N,K,K);
		for(int i = 0 ; i < tmp ; i++) {
			count = 0;
			for(int j = 0 ; j < N ; j++) {
				if(isSamePattern(comb_arr[i],arr[j]))
					count++;
			}
			if(count != K)
				comb_arr[i] = "";
		}
		for(int i = 0 ; i < tmp ; i++) {
			ans[i] = comb_arr[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		int answer = 0;
		int tmp = 0;
		String[] tarr = new String[16];
		for (int i = 0; i <= N; i++) {
			tarr[i] = scan.nextLine();
		}
		for (int i = 0; i < N; i++) {
			arr[i] = tarr[i+1];
		}
		
		if(N == K) {
			String temp = findPatternNum(arr,N);
			answer = 1;
			for(int i = 0 ; i < temp.length() ; i++) {
				if(temp.charAt(i) == '?')
					answer *= 26;
			}
		} else {
			String[] temp = findPatternNum2(arr,N,K);
			int index = combination(N, K);
			answer = 0;
			for(int i = 0 ; i < index ; i++) {
				tmp = 1;
				System.out.println(""+i+"th: "+temp[i]);
				if(temp[i] != "") {
					for(int j = 0 ; j < arr[0].length() ; j++) {
						if(temp[i].charAt(j) == '?')
							tmp *= 26;
					}
				}
				answer += tmp;
			}	
		}
		System.out.println(answer%1000003);
		
	}
}
