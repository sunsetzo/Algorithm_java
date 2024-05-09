package study.may_2week;

import java.io.*;
import java.util.*;

public class BJ17136HJ {
    static int[][] arr;
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[10][10];
        for (int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<10; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0);
        System.out.println(ans==Integer.MAX_VALUE? -1:ans);

    }
    static void dfs(int x, int y, int cnt){
        if (x>=9 && y>9){
            ans = Math.min(ans, cnt);
            return;
        }
        if (ans <= cnt){
            return;
        }

        if (y>9){
            dfs(x+1, 0, cnt);
            return;
        }

        if (arr[x][y] == 1){
            for (int k=5; k>0; k--){
                if (paper[k]>0 && isPossible(x, y, k)){
                    put(x, y, k, 0);
                    paper[k] --;
                    dfs(x, y+1, cnt+1);
                    put(x, y, k, 1);
                    paper[k] ++;
                }
            }
        }else{
            dfs(x, y+1, cnt);
        }
    }
    static void put(int x, int y, int size, int state){
        for (int i=x; i<x+size; i++){
            for (int j=y; j<y+size; j++){
                arr[i][j] = state;
            }
        }
    }
    static boolean isPossible(int x, int y, int size){
        for (int i=x; i<x+size; i++){
            for (int j=y; j<y+size; j++){
                if (i<0 || i>=10 || j<0 || j>=10){
                    return false;
                }
                if (arr[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }
}
