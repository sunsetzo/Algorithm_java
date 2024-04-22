package boj;

import java.io.*;
public class BOJ2720 {
    static int t, c;
    static int[] coins = {25, 10, 5, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        for (int tc=0; tc<t; tc++){
            c = Integer.parseInt(br.readLine());
            while (c > 0){
                for (int coin : coins){
                    if (c/coin > 0){
                        sb.append(c/coin).append(" ");
                        c %= coin;
                    }else{
                        sb.append(0).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
