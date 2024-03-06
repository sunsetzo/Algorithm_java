package study.mar_2week;

import java.io.*;
import java.util.*;

public class BJ20437HJ {
    static int T, k;
    static String w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            w = br.readLine();
            k = Integer.parseInt(br.readLine());

            // k가 1인 경우는 답이 한가지 밖에 없음
            if (k==1){
                System.out.println("1 1");
                continue;
            }

            // 알파벳 갯수 저장
            int[] alpha = new int[26];
            for (int i=0; i<w.length(); i++){
                alpha[w.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;    //가장 짧은 문자열
            int max = Integer.MIN_VALUE;    //가장 긴 문자열
            for (int i=0; i<w.length(); i++){
                // 알파벳 갯수가 k개보다 작으면 조건에 만족하지 않으므로 넘어감
                if (alpha[w.charAt(i)-'a'] < k) continue;

                int cnt = 1;
                for (int j=i+1; j<w.length(); j++){
                    if (w.charAt(i) == w.charAt(j)) cnt ++;
                    if (cnt == k){
                        min = Math.min(min, j-i+1);
                        max = Math.max(max, j-i+1);
                        break;
                    }
                }
            }
            // 둘 중에 하나라도 만족하는 문자열이 없다면 -1 출력
            if (min==Integer.MAX_VALUE||max==Integer.MIN_VALUE) System.out.println(-1);
            else System.out.println(min + " " + max);
        }
    }
}
