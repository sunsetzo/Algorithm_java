package study.feb_3week;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ2258HJ {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] cost = new int[n][2];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int mass = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            cost[i] = new int[]{mass, price};
        }

        Arrays.sort(cost, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 0 : 무게, 1 : 가격
                // 가격 오름차순 정렬
                // 같은 가격이라면, 무게 내림차순
                // 가격은 적으면서 무게는 큰 고기를 고르기 위함

                // 가격을 비교하여 오름차순으로 정렬
                if (Integer.compare(o1[1], o2[1]) == 0) {
                    // 가격이 같은경우, 무게를 비교하여 내림차순으로 정렬
                    return Integer.compare(o2[0], o1[0]);
                }
                // 가격이 다른 경우, 가격을 기준으로 오름차순 정렬
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // 특정 고기까지 구입했을 때 지불해야 하는 돈
        int totalPrice = -1;
        // 특정 고기까지 구입했을 때의 총 그램 수
        int totalGram = 0;
        // 목표 무게까지 살 수 있는지 판단
        int ans = Integer.MAX_VALUE;
        boolean isPossible = false;

        for (int i=0; i<n; i++){
            // 목표 무게를 넘었더라도 가격이 더 싸면 사기 때문에
            // 모든 고기를 다 산다고 가정해야 함

            // 고기 구입
            totalGram += cost[i][0];

            // 이전과 같은 가격일 경우
            if (i>0 && cost[i-1][1] == cost[i][1]){
                // = 돈 주고 사야함
                totalPrice += cost[i][1];
            } else {
                // 이전과 가격이 다르면
                // 가격은 오름차순 정렬 되어 있기 때문에
                // 해당 가격 이전의 고기들(=싼 고기) 공짜로 구입 가능
                // = 총 금액 갱신
                totalPrice = cost[i][1];
            }

            if (totalGram >= m){
                // 목표 무게 달성 시,
                isPossible = true;
                // 목표 무게를 넘었더라도 가격이 더 싼 것을 구매
                ans = Math.min(ans, totalPrice);
            }
        }

        bw.write(isPossible ? ans + "\n" : -1 + "\n" );
        bw.flush();
        bw.close();
    }
}