package study.may_1week;

import java.io.*;
import java.util.*;

public class BJ1931HJ {
    static int n, cnt;
    static class Node implements Comparable<Node>{
        int start; int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        // 정렬 : 회의가 빨리 끝나는 순 > 빨리 시작하는 순
        public int compareTo(Node o){
            if (o.end == this.end) {
                return this.start-o.start;
            }
            return this.end-o.end;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<Node> info = new ArrayList<>();
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            info.add(new Node(s, e));
        }
        Collections.sort(info);

        int time = 0;
        for (Node node:info){
            if (time <= node.start){
                cnt ++;
                time = node.end;
            }
        }
        System.out.println(cnt);
    }
}
