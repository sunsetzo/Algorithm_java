package study.apr_1week;

import java.io.*;
import java.util.*;

public class BJ4659HJ {
    static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            int con = 0; int vow = 0; int continue_vow = 0;
            boolean err = false;
            int n = input.length();

            for (int i=0; i<n; i++){
                if (i>0 && input.charAt(i)==input.charAt(i-1)){
                    if (input.charAt(i) != 'e' && input.charAt(i)!='o'){
                        err = true;
                        break;
                    }
                }
                if (vowels.contains(input.charAt(i))){
                    vow ++; continue_vow ++;
                    con = 0;
                    if (continue_vow == 3){
                        err = true;
                        break;
                    }
                }
                else{
                    con ++;
                    continue_vow = 0;
                    if (con==3){
                        err = true;
                        break;
                    }
                }
            }
            if (!err && vow>0){
                System.out.println("<" + input + "> is acceptable.");
            }else{
                System.out.println("<" + input + "> is not acceptable.");
            }
        }
    }
}
