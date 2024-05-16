package study.may_3week;

import java.io.*;
import java.util.*;

// 25칸 중 7칸을 골라서
// 7칸이 다 이어져 있는지 없는지 + '이다솜파'가 적어도 4명이상 포함되어있는지 확인
public class BJ1941HJ {
    static char[][] arr;
    static int ans;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] select = new int[7];
    static boolean[] visit;
    static class Node{
        int x; int y;
        Node(int x, int y){
            this.x = x; this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][5];
        for (int i=0; i<5; i++){
            arr[i] = br.readLine().toCharArray();
        }

        comb(0, 0, 0);
        System.out.println(ans);
    }
    static void comb(int d, int cnt, int start){
        if (cnt>=4) return;

        if (d==7){
            visit = new boolean[7];
            bfs();
            return;
        }

        //5로 나눈 몫을 행으로, 나머지를 열로 설정해주면 5*5 행렬을 표현 가능
        for (int i=start; i<25; i++){
            select[d] = i;
            if (arr[i/5][i%5]=='Y'){
                comb(d+1, cnt+1, i+1);
            }else{
                comb(d+1, cnt, i+1);
            }
        }
    }
    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(select[0]/5, select[0]%5));
        visit[0] = true;
        int conn = 1;   // 연결된 갯수

        while (!q.isEmpty()){
            Node node = q.poll();
            for (int w=0; w<4; w++){
                int nx = node.x+dx[w]; int ny = node.y+dy[w];
                int ni = nx*5 + ny; //(0~24) 사이의 숫자로 만들기
                if (!isValid(nx, ny)) continue;

                for (int i=0; i<7; i++){
                    if (!visit[i] && select[i] == ni){
                        q.add(new Node(nx, ny));
                        visit[i] = true;
                        conn++;
                    }
                }
            }
        }
        if (conn==7) ans++;
    }
    static boolean isValid(int x, int y){
        if (x<0 || x>=5|| y<0 || y>=5) return false;
        return true;
    }
}
