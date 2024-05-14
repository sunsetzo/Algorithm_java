package study.may_3week;

import java.io.*;
import java.util.*;
public class BJ2146HJ {
    static int n;
    static int ans = Integer.MAX_VALUE;
    static int num = 2;
    static int[][] arr, visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Node{
        int x; int y; int bridge;
        Node(int x, int y, int bridge){
            this.x = x;
            this.y = y;
            this.bridge = bridge;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new int[n][n];
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (arr[i][j] == 1) {
                    island(i, j);
                }
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                visit = new int[n][n];
                if (arr[i][j] >= 2) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }
    static void island(int x, int y){
        Queue<Node> land = new LinkedList<>();
        land.add(new Node(x, y, 0));
        arr[x][y] = num;
        visit[x][y] = 1;
        while (!land.isEmpty()){
            Node node = land.poll();
            for (int w = 0; w<4; w++){
                int nx = node.x+dx[w]; int ny = node.y+dy[w];
                if (0<=nx && nx<n && 0<=ny && ny<n && visit[nx][ny] == 0 && arr[nx][ny] == 1){
                    visit[nx][ny] = 1;
                    arr[nx][ny] = num;
                    land.add(new Node(nx, ny, 0));
                }
            }
        }
        num ++;
    }
    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        int currentNum = arr[x][y];
        visit[x][y] = 1;
        q.add(new Node(x, y, 0));

        while (!q.isEmpty()){
            Node node = q.poll();
            for (int w=0; w<4; w++){
                int nx = node.x+dx[w]; int ny = node.y+dy[w];
                if (0<=nx && nx<n && 0<=ny && ny<n && arr[nx][ny] != currentNum && visit[nx][ny] == 0){
                    visit[nx][ny] = 1;
                    if (arr[nx][ny] == 0){
                        q.add(new Node(nx, ny, node.bridge+1));
                    }else{
                        ans = Math.min(ans, node.bridge);
                    }
                }
            }
        }
    }
}