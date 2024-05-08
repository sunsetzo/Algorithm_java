package study.apr_1week;

import java.io.*;
import java.util.*;
public class BJ2512HJ {
    static int n, m;
    static long ans;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        m = Integer.parseInt(br.readLine());
        long start = 1; long end = arr[arr.length-1];

        while (start <= end){
            long mid = (start+end)/2;
            long sum = 0;
            for (int i=0; i<n; i++){
                if (arr[i] >= mid){
                    sum += mid;
                }else{
                    sum += arr[i];
                }
            }
            if (sum > m){
                end = mid-1;
            }else{
                ans = Math.max(ans, mid);
                start = mid+1;
            }
        }
    }
}