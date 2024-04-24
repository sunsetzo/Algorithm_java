package study.apr_4week;

import java.io.*;
import java.util.*;

public class BJ1446HJ {
    static int n, d;
    static int[] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n][3];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[d+1];
        for (int i=0; i<=d; i++){
            dp[i] = i;
        }

        for (int i=0; i<=d; i++){
            dp[i] = Math.min(dp[i], (i>0) ? dp[i-1]+1: dp[i]);
            for (int j=0; j<n; j++){
                int s = arr[j][0];
                int e = arr[j][1];
                int w = arr[j][2];
                if (i==s && e<=d){
                    dp[e] = Math.min(dp[e], dp[i]+w);
                }
            }
        }

        System.out.println(dp[d]);

    }
}
