package study.may_5week;

import java.io.*;
import java.util.*;

public class BJ4485HJ {
    static int n, tc;
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if (n == 0) System.exit(0);
            else {
                tc++;
                System.out.println("Problem " + tc + ": " + dijkstra());
            }
        }
    }
    static int dijkstra(){
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        int[][] D = new int[n][n];
        boolean[][] visit = new boolean[n][n];
        for (int i=0; i<n; i++){
            Arrays.fill(D[i], INF);
        }

        D[0][0] = arr[0][0];
        heap.offer(new int[]{D[0][0], 0, 0});

        while (!heap.isEmpty()){
            int[] curr = heap.poll();
            int d = curr[0]; int x = curr[1]; int y = curr[2];

            if (visit[x][y])continue;
            visit[x][y] = true;

            if (x==n-1 && y==n-1) return D[n-1][n-1];

            for (int w=0; w<4; w++){
                int nx = x+dx[w]; int ny = y+dy[w];
                if (0<=nx && nx<n && 0<=ny && ny<n && !visit[nx][ny]){
                    if (D[nx][ny] >= D[x][y]+arr[nx][ny]){
                        D[nx][ny] = D[x][y]+arr[nx][ny];
                        heap.offer(new int[]{D[nx][ny], nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
