package study.june_1week;

import java.io.*;
import java.util.*;

public class BJ17471HJ {
    static int ans = Integer.MAX_VALUE;
    static int n;
    static int[] people, area;
    static boolean[] visit;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new int[n+1];
        area = new int[n+1];
        list = new ArrayList[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<n+1; i++){
            list[i] = new ArrayList<>();
            people[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j=0; j<m; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        comb(1);
        System.out.println(ans!=Integer.MAX_VALUE? ans : -1);
    }
    static void comb(int k){
        if (k == n+1){
            int a1 = 0; int a2= 0;
            for (int i=1; i<n+1; i++){
                if (area[i] == 1) a1 += people[i];
                else a2 += people[i];
            }

            visit = new boolean[n+1];
            int link = 0;
            for (int i=1; i<n+1; i++){
                if (!visit[i]){
                    bfs(i, area[i]);
                    link++;
                }
            }
            if (link == 2) ans = Math.min(ans, Math.abs(a1-a2));

            return;
        }
        area[k]=1;
        comb(k+1);
        area[k]=2;
        comb(k+1);
    }
    static void bfs(int idx, int areaNum){
        Queue<Integer> q = new LinkedList<>();
        visit[idx] = true;
        q.offer(idx);

        while (!q.isEmpty()){
            int cur = q.poll();

            for (int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                if (area[next] == areaNum && !visit[next]){
                    q.offer(next);
                    visit[next]=true;
                }
            }
        }
    }
}