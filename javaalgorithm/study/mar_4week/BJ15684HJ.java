package study.mar_4week;

import java.io.*;
import java.util.*;

public class BJ15684HJ {
    static int n, m, h;
    static boolean[][] ladder;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new boolean[h+1][n+1];
        if (m==0){
            // 사다리가 안놓여져 있으면 0 출력
            System.out.println(0);
        }else{
            for (int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                ladder[a][b] = true;
            }
            for (int i=0; i<=3; i++){
                comb(1, 0, i);
            }
            System.out.println(-1);
        }
    }
    // 사다리를 놓는 경우의 수(재귀)
    static void comb(int row, int cnt, int size){
        // cnt와 size가 같다면 사다리타기 확인
        if (cnt == size){
            if (check()){
                System.out.println(size);
                System.exit(0);
            }
            return;
        }
        for (int r=row; r<=h; r++){
            for (int c=1; c<n; c++){
                // 사다리가 있는 경우는 continue
                if (ladder[r][c]) continue;
                if (ladder[r][c-1]) continue;
                if (ladder[r][c+1]) continue;
                // 없으면 놓아본 후, 재귀 진행
                ladder[r][c] = true;
                comb(r, cnt+1, size);
                ladder[r][c] = false;
            }
        }
    }
    // i에서 i로 도착하는 사다리가 맞는지 확인
    static boolean check(){
        for (int i=1; i<=n; i++){
            int curPosition = i;
            int start = 1;
            while (start <= h){
                // 현재 위치에 사다리가 놓여져 있으면 오른쪽으로 이동
                if (ladder[start][curPosition]){
                    curPosition++;
                    start++;
                // 왼쪽으로 이동하는 경우
                } else if (ladder[start][curPosition-1]) {
                    curPosition--;
                    start++;
                // 사다리가 없으면 아래로 이동
                }else {
                    start++;
                }
            }
            // i -> i 아닌 경우 false return
            if (i!=curPosition){
                return false;
            }
        }
        return true;
    }
}
