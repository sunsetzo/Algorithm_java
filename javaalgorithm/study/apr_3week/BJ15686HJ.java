package study.apr_3week;

import java.io.*;
import java.util.*;
public class BJ15686HJ {
    static int n,m;
    static int min = Integer.MAX_VALUE;
    static int[][] board;
    static class Node{
        int x; int y;
        Node(int x, int y){
            this.x = x; this.y = y;
        }
    }
    static ArrayList<Node> home;
    static ArrayList<Node> chicken;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                int info = Integer.parseInt(st.nextToken());
                board[i][j] = info;
                if (info == 1){
                    home.add(new Node(i, j));
                } else if (info == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        delivery(0, 0);
        System.out.println(min);

    }
    static void delivery(int num, int cnt){
        if (num > chicken.size()) {
            return;
        }
        if (cnt == m){
            int res = 0;    // 치킨 거리
            for (Node node : home) {
                int temp = Integer.MAX_VALUE;       // 해당 턴의 최소 치킨거리
                for (int idx : arr){
                    Node c = chicken.get(idx);
                    temp = Math.min(temp, Math.abs(node.x-c.x)+Math.abs(node.y-c.y));
                }
                res += temp;
            }
            min = Math.min(min, res);
            return;
        }
        arr.add(num);
        delivery(num+1, cnt+1);
        arr.remove(arr.size()-1);
        delivery(num+1, cnt);
    }
}