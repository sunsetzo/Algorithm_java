package study.apr_3week;

import java.io.*;

public class BJ5904 {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        madeMoo(1, "moo");
    }
    static void madeMoo(int num, String seq){
        if (seq.length() > n){
            System.out.println(seq.charAt(n-1));
            return;
        }else {
            String temp = seq;
            temp += "m";
            temp += "o".repeat(num + 2);
            temp += seq;
            madeMoo(num + 1, temp);
        }
    }
}