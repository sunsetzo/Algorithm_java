package study.mar_1week;

import java.io.*;
import java.util.*;

public class BJ17135 {
    static int n, m, d, res;
    static int[][] board, copyBoard;
    static int[] archer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        archer = new int[3];
        board = new int[n][m];
        copyBoard = new int[n][m];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                copyBoard[i][j] = board[i][j];
            }
        }
        combi(0,0);
        System.out.println(res);
    }
    // 궁수 위치 구하기(조합)
    static void combi(int idx, int start){
        if (idx == 3){
            init();
            attack();
            return;
        }
        for (int i=start; i<m; i++){
            archer[idx] = i;
            combi(idx+1, i+1);
        }
    }
    static void attack(){
        int cnt = 0;
        for (int game=0; game<n; game++){
            boolean[][] killEnemy = new boolean[n][m];
            for (int k=0; k<3; k++){
                int arc = archer[k];
                boolean killed = false;
                int minD = Integer.MAX_VALUE;
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;
                for (int i=0; i<n; i++){
                    for (int j=0; j<m; j++){
                        if (board[i][j] == 1){
                            // 거리계산
                            int dis = getDistance(n, arc, i, j);
                            if (dis < minD){
                                minD = dis;
                                minX = i;
                                minY = j;
                                killed = true;
                            // 최소거리가 같으면 더 왼쪽에 있는 것으로 선택
                            } else if (dis == minD) {
                                if (j<minY){
                                    minX = i;
                                    minY = j;
                                    killed = true;
                                }
                            }
                        }
                    }
                }
                // 각 궁수가 공격할 적을 찾은 후, 모든 궁수가 공격 대상을 찾은 뒤에 한 번에 적을 죽여야 함
                if (killed && minD<=d){
                    killEnemy[minX][minY] = true;
                }
            }
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    if (killEnemy[i][j]){
                        cnt ++;
                        board[i][j] = 0;
                    }
                }
            }
            // 적들이 한칸씩 움직임
            moveEnemy();
        }
        res = Math.max(res, cnt);
    }
    static void init(){
        // 새로운 궁수의 조합일때마다 기존의 배열을 사용해줘야함
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                board[i][j] = copyBoard[i][j];
            }
        }
    }
    static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x2-x1)+Math.abs(y2-y1);
    }
    static void moveEnemy(){
        for (int i=n-1; i>0; i--){
            for (int j=0; j<m; j++){
                board[i][j] = board[i-1][j];
            }
        }
        Arrays.fill(board[0], 0);
    }
}
