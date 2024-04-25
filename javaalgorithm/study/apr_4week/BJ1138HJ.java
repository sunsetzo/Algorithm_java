package study.apr_4week;

import java.io.*;
import java.util.*;

public class BJ1138HJ {
    static int n;
    static int[] arr, memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[n];
        memo = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<n; i++){
            int cnt = 0;
            for (int j=0; j<n; j++){
                if (cnt == arr[i] && memo[j] == 0){
                    memo[j] = i+1;
                    break;
                } else if (memo[j] == 0) {
                    cnt += 1;
                }
            }
        }
        for (int i=0; i<n; i++){
            sb.append(memo[i]).append(" ");
        }
        System.out.println(sb);
    }
}
