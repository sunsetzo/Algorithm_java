package study.jan_5week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1049HJ {
    static int n, m;
    static int pack, piece;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pack = Integer.MAX_VALUE;
        piece = Integer.MAX_VALUE;

        // 입력값중 최솟값 찾기
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            piece = Math.min(piece, Integer.parseInt(st.nextToken()));
        }

        int pi = piece * n;
        // 모두 패키지로 사는 것 vs. 패키지 + 낱개로 사는 것
        int pa = Math.min(((n/6)+1) * pack, (n/6)*pack + (n%6)*piece);

        res = Math.min(pi, pa);

        System.out.println(res);
    }
}