package boj;

import java.io.*;
import java.util.*;

public class BOJ17182 {
    static int n, k, ans;
    static int[][] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // i -> j로 갈 때, 바로가는 것과 어떤 곳을 들러서 가는 경로 중 최단 거리로 갱신
        // 플로이드워셜 알고리즘의 핵심. (중복 방문이 가능할 때 사용)
        for (int k=0; k<n; k++){
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    if (arr[i][k] + arr[k][j] < arr[i][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        ans = Integer.MAX_VALUE;
        visit = new boolean[n];
        visit[k] = true;
        perm(1, k, 0);
        System.out.println(ans);
    }
    static void perm(int cnt, int prev, int d){
        if (cnt == n){
            ans = Math.min(ans, d);
        }
        for (int i=0; i<n; i++){
            if (visit[i]) continue;;
            visit[i] = true;
            perm(cnt+1, i, d+arr[prev][i]);
            visit[i] = false;
        }
    }
}
