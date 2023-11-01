package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] ans = new int[n][m];

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                ans[i][j] = 0;
            }
        }

        int x = -1; int y = -1;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (arr[i][j] == 2){
                    x=i; y=j;
                    bfs(x, y, di, dj, ans, arr);
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (arr[i][j]==1 && ans[i][j]==0){
                    ans[i][j] = -1;
                }
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void bfs(int x, int y, int[] di, int[] dj, int[][] ans, int[][] arr){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int i = current[0]; int j = current[1];

            for (int w = 0; w<4; w++){
                int ni = i+di[w];
                int nj = j+dj[w];

                if (0<=ni && ni< ans.length && 0<=nj && nj<ans[0].length){
                    if (ans[ni][nj] == 0 && arr[ni][nj] == 1){
                        ans[ni][nj] = ans[i][j] + 1;
                        q.add(new int[]{ni, nj});
                    }
                }
            }
        }
    }
}
