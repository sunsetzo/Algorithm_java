package study.jan_4week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963 {
    static String[] strs;
    static int w, h = 0;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] arr;
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        strs = br.readLine().split(" ");
        w = Integer.parseInt(strs[0]);
        h = Integer.parseInt(strs[1]);

        while (w!=0 && h!=0) {
            arr = new int[h][w];
            int cnt = 0;

            for (int i = 0; i < h; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] != 0) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(cnt + "\n");

            strs = br.readLine().split(" ");
            w = Integer.parseInt(strs[0]);
            h = Integer.parseInt(strs[1]);
        }
        System.out.println(sb.toString());
    }
    static void bfs(int s, int e){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, e));
        arr[s][e] = 0;
        while (!q.isEmpty()){
            Node node = q.poll();
            for (int i=0; i<dx.length; i++){
                int nextX = dx[i] + node.x;
                int nextY = dy[i] + node.y;
                if (nextX<0 || nextX>=h || nextY<0 || nextY>=w){
                    continue;
                }
                if (arr[nextX][nextY] == 1){
                    arr[nextX][nextY] = 0;
                    q.offer(new Node(nextX, nextY));
                }
            }
        }
    }
}