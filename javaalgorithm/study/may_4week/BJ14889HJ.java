package study.may_4week;

import java.io.*;
import java.util.*;

public class BJ14889HJ {
    static int n;
    static int[][] arr;
    static boolean[] island;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        island = new boolean[n];
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(team(0, 0));
    }
    static int team(int l, int k){
        int star = 0; int link = 0;
        if (k == n/2){
            for (int i=0; i<n; i++){
                for (int j=i+1; j<n; j++){
                    if (island[i] && island[j]){
                        star += arr[i][j] + arr[j][i];
                    }
                    if (!island[i] && !island[j]){
                        link += arr[i][j] + arr[j][i];
                    }
                }
            }
            return Math.abs(star-link);
        }
        for (int w=l; w<n; w++){
            island[w] = true;
            int temp = team(w+1, k+1);
            if (temp<res){
                res = temp;
            }
            island[w] = false;
        }
        return res;
    }
}
