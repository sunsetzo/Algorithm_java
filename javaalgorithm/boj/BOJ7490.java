package boj;

import java.io.*;
import java.util.*;

public class BOJ7490 {
    static int T, n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(1, 1, 0, 1, "1");

            System.out.println(sb);

        }
    }
    // idx = 1~n; num = 만든 숫자, sum = 총합, op = 더하기면 1, 빼기면 -1, express = 만든 식
    static void dfs(int idx, int num, int sum, int op, String express){
        if (idx == n){
            // 최종 연산 (마지막 연산)
            sum += (num*op);
            // 결과값이 0이면 sb에 append
            if (sum == 0) sb.append(express+"\n");
            return;
        }
        dfs(idx+1, num*10+(idx+1), sum, op, express+" "+Integer.toString(idx+1));
        dfs(idx+1, idx+1, sum+(num*op), 1, express+"+"+Integer.toString(idx+1));
        dfs(idx+1, idx+1, sum+(num*op), -1, express+"-"+Integer.toString(idx+1));
    }
}
