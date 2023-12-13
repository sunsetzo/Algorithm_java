package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n==0){
            if (p>0){
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        } else {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int rank = 1;
            int equalScore = 0;

            for (int i:arr){
                if (i>score){
                    rank ++;
                }if (i==score){
                    equalScore++;
                }
            }

            if (rank > p) {
                System.out.println(-1);
            } else {
                System.out.println((rank <= p - equalScore) ? rank : -1);
            }
        }
    }
}
