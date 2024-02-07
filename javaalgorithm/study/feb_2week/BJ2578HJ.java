package study.feb_2week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2578HJ {
    static int[][] bingo;
    static int cnt;
    static int turn = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[5][5];

        // 빙고 입력
        for (int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++){
                int num = Integer.parseInt(st.nextToken());
                for (int x=0; x<5; x++){
                    for (int y=0; y<5; y++){
                        // 입력받은 수를 찾아서 0으로 변경
                        if (bingo[x][y] == num){
                            bingo[x][y] = 0;
                        }
                    }
                }
                chk_col();
                chk_row();
                chk_right();
                chk_left();

                if (cnt>=3){
                    System.out.println(turn);
                    System.exit(0);
                }

                cnt = 0;
                turn ++;
            }
        }
    }
    // 가로, 세로 확인
    public static void chk_col(){
        for (int i=0; i<5; i++){
            int count = 0;
            for (int j=0; j<5; j++){
                if (bingo[i][j] == 0){
                    count ++;
                }
                if (count == 5){
                    cnt ++;
                }
            }
        }
    }
    public static void chk_row(){
        for (int i=0; i<5; i++){
            int count = 0;
            for (int j=0; j<5; j++){
                if (bingo[j][i] == 0){
                    count ++;
                }
                if (count == 5){
                    cnt ++;
                }
            }
        }
    }
    // 대각선 확인
    public static void chk_right(){
        int count = 0;
        for (int i=0; i<5; i++){
            if (bingo[i][4-i] == 0){
                count ++;
            }
            if (count == 5){
                cnt ++;
            }
        }
    }
    public static void chk_left(){
        int count = 0;
        for (int i=0; i<5; i++){
            if (bingo[i][i] == 0){
                count ++;
            }
            if (count == 5){
                cnt ++;
            }
        }
    }
}
