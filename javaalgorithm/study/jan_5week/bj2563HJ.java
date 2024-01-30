package study.jan_5week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2563HJ {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[101][101];
        int res = 0;

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int x=s; x<s+10; x++){
                for (int y=e; y<e+10; y++){
                    if (!arr[x][y]){
                        arr[x][y] = true;
                        res ++;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
