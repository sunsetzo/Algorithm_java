package study.jan_4week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17266 {
    static int n,m;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            int point = Integer.parseInt(st.nextToken());
            arr[i] = point;
        }

        int res = 0;
        int left = 0;
        int right = n;

        while (left<=right){
            int mid = (left+right)/2;

            if (check(mid)){
                right = mid-1;
                res = mid;
            }else{
                left = mid+1;
            }
        }
        System.out.println(res);
    }
    // 굴다리를 모두 비추는지 확인
    static boolean check(int h){
        int prev = 0; // 이전 가로등이 비춘 위치

        for (int i=0; i<arr.length; i++){
            if (arr[i] -h <= prev){
                prev = arr[i]+h;
            }else{
                return false;
            }
        }
        // 마지막 가로등이 비추는 곳이 굴다리 길이보다 같거나 커야함
        return n-prev<=0;
    }
}
