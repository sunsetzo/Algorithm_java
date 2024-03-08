package boj;

import java.io.*;
import java.util.*;

public class BOJ2234 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    // 북, 동, 남, 서
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int room = 0;
        int max = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (!visit[i][j]){
                    max = Math.max(max, bfs(i, j));
                    room++;
                }
            }
        }
        System.out.println(room);
        System.out.println(max);
        // 각 벽을 하나씩 제거해보며 최대 방의 크기를 구함
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                for (int bit=1; bit<=8; bit<<=1){
                    if ((arr[i][j] & bit)!=0){ // 벽이 있는 경우
                        visit = new boolean[n][m]; // 방문 여부 배열 초기화
                        arr[i][j] -= bit; // 벽 제거
                        max = Math.max(max, bfs(i, j)); // 최대 방의 크기 갱신
                        arr[i][j] += bit; // 벽 복구
                    }
                }
            }
        }
        System.out.println(max);
    }
    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        int cnt = 1;
        visit[x][y] = true;
        while (!q.isEmpty()){
            Node node = q.poll();
            int bit = 1;
            for (int w=0; w<4; w++){
                // 벽이 없으면 이동이 가능
                if ((arr[node.x][node.y]&bit)==0){
                    int nx = node.x+dx[w];
                    int ny = node.y+dy[w];
                    if (0<=nx && nx<n && 0<=ny && ny<m){
                        if (!visit[nx][ny]){
                            cnt ++;
                            visit[nx][ny] = true;
                            q.add(new Node(nx, ny));
                        }
                    }
                }
                bit <<= 1;
            }
        }
        return cnt;
    }
}
