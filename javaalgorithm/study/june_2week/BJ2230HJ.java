package study.june_2week;

import java.io.*;
import java.util.*;

public class BJ2230HJ {
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int s=0; int e=0;
        while (s<n){
            if (arr[s]-arr[e]<m){
                s++;
                continue;
            }
            if (arr[s]-arr[e]==m){
                ans=m;
                break;
            }

            ans = Math.min(ans, arr[s]-arr[e]);
            e++;
        }
        System.out.println(ans);
    }
}
