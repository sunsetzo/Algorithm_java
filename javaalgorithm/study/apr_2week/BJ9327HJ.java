package study.apr_2week;

import java.io.*;
import java.util.*;
public class BJ9327HJ {
    static long a, b;
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        // 2진수의 1개수 누적합 계산
        dp = new long[55];
        //DP[n] = DP[n-1] × 2 + 2ⁿ을 이용하여 누적합 저장하는 함수
        //DP[i-1] << 1 : DP[n-1] × 2
        //1L << i : 2ⁿ
        dp[0] = 1;
        for (int i=1; i<55; i++){
            dp[i] = (dp[i-1]<<1) + (1L<<i);
        }

        //A ≤ n ≤ B : B의 누적합 - (A-1)의 누적합 구하기
        long res = cal(b) - cal(a-1);
        System.out.println(res);
    }
    static long cal(long x){
        long cnt = x&1;
        //N보다 작은 2ⁿ의 n의 최대값
        int size = (int)(Math.log(x)/Math.log(2));
        //비트마스킹을 이용한 1의 개수 계산 진행
        //DP[i-1] : 000 ~ 111 개수
        //N - (1L << i) : 지정된 1이 반복 사용될 개수
        // + 1 : 1000...
        for (int i=size; i>0; i--){
            if ((x&(1L<<i)) != 0L){
                cnt += dp[i-1]+(x-(1L<<i)+1);
                x -= (1L<<i);   // 비트 이동
            }
        }
        return cnt;
    }
}
