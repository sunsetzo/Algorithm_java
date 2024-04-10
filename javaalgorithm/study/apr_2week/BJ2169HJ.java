package study.apr_2week;

import java.io.*;
import java.util.*;

public class BJ2169HJ {
    static int n, m;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<m; i++){
            dp[0][i] += dp[0][i-1];
        }

        for (int i=1; i<n; i++){
            int[] right = Arrays.copyOf(dp[i], dp[i].length);
            int[] left = Arrays.copyOf(dp[i], dp[i].length);

            for (int j=0; j<m; j++){
                if (j==0){
                    right[j] += dp[i-1][j];
                }else{
                    right[j] += Math.max(dp[i-1][j], right[j-1]);
                }
            }

            for (int k=m-1; k>=0; k--){
                if (k==m-1){
                    left[k] += dp[i-1][k];
                }else{
                    left[k] += Math.max(dp[i-1][k], left[k+1]);
                }
            }
            for (int w=0; w<m; w++){
                dp[i][w] = Math.max(right[w], left[w]);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
