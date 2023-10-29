package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MiniGame {
    private static int getGame(char g){
        switch (g){
            case 'Y': return 1;
            case 'F': return 2;
            case 'O': return 3;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = getGame(st.nextToken().charAt(0));

        HashSet<String> hs = new HashSet<>();
        int cnt = 0;
        while (n-->0){
            String cur = br.readLine();
            cnt += hs.contains(cur)? 0:1;
            hs.add(cur);
        }
        System.out.println(cnt/p);
    }
}
