package study.mar_4week;

import java.io.*;
import java.util.*;

public class BJ1743HJ {
    static int n, m, k, ans;
    static boolean[][] arr, visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Node{
        int x; int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];
        visit = new boolean[n][m];
        for (int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            arr[r][c] = true;
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (arr[i][j] && !visit[i][j]){
                    ans = Math.max(bfs(i, j), ans);
                }
            }
        }
        System.out.println(ans);
    }
    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;
        int cnt = 1;
        while (!q.isEmpty()){
            Node node = q.poll();
            for (int w=0; w<4; w++){
                int nx = node.x+dx[w];
                int ny = node.y+dy[w];
                if (0<=nx && nx<n && 0<=ny && ny<m){
                    if (arr[nx][ny] && !visit[nx][ny]){
                        visit[nx][ny] = true;
                        q.add(new Node(nx, ny));
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }
}
