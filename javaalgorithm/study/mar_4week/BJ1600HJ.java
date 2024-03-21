package study.mar_4week;

import java.io.*;
import java.util.*;

public class BJ1600HJ {
    static int k, w, h;
    static int ans = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[][][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};

    static class Node {
        int x;
        int y;
        int count;
        int limit;

        Node(int x, int y, int count, int limit) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.limit = limit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[h][w][k + 1];
        ans = bfs(0, 0);
        System.out.println(ans == Integer.MAX_VALUE? -1 : ans);
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0, k));
        visit[x][y][k] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == h - 1 && node.y == w - 1) return node.count;
            for (int z = 0; z < 4; z++) {

                int nx = node.x + dx[z];
                int ny = node.y + dy[z];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visit[nx][ny][node.limit] && arr[nx][ny] == 0) {
                    visit[nx][ny][node.limit] = true;
                    q.add(new Node(nx, ny, node.count + 1, node.limit));
                }

            }
            if (node.limit > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = node.x + hx[i];
                    int ny = node.y + hy[i];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visit[nx][ny][node.limit - 1] && arr[nx][ny] == 0) {
                        visit[nx][ny][node.limit - 1] = true;
                        q.add(new Node(nx, ny, node.count + 1, node.limit - 1));
                    }
                }
            }
        }
        return ans;
    }
}
