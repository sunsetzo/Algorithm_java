package study.may_5week;

import java.io.*;
import java.util.*;

public class BJ2644HJ {
    static int n, m, s, e;
    static int[] visit;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        visit = new int[n+1];
        tree = new ArrayList[n+1];
        for (int i=0; i<n+1; i++){
            tree[i] = new ArrayList<>();
        }
        m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }
        bfs(s);

        System.out.println(visit[e]==0? -1: visit[e]-1);
    }
    static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visit[s] = 1;
        while (!q.isEmpty()){
            int t = q.poll();
            for (int w: tree[t]){
                if (visit[w]==0){
                    q.offer(w);
                    visit[w] = visit[t]+1;
                }
            }
        }
    }
}