package study.jan_5week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11053HJ {
    static int n, res;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i=1; i<n; i++){
            for (int j=0; j<i; j++){
                if (arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for (int i=0; i<n; i++){
            if (res < dp[i]){
                res = dp[i];
            }
        }

        System.out.println(res);
    }
}