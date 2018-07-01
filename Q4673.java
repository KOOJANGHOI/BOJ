

public class Q4673 {
	static int[] arr = new int[10001];
	
	static void process(int num) {
		int temp = num;
		int sum = num;
		while(temp/10 >= 1) {
			sum += temp%10;
			temp = temp/10;
		}
		sum += temp%10;
		if(sum <= 10000)
			arr[sum]++;
	}
	
	public static void main(String[] args) {
		for(int i = 1 ; i <= 10000 ; i++) {
			process(i);
		}
		for(int i = 1 ; i <= 10000 ; i++) {
			if(arr[i] == 0)
			System.out.println(i);
		}
	}
}
