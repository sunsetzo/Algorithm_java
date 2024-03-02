package boj;

import java.io.*;
import java.util.*;

public class BOJ1244 {
    static int n, m, left, right, number;
    static int[] switches;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        switches = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (student == 1){
                for (int s=0; s<n; s++){
                    if ((s+1)%k ==0){
                        switches[s] = switches[s]==0? 1:0;
                    }
                }
            } else {
                switches[k-1] = switches[k-1]==0? 1:0;
                for (int s=1; s<n/2; s++){
                    if (k-1+s >= n || k-1-s<0){
                        break;
                    }
                    if (switches[k-1-s] == switches[k-1+s]){
                        switches[k-1-s] = switches[k-1-s]==0? 1:0;
                        switches[k-1+s] = switches[k-1+s]==0? 1:0;
                    }else{
                        break;
                    }
                }
            }
        }
        for (int i=0; i<n; i++){
            System.out.print(switches[i]+" ");
            if ((i+1)%20 == 0){
                System.out.println();
            }
        }
    }
}