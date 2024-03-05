package study.mar_2week;

import java.io.*;
import java.util.*;

public class BJ21921HJ {
    static int n, x, maxVisit, cnt;
    static int[] visit, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 입력 배열
        visit = new int[n];
        // 누적합 배열
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            visit[i] = Integer.parseInt(st.nextToken());
            if (i==0){
                dp[i] = visit[i];
            }else dp[i] = dp[i-1]+visit[i];
        }

        int start = 0;
        int end = start+x-1;
        while (start<=n-x){
            // 종료조건
            if (end>n) break;

            // x일 만큼의 방문자수 합
            int diff = dp[end]-dp[start]+visit[start];
            if (diff > maxVisit){
                maxVisit = diff;
                // 최댓값이 갱신되면 기간이 1로 갱신
                cnt = 1;
                start++;
                end++;
            } else if (diff == maxVisit) {
                cnt += 1; start++; end++;
            }else {
                start++;
                end++;
            }
        }
        System.out.println(maxVisit!=0? maxVisit+"\n"+cnt : "SAD");
    }
}
