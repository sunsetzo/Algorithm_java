package study.apr_3week;

import java.io.*;
import java.util.*;

public class BJ17281HJ {
    static int n, ans;
    static int[] players = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    static int[] order = new int[9];
    static boolean[] visit = new boolean[9];
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][9];
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        permPlayer(players, order, visit, 0, 9);
        System.out.println(ans);
    }
    static void permPlayer(int[] players, int[] order, boolean[] visit, int depth, int r){
        // 4번타자가 1번인 경우에만 함수 실행
        if (depth == r && order[3] == 0){
            int gameScore = playGame(order);
            ans = Math.max(ans, gameScore);
            return;
        }
        for (int i=0; i<9; i++){
            if (!visit[i]){
                visit[i] = true;
                order[depth] = players[i];
                permPlayer(players, order, visit, depth+1, r);
                visit[i] = false;
            }
        }
    }
    static int playGame(int[] order){
        // Now : 현재 선수 번호, sum : 게임이 끝난 후 점수의 합
        int now = 0; int sum = 0;
        for (int game = 0; game<n; game++){
            // score : 이닝 당 점수
            int score = 0; int outCount = 0;
            boolean[] base = new boolean[4];

            while (outCount<3){
                switch (arr[game][order[now]]){
                    case 0:
                        outCount++;
                        break;

                    case 1:
                        if (base[3]){
                            score ++;
                            base[3] = false;
                        }
                        if (base[2]){
                            base[3] = true;
                            base[2] = false;
                        }
                        if (base[1]){
                            base[2] = true;
                        }
                        base[1] = true;
                        break;

                    case 2:
                        if (base[3]){
                            score ++;
                            base[3] = false;
                        }
                        if (base[2]){
                            score++;
                        }
                        if (base[1]){
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;
                        break;

                    case 3:
                        if (base[3]){
                            score ++;
                        }
                        if (base[2]){
                            score ++;
                            base[2] = false;
                        }
                        if (base[1]){
                            score ++;
                            base[1] = false;
                        }
                        base[3] = true;
                        break;

                    case 4:
                        if (base[3]){
                            score ++;
                            base[3] = false;
                        }
                        if (base[2]){
                            score ++;
                            base[2] = false;
                        }
                        if (base[1]){
                            score++;
                            base[1] = false;
                        }
                        score ++;
                        break;
                }
                now ++;
                if (now>=9){
                    now = 0;
                }
            }
            sum += score;
        }
        return sum;
    }
}
