package study.may_3week;

import java.io.*;
import java.util.*;

public class BJ2240HJ {
    static int t, w;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        // [현재 위치][시간][이동횟수]
        dp = new int[t+1][w+2][2];
        int[] tree = new int[t+1];
        for (int i=1; i<=t; i++){
            tree[i] = Integer.parseInt(br.readLine());
        }

        for (int i=1; i<=t; i++){
            for (int j=1; j<=w+1; j++){
                if (tree[i] == 1){
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1])+1;
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]);
                }else{
                    if (i==1&&j==1)continue;
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]) +1;
                }
            }
        }

        int ans = 0;
        for (int i=1; i<=w+1; i++){
            ans = Math.max(ans, Math.max(dp[t][i][0], dp[t][i][1]));
        }

        System.out.println(ans);
    }
}
