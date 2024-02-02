package study.jan_5week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2839HJ_dp {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        int[] dp_set = {-1, -1, -1, 1, -1, 1, 2, -1};

        if (n<=7){
            System.out.println(dp_set[n]);
        }else {
            for (int i = 0; i <= 7; i++) {
                dp[i] = dp_set[i];
            }

            for (int i = 8; i < n + 1; i++) {
                if (dp[i - 3] != -1 && dp[i - 5] != -1) {
                    dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
                } else if (dp[i - 3] != -1) {
                    dp[i] = dp[i - 3] + 1;
                } else if (dp[i - 5] != -1) {
                    dp[i] = dp[i - 5] + 1;
                } else {
                    dp[i] = -1;
                }
            }
            System.out.println(dp[n]);
        }
    }
}