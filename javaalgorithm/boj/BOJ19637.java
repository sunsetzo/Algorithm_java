package boj;

import java.io.*;
import java.util.*;

public class BOJ19637 {
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String[] title = new String[n];
        int[] power = new int[n];
        for (int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            title[i] = input[0];
            power[i] = Integer.parseInt(input[1]);
        }

        for (int i=0; i<m; i++){
            int num = Integer.parseInt(br.readLine());

            int start = 0;
            int end = n-1;

            while (start<=end){
                int mid = (start+end)/2;

                if (power[mid] < num){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            sb.append(title[start]).append("\n");
        }
        System.out.println(sb.toString());
    }
}