package study.feb_4week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ3584HJ {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] info;
    static boolean[] visit;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            info = new int[n+1];
            visit = new boolean[n+1];

            for (int i=0; i<n-1; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 부모 정보를 저장
                info[b] = a;
            }

            // 조상 찾아야하는 노드
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            find(x, y);
        }
    }
    static void find(int x, int y){
        // x 노드를 루트 노드까지 이동
        while (x > 0){
            visit[x] = true;
            x = info[x];
        }
        // y 노드를 루트 노드로 이동시키면서 visit가 true인 값을 탐색 (= x와의 공통조상)
        while (y > 0){
            if (visit[y]){
                System.out.println(y);
                break;
            }
            y = info[y];
        }
    }
}
