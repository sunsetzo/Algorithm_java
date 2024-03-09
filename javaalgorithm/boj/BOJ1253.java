package boj;

import java.io.*;
import java.util.*;

public class BOJ1253 {
    static int n, cnt;
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

        for (int i=0; i<n; i++){
            binarySearch(arr[i], i);
        }
        System.out.println(cnt);
    }
    static void binarySearch(int x, int idx){
        int start = 0;
        int end = n-1;
        while (start<end){
            if (start == idx){
                start++;
                continue;
            } else if (end == idx) {
                end--;
                continue;
            }
            int sum = arr[start]+arr[end];
            if (x == sum){
                cnt ++;
                return;
            } else if (x > sum) {
                start++;
            } else {
                end--;
            }
        }
    }
}
