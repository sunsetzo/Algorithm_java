package study.feb_3week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15685HJ {
    static int n;
    //0: x좌표가 증가하는 방향 (→)
    //1: y좌표가 감소하는 방향 (↑)
    //2: x좌표가 감소하는 방향 (←)
    //3: y좌표가 증가하는 방향 (↓)
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] graph = new int[101][101];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;

            // 커브방향 리스트 만들기
            ArrayList<Integer> curve = new ArrayList<Integer>();
            curve.add(d);
            for (int j=0; j<g; j++){
                // curve에 있는 방향들을 마지막부터 뽑으면서 반시계 방향으로 한번 돌린 것을 다시 curve에 추가
                for (int k=curve.size()-1; k>-1; k--){
                    curve.add((curve.get(k)+1)%4);
                }
            }

            // 드래곤 커브 만들기
            for (int w=0; w<curve.size(); w++){
                x += dx[curve.get(w)];
                y += dy[curve.get(w)];
                if (x<0 || x>=101 || y<0 || y>=101){
                    continue;
                }
                graph[x][y] = 1;
            }
        }

        int res = 0;

        // 네 꼭짓점이 드래곤커브인 것 찾기
        for (int i=0; i<100; i++){
            for (int j=0; j<100; j++){
                if (graph[i][j] == 1 && graph[i+1][j] == 1 && graph[i][j+1] == 1 && graph[i+1][j+1] == 1){
                    res += 1;
                }
            }
        }
        System.out.println(res);
    }
}
