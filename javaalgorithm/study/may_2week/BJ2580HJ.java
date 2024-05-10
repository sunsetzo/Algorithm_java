package study.may_2week;

import java.io.*;
import java.util.*;

public class BJ2580HJ {
    static int[][] sudoku;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        for (int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        put(0,0);

    }
    static void put(int x, int y){
        if (y==9){
            put(x+1, 0);
            return;
        }

        if (x==9){
            for (int i=0; i<9; i++){
                for (int j=0; j<9; j++){
                    System.out.print(sudoku[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (sudoku[x][y] == 0){
            for (int i=1; i<10; i++){
                if (chk(x, y, i)){
                    sudoku[x][y] = i;
                    put(x, y+1);
                }
            }
            sudoku[x][y] = 0;
            return;
        }
        put(x, y+1);
    }
    static boolean chk(int x, int y, int value){
        // 가로
        for (int i=0; i<9; i++){
            if (sudoku[x][i] == value){
                return false;
            }
        }

        // 세로
        for (int j=0; j<9; j++){
            if (sudoku[j][y] == value){
                return false;
            }
        }

        // 3*3
        int col_x = (x/3) *3;
        int row_y = (y/3) *3;
        for (int i=col_x; i<col_x+3; i++){
            for (int j=row_y; j<row_y+3; j++){
                if (sudoku[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }
}