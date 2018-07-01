

import java.util.Scanner;

public class tmp {
  
    static int N; // 동전의 단계수
    static int W; // 잔돈
    static int[] coin; // 동전종류
    static int[][] D;
    static int INF = 0x3FFFFFFF;
      
    static int Dynamic() {
        for(int i=1; i<=W; i++) D[0][i] = INF;
        for(int i=0; i<=N; i++) D[i][0] = 0;
         
        for(int i=1; i<=N; i++) { // 동전 인덱스
            for(int j=1;j<=W; j++) { // 돈인덱스
                if(coin[i]>j) {
                    D[i][j] = D[i-1][j]; // i번째 동전으로는 만들수 없으므로 이전동전으로 만든값을 복사한다.
                } else if(D[i-1][j] > D[i][j-coin[i]]+1) {
                    // 이전동전으로 만든값보다 새롭게 만들려는 동전수가 더 많으면
                    // 그값을 취한다.
                    D[i][j] = D[i][j-coin[i]] + 1;
                } else {
                    // 나머지는 위에값을 복사한다.
                    D[i][j] = D[i-1][j];
                }
            }
              
        }
        return D[N][W];
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coin = new int[N+10];
        D = new int[20][64010];
          
        for (int i = 1; i <= N; i++) {
            coin[i] = sc.nextInt();
        }
        W = sc.nextInt();
          
        int ans  = Dynamic();
        if(ans >=INF) System.out.println("impossible");
        else System.out.println(ans);       
        sc.close();
    }
  
}