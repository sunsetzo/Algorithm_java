package boj;

import java.util.*;
import java.io.*;

// 누적합 + 투포인터
public class BOJ1806 {
    static int n, s;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        dp = new int[n];    // 누적합
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if (i==0){
                dp[i] = arr[i];
            }else {
                dp[i] = arr[i]+dp[i-1];
            }
        }

        int left = 0;
        int right = 1;
        int res = Integer.MAX_VALUE;

        while (right <= n){
            if (left >= n) break;
            int diff = dp[right-1] - dp[left] + arr[left];
            if (diff >= s){
                res = Math.min(res, (right-left));
                left ++;
            } else right++;
        }

        System.out.println(res == Integer.MAX_VALUE? 0 : res);

    }
}