package boj;

import java.io.*;
import java.util.*;

public class PasswordPronounce {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        while (true) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            if (text.equals("end")) break;

            int con = 0;
            int vow = 0;
            int continue_vow = 0;
            boolean err = false;
            int N = text.length();

            for (int i = 0; i<N; i++){
                if (i>0 && text.charAt(i)==text.charAt(i-1)){
                        if (text.charAt(i) != 'e' && text.charAt(i) != 'o'){
                            err = true;
                            break;
                    }
                }
                if (vowels.contains(text.charAt(i))) {
                    vow ++;
                    continue_vow ++;
                    con = 0;
                    if (continue_vow==3){
                        err = true;
                        break;
                    }
                }else {
                    con ++;
                    continue_vow = 0;
                    if (con == 3){
                        err = true;
                        break;
                    }
                }
            }
            if (!err && vow>0) {
                System.out.println("<" + text + "> is acceptable.");
            } else {
                System.out.println("<" + text + "> is not acceptable.");
            }
        }
    }
}
