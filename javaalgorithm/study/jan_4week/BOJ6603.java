package study.jan_4week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ6603 {
    static int n;
    static int[] arr;
    static int[] rotto;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if (n==0){
                break;
            }
            arr = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            rotto = new int[6];
            comb(n, 6, 0, 0);
            sb.append("\n");

        }
        System.out.println(sb);

    }
    static void comb(int n, int r, int k, int s){
        if (k==r){
            for (int num : rotto) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i=s; i<n-r+1+k; i++){
            rotto[k] = arr[i];
            comb(n, r, k+1, i+1);
        }
    }
}
