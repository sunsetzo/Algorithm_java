package boj;

import java.io.*;
import java.util.*;

public class BOJ1940 {
    static int n, m, res;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        while (start<end){
            int temp = arr[start]+arr[end];
            if (temp == m){
                res ++;
                start ++;
                end --;
            }else if (temp < m){
                start ++ ;
            }else{
                end --;
            }
        }
        System.out.println(res);
    }
}
