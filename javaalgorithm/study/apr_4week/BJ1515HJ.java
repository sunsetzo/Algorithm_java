package study.apr_4week;

import java.io.*;
import java.util.*;

public class BJ1515HJ {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int p = 0;
        int num = 0;
        while (num ++ <= 30000){
            String temp = String.valueOf(num);
            for (int i=0; i<temp.length(); i++){
                if (temp.charAt(i) == n.charAt(p)) p++;
                if (p == n.length()){
                    System.out.println(num);
                    System.exit(0);
                }
            }
        }
    }
}