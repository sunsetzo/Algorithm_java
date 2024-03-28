package study.mar_5week;

import java.io.*;
import java.util.*;

public class BJ16234HJ {
    static int n, l, r;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Node{
        int x; int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(move());
    }
    static int move(){
        int res = 0;
        while (true){
            boolean isMove = false;
            visit = new boolean[n][n];
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    if (!visit[i][j]){
                        int sum = bfs(i, j);
                        if (list.size()>1){
                            int avg = sum/list.size();
                            for (Node node : list){
                                arr[node.x][node.y] = avg;
                            }
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) return res;
            res ++;
        }
    }
    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();

        q.add(new Node(x, y));
        list.add(new Node(x, y));
        visit[x][y] = true;
        int sum = arr[x][y];

        while (!q.isEmpty()){
            Node node = q.poll();
            for (int w=0; w<4; w++){
                int nx = node.x+dx[w]; int ny = node.y+dy[w];
                if (0<=nx && nx<n && 0<=ny && ny<n && !visit[nx][ny]){
                    int diff = Math.abs(arr[nx][ny]-arr[node.x][node.y]);
                    if (l<=diff && diff<=r){
                        visit[nx][ny] = true;
                        q.add(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        sum += arr[nx][ny];
                    }
                }
            }
        }
        return sum;
    }
}