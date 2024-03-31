package study.mar_5week;

import java.io.*;
import java.util.*;

public class BJ1943HJ {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 0; tc<3; tc++){
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            int[][] coins = new int[n][2];
            for (int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                coins[i][0] = price; coins[i][1] = num;
                sum += price*num;
            }
            // 2로 나눠지지 않으면 불가능한 경우
            if (sum%2 != 0){
                System.out.println(0);
            }
            // 그 외,
            else{
                System.out.println(solve(n, sum/2, coins));
            }
        }
    }
    static int solve(int n, int mid, int[][] coins){
        int[][] dp = new int[n+1][mid+1];
        // 최소갯수를 구하기 때문에 최댓값으로 초기화
        for (int i=0; i<n+1; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 0;

        // DP[i][x] : i 번째 동전을 사용할 때 x 원을 표현하기 위해 사용한 동전의 최소 개수

        for (int i=0; i<n; i++){
            int[] coin = coins[i];
            for (int j=0; j<=mid; j++){
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                if (j+coin[0] <= mid && dp[i][j] < coin[1]){
                    dp[i][j+coin[0]] = Math.min(dp[i][j+coin[0]], dp[i][j]+1);
                }
                dp[i+1][j] = 0;  //무게 j가 업데이트 됐다는 것을 의미.


            }
        }
        // dp[n][mid]==0이라면 반으로 나눌 수 있다는 의미
        if (dp[n][mid]==0) return 1;
        else return 0;
    }
}

// 참고자료 : https://blog.naver.com/adamdoha/222086394461