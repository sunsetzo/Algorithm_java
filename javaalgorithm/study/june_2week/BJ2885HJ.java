package study.june_2week;

import java.io.*;
import java.util.*;

public class BJ2885HJ {
    static int k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        int n = 1;
        int cnt = 0;
        while (n<k) n = n*2;

        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ");

        while (k>0){
            if (k>=n){
                k-=n;
            }else{
                n/=2;
                cnt++;
            }
        }
        sb.append(cnt);

        System.out.println(sb);

    }
}
