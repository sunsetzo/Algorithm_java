package study.apr_1week;

import java.io.*;
import java.util.*;

public class BJ22233HJ {
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<String, Boolean> keyword = new HashMap<>();

        for (int i=0; i<n; i++){
            String input = br.readLine();
            keyword.put(input, true);
        }
        int cnt = n;
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()){
                String s = st.nextToken();
                if (keyword.containsKey(s)){
                    keyword.remove(s);
                    cnt --;
                }
            }
            System.out.println(cnt);
        }
    }
}
