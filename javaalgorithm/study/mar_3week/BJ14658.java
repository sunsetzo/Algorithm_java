package study.mar_3week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14658 {
    static int N, M, L, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] stars = new int[K][2]; // 별똥별의 좌표를 저장할 배열

        // 별똥별의 좌표 입력 받기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        // 트램펄린이 위치할 수 있는 범위에서 별똥별이 부딪히는 횟수 세기
        int answer = 0;
        for (int i = 0; i <= N - L+1; i++) {
            for (int j = 0; j <= M - L+1; j++) {
                int count = countCollisions(i, j, stars); // 트램펄린이 위치할 때의 별똥별 충돌 횟수 계산
                answer = Math.max(answer, count); // 최대 충돌 횟수 갱신
            }
        }

        System.out.println(K-answer); // 지구에 부딪히는 별똥별 수 출력
    }

    // 트램펄린이 위치할 때의 별똥별 충돌 횟수 계산하는 메소드
    static int countCollisions(int x, int y, int[][] stars) {
        int count = 0;
        for (int[] star : stars) {
            int starX = star[0];
            int starY = star[1];
            if (x <= starX && starX < x + L && y <= starY && starY < y + L) {
                count++;
            }
        }
        return count;
    }
}
