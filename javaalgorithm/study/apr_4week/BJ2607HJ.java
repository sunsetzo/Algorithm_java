package study.apr_4week;

import java.io.*;
import java.util.*;
public class BJ2607HJ {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String first = br.readLine();   // 첫번째 단어
        int count = 0;  // 정답 변수
        for (int i = 1; i < n; i++) {
            ArrayList<Character> compare = new ArrayList<>();   //첫번째 단어를 char 타입의 arraylist로 변환
            for (char ch : first.toCharArray()) {
                compare.add(ch);
            }

            String word = br.readLine();    // 비교 단어
            int cnt = 0;

            for (char w : word.toCharArray()) {
                if (compare.contains(w)) {
                    compare.remove((Character) w);
                } else {
                    cnt += 1;
                }
            }

            if (cnt < 2 && compare.size() < 2) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
