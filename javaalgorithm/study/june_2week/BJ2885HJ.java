package study.june_2week;

import java.io.*;

public class BJ2885HJ {
    static int k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        int n = 1;
        int cnt = 0;
        while (n<k) n = n*2;    // 크기가 K인 초콜릿 -> k와 같거나 큰 2의 제곱 크기의 초콜릿이 필요

        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ");

        // 1. 초콜릿의 크기가 K보다 클 경우 반으로 쪼개고 cnt++
        // 2. k가 0보다 작아지면 반복문 중단
        while (k>0){
            if (k>=n){
                k-=n;
            }else{
                n/=2;
                cnt++;
            }
        }
        sb.append(cnt);

        System.out.println(sb);

    }
}
