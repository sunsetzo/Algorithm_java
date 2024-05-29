package study.may_5week;

import java.io.*;
import java.util.*;

// bfs로 연결 다리 확인 후, 이분탐색으로 중량의 최댓값 구함
public class BJ1939HJ {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, s, e, ans;
    static boolean[] visit;
    static List<Node>[] arr;
    static class Node{
        int n; int cost;
        Node(int n, int cost){
            this.n = n; this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for (int i=0; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, c));
            arr[b].add(new Node(a, c));
            max = Math.max(max, c);
            min = Math.min(min, c);
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        while (min <= max){
            int mid = (min+max)/2;
            visit = new boolean[n+1];

            if (bfs(mid)){
                min = mid+1;
                ans = mid;
            }else{
                max = mid-1;
            }
        }

        System.out.println(ans);
    }
    static boolean bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visit[s] = true;
        while (!q.isEmpty()){
            int t = q.poll();
            if (t == e) return true;

            for (int i=0; i<arr[t].size(); i++){
                Node node = arr[t].get(i);
                if (node.cost >= x && !visit[node.n]){
                    visit[node.n]=true;
                    q.offer(node.n);
                }
            }
        }
        return false;
    }
}