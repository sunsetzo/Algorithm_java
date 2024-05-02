package study.may_1week;

import java.io.*;
import java.util.*;

public class BJ1520HJ {
    static int n, m, cnt;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr, dp;
    static class Node{
        int x; int y;
        Node(int x, int y){
            this.x = x; this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }
    static int dfs(int x, int y) {
        // 목적지에 도달했을 때, 경로가 있음을 반환
        if (x == n - 1 && y == m - 1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int temp = 0;
        for (int w = 0; w < 4; w++) {
            int nx = x + dx[w];
            int ny = y + dy[w];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (arr[nx][ny] < arr[x][y]) {
                    temp += dfs(nx, ny);
                }
            }
        }
        dp[x][y] = temp;    // 현재 위치에서 목적지까지 갈 수 있는 모든 경로의 수를 dp에 저장하여 반환
        return dp[x][y];
    }
}