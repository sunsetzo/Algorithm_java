package study.apr_4week;

import java.io.*;
import java.util.*;
public class BJ2607HJ {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int count = 0;
        for (int i = 1; i < n; i++) {
            ArrayList<Character> compare = new ArrayList<>();
            for (char ch : first.toCharArray()) {
                compare.add(ch);
            }

            String word = br.readLine();
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
