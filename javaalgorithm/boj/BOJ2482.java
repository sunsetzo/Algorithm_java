package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2482 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int mod = 1000000003;

        int[][] dp = new int[n+1][k+1];

        for (int i=0; i<n+1; i++){
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for (int i=2; i<n+1; i++){
            for (int j=2; j<k+1; j++){
                if (i==n){
                    dp[i][j] = dp[i-3][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i-2][j-1];
                }
            }
        }
        System.out.println(dp[n][k]%mod);
    }
}
