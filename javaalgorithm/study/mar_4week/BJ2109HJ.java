package study.mar_4week;

import java.io.*;
import java.util.*;

public class BJ2109HJ {
    static int n, max = -1, ans;
    static boolean[] lecture;
    static class Node implements Comparable<Node>{
        int price; int day;
        Node(int price, int day){
            this.price = price;
            this.day = day;
        }
        @Override
        public int compareTo(Node node){
            // 정렬 기준
            // 1) 날짜가 짧은 순
            // 2) 날짜가 같으면 비용이 큰 순서
            if (node.price != this.price) return node.price-this.price;
            else return this.day - node.day;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> info = new PriorityQueue<>();
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            max = Math.max(max, d); // 강연할 수 있는 최대 날짜
            info.add(new Node(p, d));
        }
        lecture = new boolean[max+1];
        while (!info.isEmpty()){
            Node node = info.poll();
            for (int i=node.day-1; i>=0; i--){
                // 해당 날짜에 강연을 하지 않았을 때
                if (!lecture[i]){
                    lecture[i] = true;
                    ans += node.price;  // 비용 더하기
                    break;
                }
            }
        }

        System.out.println(ans);

    }
}
