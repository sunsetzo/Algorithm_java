package study.mar_3week;

import java.io.*;
import java.util.*;

public class BJ14658HJ {
    static int n, m , l, k, max;
    static int[][] sky;
    static class Node{
        int y; int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sky = new int[n+1][m+1];
        ArrayList<Node> star = new ArrayList<>();
        for (int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sky[y][x] = 1;
            star.add(new Node(y, x));
        }
        for (int i=0; i<star.size(); i++){
            Node node = star.get(i);
            twinkle(node.y, node.x);
        }
        System.out.println(max);
    }
    static void twinkle(int x, int y){
        for (int i=x-l; i<x+l; i++){
            for (int j=y-l; j<y+l; j++){
                if (1>i || n+1<=i || 1>j || m+1<=j) continue;
                int cnt = 0;
                for (int w=1; w<=l; w++){
                    for (int z=1; z<=l; z++){
                        int ni = i+w;
                        int nj = j+z;
                        if (1>ni || n+1<=ni || 1>nj || m+1<=nj) continue;
                        if (sky[ni][nj] == 1) {
                            cnt++;
                            max = Math.max(max, cnt);
                        }
                    }
                }
            }
        }
    }
}