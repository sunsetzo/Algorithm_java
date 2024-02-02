package study.jan_5week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1149HJ {
    static int n;
    static int[][] arr;
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];
        cost = new int[n+1][3];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<n+1; i++){
            cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + arr[i-1][0];
            cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + arr[i-1][1];
            cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + arr[i-1][2];
        }

        System.out.println(Math.min(Math.min(cost[n][0], cost[n][1]), cost[n][2]));
    }
}
