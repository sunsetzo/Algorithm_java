package study.jan_5week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2839HJ {
    static int n;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while (true){
            if (n%5==0){
                res += (n/5);
                System.out.println(res);
                break;
            }
            n-=3;
            res +=1;

            if (n<0){
                System.out.println(-1);
                break;
            }
        }
    }
}
