package study.mar_1week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// (0, 0) -> (n-1, m-1)
public class BOJ1261 {
    static class Node{
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static int n, m;
    static int[][] maze, dis;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        dis = new int[n][m];
        visit = new boolean[n][m];

        for (int i=0; i<n; i++){
            String[] input = br.readLine().split("");
            for (int j=0; j<m; j++){
                maze[i][j] = Integer.parseInt(input[j]);
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(dijkstra(0, 0));

    }
    static int dijkstra(int x, int y){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.offer(new Node(x, y, 0));
        dis[0][0] = 0;
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int cx = temp.x;
            int cy = temp.y;

            for (int w=0; w<4; w++){
                int nx = cx+dx[w];
                int ny = cy+dy[w];
                if (nx>=0 && ny>=0 && nx<n && ny<m){
                    if (!visit[nx][ny] && dis[nx][ny] >= dis[cx][cy]+maze[nx][ny]){
                        dis[nx][ny] = dis[cx][cy]+maze[nx][ny];
                        visit[nx][ny] = true;
                        q.offer(new Node(nx, ny, dis[nx][ny]));
                    }
                }
            }
        }
        return dis[n-1][m-1];
    }
}