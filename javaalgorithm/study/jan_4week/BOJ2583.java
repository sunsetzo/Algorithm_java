package study.jan_4week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2583 {
    static int m, n, k = 0;
    static int count = 0;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];

        for (int a=0; a<k; a++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int y=y1; y<y2; y++){
                for (int x=x1; x<x2; x++){
                    arr[y][x] = 1;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (arr[i][j] ==0){
                    count = 0;
                    dfs(i, j);
                    res.add(count);
                }
            }
        }

        Collections.sort(res);

        sb.append(res.size()).append('\n');
        for (int i: res){
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
    static void dfs(int x, int y){
        arr[x][y] = 1;
        count ++;
        for (int k=0; k<4; k++){
            int nx = x+dx[k];
            int ny = y+dy[k];

            if (0<=nx && nx<m && 0<=ny && ny<n){
                if (arr[nx][ny]==0){
                    dfs(nx, ny);
                }
            }
        }
    }
}
