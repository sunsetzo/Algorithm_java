package study.mar_3week;

import java.util.*;
import java.io.*;

public class BJ1027HJ {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int idx=0; idx<n; idx++){
            int view_max = 0;
            double left_max = Double.POSITIVE_INFINITY;
            double right_max = Double.NEGATIVE_INFINITY;

            for (int i=idx-1; i>=0; i--){
                double slope = calc(idx+1, arr[idx], i+1, arr[i]);
                if(slope<left_max){
                    left_max=slope;
                    view_max++;
                }
            }

            for (int i=idx+1; i<n; i++){
                double slope = calc(idx+1, arr[idx], i+1, arr[i]);
                if (slope>right_max){
                    right_max=slope;
                    view_max++;
                }
            }

            ans = Math.max(ans, view_max);
        }

        System.out.println(ans);
    }

    public static double calc(int x1, int y1, int x2, int y2){
        return (double) (y2-y1)/(x2-x1);
    }
}