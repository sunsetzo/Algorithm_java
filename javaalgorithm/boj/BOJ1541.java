package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
    static String[] cals;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cals = br.readLine().split("-");

        for (int i=0; i<cals.length; i++){
            int sum = 0;
            String[] cal = cals[i].split("\\+");
            for (int j=0; j<cal.length; j++){
                sum += Integer.parseInt(cal[j]);
            }
            if (i==0){
                res += sum;
            }else {
                res -= sum;
            }
        }
        System.out.println(res);
    }
}
