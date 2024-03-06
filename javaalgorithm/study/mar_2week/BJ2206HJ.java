package study.mar_2week;

import java.io.*;
import java.util.*;

public class BJ2206HJ {
    static int n, m;
    static int[][] arr;
    static int[][][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Node{
        int x;
        int y;
        int z;

        public Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i=0; i<n; i++){
            String input = br.readLine();
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        visit = new int[n][m][2];
        visit[0][0][0] = 1;

        System.out.println(bfs(0, 0, 0));
    }
    // 3차원 배열로 벽을 부술때랑 아닐때를 저장
    // visited[n][m][0]은 벽을 한번도 안부수고 탐색한 경우
    // visited[n][m][1]은 벽을 한번 부수고 탐색한 경우
    static int bfs(int x, int y, int z){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, z));

        while (!q.isEmpty()){
            Node node = q.poll();
            int a = node.x;
            int b = node.y;
            int c = node.z;

            if (a == n-1 && b == m-1){
                return visit[a][b][c];
            }
            for (int w=0; w<4; w++){
                int nx = a+dx[w];
                int ny = b+dy[w];
                if (nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if (arr[nx][ny] == 1 && c == 0){
                    visit[nx][ny][1] = visit[a][b][c]+1;
                    q.add(new Node(nx, ny, 1));
                } else if (arr[nx][ny]==0 && visit[nx][ny][c] == 0){
                    visit[nx][ny][c] = visit[a][b][c]+1;
                    q.add(new Node(nx, ny, c));
                }
            }
        }
        return -1;
    }
}
