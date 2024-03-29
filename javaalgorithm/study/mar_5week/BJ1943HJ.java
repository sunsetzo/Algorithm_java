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

            if (sum%2 != 0){
                System.out.println(0);
            }
            else{
                System.out.println(solve(n, sum/2, coins));
            }
        }
    }
    static int solve(int n, int mid, int[][] coins){
        int[][] dp = new int[n+1][mid+1];
        for (int i=0; i<n+1; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i=0; i<n; i++){
            int[] coin = coins[i];
            for (int j=0; j<=mid; j++){
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                if (j+coin[0] <= mid && dp[i][j] < coin[1]){
                    dp[i][j+coin[0]] = Math.min(dp[i][j+coin[0]], dp[i][j]+1);
                }
                dp[i+1][j] = 0;
            }
        }
        if (dp[n][mid]==0) return 1;
        else return 0;
    }
}