package study.june_2week;

import java.io.*;
import java.util.*;

public class BJ3109HJ {
    static int r, c, cnt;
    static boolean[][] visit;
    static char[][] arr;
    static int[] ds = {-1, 0, 1};
    static int[] de = {1, 1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visit = new boolean[r][c];
        for (int i=0; i<r; i++){
            String input = br.readLine();
            for (int j=0; j<c; j++){
                arr[i][j] = input.charAt(j);
            }
        }

        for (int i=0; i<r; i++){
            sol(i, 0);
        }
        System.out.println(cnt);
    }
    static boolean sol(int s, int e){
        visit[s][e] = true;
        for (int w=0; w<3; w++){
            int ns = s+ds[w]; int ne = e+de[w];
            if (0<=ns && ns<r && 0<=ne && ne<c){
                if (ne == c-1){
                    cnt++;
                    return true;
                }
                if (!visit[ns][ne] && arr[ns][ne]=='.'){
                    visit[ns][ne] = true;
                    if (sol(ns, ne)) return true;
                }
            }
        }
        return false;
    }
}