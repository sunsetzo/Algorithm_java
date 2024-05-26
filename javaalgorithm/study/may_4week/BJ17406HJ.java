package study.may_4week;

import java.io.*;
import java.util.*;

public class BJ17406HJ {
    static int res = Integer.MAX_VALUE;
    static int n, m, k;
    static int[][] arr, info;
    static int[] order, index;
    static boolean[] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        index = new int[k];
        order = new int[k];
        visit = new boolean[k];
        info = new int[k][3];
        for (int i=0; i<k; i++){
            index[i] = i;
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        perm(k, 0);
        System.out.println(res);
    }
    // 돌리는 순서 순열
    static void perm(int N, int k){
        if (N==k){
            int[][] Narr = new int[n][m];
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    Narr[i][j] = arr[i][j];
                }
            }
            rotate(order, Narr);
            findMin(Narr);
        }else {
            for (int i=0; i<N; i++){
                if (!visit[i]){
                    visit[i] = true;
                    order[k] = index[i];
                    perm(N, k+1);
                    visit[i] = false;
                }
            }
        }
    }
    // 배열 회전
    static void rotate(int[] order, int[][] Narr){
        for (int idx : order){
            int r = info[idx][0]; int c = info[idx][1]; int s = info[idx][2];
            int x1 = r-s-1; int y1 = c-s-1;
            int x2 = r+s-1; int y2 = c+s-1;

            while (true){
                if (x1>=x2 || y1>=y2) break;
                int dir = 0;
                int x = x1; int y = y1; int before = Narr[x1][y1];
                while (true){
                    int nx = x+dx[dir]; int ny = y+dy[dir];
                    if (x1> nx || nx > x2 || y1>ny || ny>y2){
                        dir++;
                        continue;
                    }
                    int temp = Narr[nx][ny];
                    Narr[nx][ny] = before;
                    before = temp;
                    x = nx; y = ny;
                    if (x==x1 && y==y1){
                        x1++; y1++; x2--; y2--;
                        break;
                    }
                }
            }
        }
    }
    // 최솟값 찾기
    static void findMin(int[][] Narr){
        for (int i=0; i<n; i++){
            int temp = 0;
            for (int j=0; j<m; j++){
                temp += Narr[i][j];
            }
            if (res>temp){
                res = temp;
            }
        }
    }
}
