package study.mar_1week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Dot implements Comparable<Dot>{
    int x;
    int y;
    int cost;
    Dot(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Dot o) {
        return cost-o.cost;
    }
}
public class BJ14621HJ {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char [] school = new char[n+1];
        parent = new int[n+1];
        ArrayList<Dot> info = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<n+1; i++){
            school[i] = st.nextToken().charAt(0);
            parent[i] = i;
        }
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            info.add(new Dot(u, v, d));
        }

        Collections.sort(info);

        int ans = 0;
        int cnt = 0;
        for (int i=0; i<info.size(); i++){
            Dot dot = info.get(i);

            // 사이클이 발생하지 않는 간선 + 남초대학과 여초대학으로 연결되어있는가?
            if (find(dot.x) != find(dot.y) && school[dot.x]!=school[dot.y]){
                ans += dot.cost;
                cnt ++;
                union(dot.x, dot.y);
            }
        }
        System.out.println(cnt != n-1 ? -1 : ans);
    }
    public static int find(int x){
        if (parent[x] != x){
            return parent[x] = find(parent[x]);
        }
        return x;
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y){
            parent[y] = x;
        }
    }
}
