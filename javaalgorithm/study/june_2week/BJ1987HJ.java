package study.june_2week;

import java.io.*;
import java.util.*;

public class BJ1987HJ {
    static int r, c, ans;
    static String[][] arr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new String[r][c];
        for (int i=0; i<r; i++){
            arr[i] = br.readLine().split("");
        }
        set.add(arr[0][0]);
        dfs(0, 0, 1);

        System.out.println(ans);
    }
    static void dfs(int i, int j, int cnt){
        ans = Math.max(ans, cnt);
        for (int w=0; w<4; w++){
            int ni = i+di[w]; int nj= j+dj[w];
            if (0<=ni && ni<r && 0<=nj && nj<c){
                if (!set.contains(arr[ni][nj])){
                    set.add(arr[ni][nj]);
                    dfs(ni, nj, cnt+1);
                    set.remove(arr[ni][nj]);
                }
            }
        }
    }
}
