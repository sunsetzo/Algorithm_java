package study.apr_1week;

import java.io.*;
import java.util.*;

public class BJ9017HJ {
    static int t, n;
    static int[] info;
    static int[][] team;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc<t; tc++){
            n = Integer.parseInt(br.readLine());
            info = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++){
                info[i] = Integer.parseInt(st.nextToken());
            }
            team = new int[201][4];
            for (int i : info) {
                team[i][0] += 1;
            }
            int score = 1;
            int ans = Integer.MAX_VALUE;
            int res = 0;

            for (int i : info){
                if (team[i][0] >= 6){
                    if (team[i][2] < 4){
                        team[i][1] += score;
                        team[i][2] += 1;
                        score ++;
                    } else if (team[i][2] == 4) {
                        team[i][2] += 1;
                        team[i][3] += score;
                        score ++;
                    } else if (team[i][2] > 4) {
                        score ++;
                    }
                }
            }
            for (int i=1; i<201; i++){
                if (team[i][1] != 0){
                    if (ans > team[i][1]){
                        ans = team[i][1];
                        res = i;
                    }
                    if (ans == team[i][1]){
                        if (team[res][3] < team[i][3]){
                            continue;
                        }
                        else {
                            ans = team[i][1];
                            res = i;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
