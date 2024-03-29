package study.mar_5week;

import java.io.*;
import java.util.*;

public class BJ2138HJ {
    static int n;
    static int[] current, goal, another;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String input1 = br.readLine();
        String input2 = br.readLine();
        current = new int[n]; goal = new int[n];
        for (int i=0; i<n; i++){
            current[i] = input1.charAt(i)-'0';
            goal[i] = input2.charAt(i)-'0';
        }
        another = Arrays.copyOf(current, n);
        another[0] = 1-another[0];
        another[1] = 1-another[1];

        int res1 = switches(current, goal);
        int res2 = switches(another, goal);

        if (res2 != -1) res2++;

        if (res1 == -1){
            System.out.println(res2);
        }else if(res2 == -1){
            System.out.println(res1);
        }else{
            System.out.println(Math.min(res1, res2));
        }

    }
    static int switches(int[] now, int[] next){
        int cnt = 0;
        for (int i=0; i<n-1; i++){
            if (now[i] != next[i]){
                cnt ++;
                now[i] = 1-now[i];
                now[i+1] = 1-now[i+1];
                if (i != n-2){
                    now[i+2] = 1-now[i+2];
                }
            }
        }
        return now[n-1]!=next[n-1] ? -1 : cnt;
    }
}