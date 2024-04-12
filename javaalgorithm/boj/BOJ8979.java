package boj;

import java.io.*;
import java.util.*;

public class BOJ8979 {
    static int n, k, ans;
    static class Node implements Comparable<Node>{
        int nation;
        int x; int y; int z;
        int rank;
        Node(int nation, int x, int y, int z, int rank){
            this.nation = nation;
            this.x = x;
            this.y = y;
            this.z = z;
            this.rank = rank;
        }
        @Override
        public int compareTo(Node node){
            if (node.x == this.x) {
                if (node.y == this.y) {
                    return node.z - this.z;
                } else {
                    return node.y - this.y;
                }
            }else{
                return node.x-this.x;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ArrayList<Node> info = new ArrayList<>();
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            info.add(new Node(a, b, c, d, 0));
        }
        Collections.sort(info);
        info.get(0).rank = 1;

        for (int i=1; i<info.size(); i++){
            Node now = info.get(i);

            int prevX = info.get(i-1).x;
            int prevY = info.get(i-1).y;
            int prevZ = info.get(i-1).z;

            if (info.get(i).nation == k){
                ans = i;
            }
            if (now.x == prevX && now.y == prevY && now.z==prevZ){
                info.get(i).rank = info.get(i-1).rank;
            }else{
                info.get(i).rank = i+1;
            }
        }

        System.out.println(info.get(ans).rank);
    }
}
