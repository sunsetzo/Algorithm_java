package study.mar_2week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21921HJ_SlidingWIndow {
    static int n, x, maxVisit, cnt;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 입력 배열
        visit = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i=0; i<x; i++){
            sum += visit[i];
        }
        maxVisit = sum;
        cnt = 1;
        for (int i=x; i<n; i++){
            sum += (visit[i]-visit[i-x]);
            if (maxVisit == sum){
                cnt ++;
            } else if (maxVisit<sum) {
                maxVisit = sum;
                cnt = 1;
            }
        }

        System.out.println(maxVisit!=0? maxVisit+"\n"+cnt : "SAD");
    }
}
