// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    int[] array, tempMergArr;
	int length;

	void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	void doMergeSort(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			doMergeSort(lowerIndex, middle);
			doMergeSort(middle + 1, higherIndex);
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	void mergeParts(int lowerIndex, int middle, int higherIndex) {
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}
	}
    
    public int solution(int[] A) {
        sort(A);
        
        System.out.println("=========================");
        for(int i = 0 ; i < A.length ; i++) {
        		System.out.print(A[i]+" ");
        }
        System.out.println();
        System.out.println("=========================");
        
		long ans = 0;
		for(int i = 0 ; i < A.length ; i++) {
			ans += A[i]*(A.length-i);
		}
		ans -= A[0];
		return (int)ans;
    }
    
    public static void main(String[] args) {
    	 	int[] A = {1000,250,100};
		System.out.println(new Solution().solution(A));
	}
}