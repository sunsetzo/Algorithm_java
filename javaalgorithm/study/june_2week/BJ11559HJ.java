package study.june_2week;

import java.io.*;
import java.util.*;

public class BJ11559HJ {
    static int ans;
    static boolean flag;
    static boolean[][] visit;
    static String[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Node{
        int x; int y;
        String color;
        Node(int x, int y, String color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[12][6];
        for (int i=0; i<12; i++){
            arr[i] = br.readLine().split("");
        }

        while (true){
            flag = false;
            game();
            for (int j=0; j<6; j++){
                move(j);
            }

            if (!flag) break;

            ans++;
        }


        System.out.println(ans);
    }
    static void game(){
        Queue<Node> q = new LinkedList<>();
        visit = new boolean[12][6];
        for (int x=0; x<12; x++){
            for (int y=0; y<6; y++){
                List<Node> list = new ArrayList<>();    // 터질 수 있는 뿌요 좌표값 넣어줄 리스트
                String p = arr[x][y];
                if (!p.equals(".")){
                    q.add(new Node(x, y, p));
                    list.add(new Node(x, y, p));
                    visit[x][y] = true;
                    while (!q.isEmpty()){
                        Node node = q.poll();
                        for (int w=0; w<4; w++){
                            int nx = node.x+dx[w];
                            int ny = node.y+dy[w];
                            if (isPossible(nx, ny) && !visit[nx][ny] && arr[nx][ny].equals(node.color)){
                                visit[nx][ny] = true;
                                q.add(new Node(nx, ny, p));
                                list.add(new Node(nx, ny, p));
                            }
                        }
                    }
                    if (list.size()>=4){        // 리스트의 요소 갯수가 4이상이면 터질 수 O
                        flag = true;
                        for (Node node : list){
                            arr[node.x][node.y]=".";    // 중복안되게 빈칸으로 교체
                        }
                    }
                }
            }
        }

    }
    static boolean isPossible(int x, int y){
        if (0<=x && x<12 && 0<=y && y<6) return true;
        return false;
    }
    static void move(int j){    // 중력 작용
        Queue<Node> q = new LinkedList<>();
        int idx = 11;
        for (int i=11; i>=0; i--){
            if (!arr[i][j].equals(".")){
                q.add(new Node(i, j, arr[i][j]));
                arr[i][j]=".";
            }
        }

        while (!q.isEmpty()){
            Node node = q.poll();

            arr[idx][j] = node.color;
            idx--;
        }
    }
}