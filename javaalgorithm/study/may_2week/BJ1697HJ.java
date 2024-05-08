package study.may_2week;

import java.io.*;
import java.util.*;

public class BJ1697HJ {
    static int n, k;
    static int[] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new int[10000001];
        bfs(n, k);
        System.out.println(visit[k]);
    }
    static void bfs(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        while (!q.isEmpty()){
            int t = q.poll();
            if (t ==k) return;
            int[] cal = {t-1, t+1, 2*t};
            for (int nt :cal){
                if (0<=nt && nt<=1000001 && visit[nt] == 0){
                    visit[nt] = visit[t] +1;
                    q.offer(nt);
                }
            }
        }
    }
}
