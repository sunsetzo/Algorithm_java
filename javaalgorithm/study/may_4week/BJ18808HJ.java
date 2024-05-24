package study.may_4week;

import java.io.*;
import java.util.StringTokenizer;

public class BJ18808HJ {
    static int n, m, k, r, c, res;
    static int[][] sticker = new int[12][12];
    static boolean[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];
        while (k-- >0){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            for (int a=0; a<r; a++){
                st = new StringTokenizer(br.readLine());
                for (int b=0; b<c; b++){
                    sticker[a][b] = Integer.parseInt(st.nextToken());
                }
            }
            check:
            for (int rt=0; rt<4; rt++){
                for (int x=0; x<=n-r; x++){
                    for (int y=0; y<=m-c; y++){
                        if (isPossible(x, y)) {
                            put(x, y);
                            break check;
                        }
                    }
                }
                rotate();
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (board[i][j]) res++;
            }
        }
        System.out.println(res);
    }
    static void put(int i, int j){
        for (int x=0; x<r; x++){
            for (int y=0; y<c; y++){
                if (sticker[x][y]==1) board[x+i][y+j]=true;
            }
        }
    }
    static boolean isPossible(int i, int j){
        for (int x=0; x<r; x++){
            for (int y=0; y<c; y++){
                if (board[x+i][y+j] && sticker[x][y]==1) return false;
            }
        }
        return true;
    }
    static void rotate(){
        int[][] rSticker = new int[12][12];

        for (int i=0; i<r; i++) System.arraycopy(sticker[i], 0, rSticker[i], 0, c);

        for (int i=0; i<c; i++){
            for (int j=0; j<r; j++){
                sticker[i][j] = rSticker[r-1-j][i];
            }
        }
        int temp = r;
        r = c;
        c = temp;
    }
}
