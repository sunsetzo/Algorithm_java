package study.mar_1week;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int x;
    int y;
    int cost;
    Edge(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return cost - o.cost;
    }
}
public class BJ1647HJ {
    static int n, m;
    static int[] parents;
    static ArrayList<Edge> info;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 크루스칼 알고리즘 사용
        parents = new int[n+1];
        info = new ArrayList<>();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            info.add(new Edge(a, b, c));
        }

        for (int i=0; i<n+1; i++){
            parents[i] = i;
        }

        // 가중치를 기준으로 오름차순 정렬
        Collections.sort(info);

        // 모든 집이 N-1개의 길로 연결되도록 만듦
        int ans = 0;
        int max = 0;
        for (int i=0; i<info.size(); i++){
            Edge edge = info.get(i);

            // 사이클이 발생하는 간선은 제외
            if (find(edge.x) != find(edge.y)){
                ans += edge.cost;
                // 사이클의 확인은 유니온파인드를 사용
                union(edge.x, edge.y);

                // cost가 가장 큰 경우 저장
                max = edge.cost;
            }
        }
        // 마을을 두 개로 나눠야 하기 때문에 가장 큰 cost를 빼는 것
        bw.write((ans-max) + "\n");
        bw.flush();;
        bw.close();;
    }
    public static int find(int x){
        if (x == parents[x]){
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x!=y){
            parents[y] = x;
        }
    }
}