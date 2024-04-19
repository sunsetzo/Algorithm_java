package study.apr_3week;

import java.io.*;
import java.util.*;

public class BJ18428HJ {
    static int n;
    static int obstacles = 3;
    static String ans = "YES";
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static String[][] arr;
    static class Node{
        int x; int y;
        Node(int x, int y){
            this.x = x; this.y = y;
        }
    }
    static ArrayList<Node> teachers;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        teachers = new ArrayList<>();
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                String input = st.nextToken();
                arr[i][j] = input;
                if (input.equals("T")){
                    teachers.add(new Node(i, j));
                }
            }
        }
        for (Node node : teachers){
            findObstacle(node.x, node.y);
        }
        System.out.println(ans);
    }
    static void findObstacle(int x, int y){
        for (int w=0; w<4; w++){
            int nx = x+dx[w]; int ny = y+dy[w];
            if (0<=nx && nx<n && 0<=ny && ny<n){
                if (arr[nx][ny].equals("S")){
                    obstacles = 0; ans = "NO";
                    return;
                } else if (arr[nx][ny].equals("O")) {
                    continue;
                } else if (arr[nx][ny].equals("T")) {
                    continue;
                }
                for (int k=1; k<n; k++){
                    int nnx = nx+dx[w]*k; int nny = ny+dy[w]*k;
                    if (0<=nnx && nnx<n && 0<=nny && nny<n){
                        if (arr[nnx][nny].equals("O") || arr[nnx][nny].equals("T")){
                            break;
                        } else if (arr[nnx][nny].equals("S")) {
                            if (obstacles == 0){
                                ans = "NO";
                                return;
                            }
                            arr[nx][ny] = "O";
                            obstacles -= 1;
                            break;
                        }
                    }
                }
            }
        }
    }
}