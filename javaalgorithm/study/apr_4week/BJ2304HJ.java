package study.apr_4week;

import java.io.*;
import java.util.*;

public class BJ2304HJ {
    static int n, ans;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[1001];
        int maxH = 0; int maxL = 0;
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
            // 최대 높이인 지점 찾기
            if (maxH<h){
                maxL = l;
                maxH = h;
            }
        }
        // 양쪽에서 탐색
        int temp = 0;
        for (int i=0; i<maxL; i++){
            if (arr[i] > temp){
                temp = arr[i];
            }
            ans += temp;
        }
        int tmp = 0;
        for (int i=1000; i>=maxL; i--){
            if (arr[i] > tmp){
                tmp = arr[i];
            }
            ans += tmp;
        }
        System.out.println(ans);
    }
}