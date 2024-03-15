package boj;

import java.io.*;
import java.util.*;

public class BOJ22866 {
    static int n;
    static int[] buildings, cnt, dis;
    static class Info{
        int idx;
        int height;
        Info(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        buildings = new int[n+1];
        cnt = new int[n+1]; dis = new int[n+1];
        for (int i=1; i<n+1; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dis, -100001);
        }
        Stack<Info> left = new Stack<>();
        for (int i=1; i<n+1; i++){
            while (!left.isEmpty() && left.peek().height<=buildings[i]){
                left.pop();
            }
            cnt[i] = left.size();
            if (cnt[i] > 0) dis[i] = left.peek().idx;
            left.push(new Info(i, buildings[i]));
        }

        Stack<Info> right = new Stack<>();
        for (int i=n; i>0; i--){
            while (!right.isEmpty() && right.peek().height<=buildings[i]){
                right.pop();
            }
            int s = right.size();
            cnt[i] += s;
            if (s>0 && right.peek().idx-i < i-dis[i]) dis[i] = right.peek().idx;
            right.push(new Info(i, buildings[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<n+1; i++){
            sb.append(cnt[i]);
            if (cnt[i]>0){
                sb.append(" ").append(dis[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}