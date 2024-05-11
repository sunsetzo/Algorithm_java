package study.may_2week;

import java.io.*;
import java.util.*;

// 위상정렬
public class BJ2623HJ {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        int[] degree = new int[n+1];

        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        // 순서 정보 저장
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int singer = 0;
            for (int j=0; j<cnt; j++){
                int nextSinger = Integer.parseInt(st.nextToken());

                if (singer!=0){
                    graph.get(singer).add(nextSinger);
                    degree[nextSinger]++;
                }
                singer = nextSinger;
            }
        }
        System.out.println(solution(graph, degree, n));
    }
    static String solution(ArrayList<ArrayList<Integer>> info, int[] degree, int n){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        // 아무것도 연결되어 있지 않은 최초 노드 찾기
        for (int i=1; i<=n; i++){
            if (degree[i] == 0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int now = q.poll();
            result.add(now);

            // 연결 노드 찾기
            for (int next : info.get(now)){
                degree[next]--;

                if (degree[next] == 0){
                    q.offer(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (result.size() != n){
            sb.append("0");
        }else {
            for (int i=0; i<result.size(); i++){
                sb.append(result.get(i)).append("\n");
            }
        }
        return sb.toString();
    }
}
