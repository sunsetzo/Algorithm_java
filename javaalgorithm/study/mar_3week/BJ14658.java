package study.mar_3week;

import java.io.*;
import java.util.*;

public class BJ14658 {
    static int n, m , l, k, max;
    static class Node{
        int y; int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ArrayList<Node> star = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            star.add(new Node(y, x));
        }
        //두개의 지점에서 각각 x 좌표와 y 좌표를 추출
        //추출해낸 두 좌표에 대해, 리스트에 존재하는 지점을 모두 탐색
        //현재 지점이 두 좌표의 범위내에 있으면 cnt 값 증가
        for (Node n1 : star){
            for (Node n2 : star){
                int cnt = 0;
                for (Node node : star){
                    if (n1.x <= node.x && node.x <= n1.x+l && n2.y<=node.y&& node.y<=n2.y+l){
                        cnt ++;
                    }
                }
                max = Math.max(max, cnt);
            }
        }

        System.out.println(k-max);
    }
}
