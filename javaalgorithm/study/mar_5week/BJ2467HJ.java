package study.mar_5week;

import java.io.*;
import java.util.*;

public class BJ2467HJ {
    static int n;
    static int[] info;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        info = new int[n];
        for (int i=0; i<n; i++){
            info[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0; int e = n-1;
        int start = 0; int end = 0;
        int mix = Integer.MAX_VALUE;

        while (s<e){
            int temp = info[s]+info[e];
            if (mix > Math.abs(temp)){
                mix = Math.abs(temp);
                start = info[s]; end = info[e];
            }
            if (temp<=0){
                s ++;
            }else{
                e --;
            }
        }
        System.out.println(start + " " + end);
    }
}
