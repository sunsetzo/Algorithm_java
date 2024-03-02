package boj;

import java.util.*;
import java.io.*;

public class BOJ12581 {
    static int n, k, res;
    static int[] time;
    static int minTime = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        time = new int[100001];

        // n이 k보다 같거나 큰 경우는 -로밖에 갈 수 없기 때문에 한가지 경우만 존재한다.
        if (n>=k){
            System.out.println((n-k) + "\n1");
            return;
        }

        bfs();

        System.out.println(minTime + "\n" + res);
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        time[n] = 1;

        while (!q.isEmpty()){
            int now = q.poll();

            if (minTime < time[now]) return;

            for (int i=0; i<3; i++){
                int next;
                if (i==0) {next = now-1;}
                else if (i==1) {
                    next = now+1;
                }else next = now*2;

                if (next<0||next>=100001){
                    continue;
                }
                if (next == k){
                    minTime = time[now];
                    res ++;
                }
                if (time[next] == 0 || time[next] == time[now]+1){
                    q.add(next);
                    time[next] = time[now]+1;
                }
            }
        }
    }
}
