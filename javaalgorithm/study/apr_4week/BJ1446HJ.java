package study.apr_4week;

import java.io.*;
import java.util.*;

public class BJ1446HJ {
    static int n, d;
    static int[] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n][3];

        // 지름길 정보 입력 받기
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()); // 시작점, 끝점, 지름길의 길이 입력 받음
            }
        }

        dp = new int[d+1]; // 목적지까지 각 거리를 저장할 배열 초기화, 거리는 0부터 d까지이므로 d+1 크기 할당
        for (int i=0; i<=d; i++){
            dp[i] = i; // 일단 최악의 경우, 거리만큼 이동한다고 초기 설정 (지름길을 전혀 사용하지 않는 경우)
        }

        for (int i=0; i<=d; i++){
            dp[i] = Math.min(dp[i], (i>0) ? dp[i-1]+1 : dp[i]); // 현재 거리까지 오는데 필요한 최소 이동 거리를 계산
            for (int j=0; j<n; j++){
                int s = arr[j][0]; // 지름길의 시작점
                int e = arr[j][1]; // 지름길의 끝점
                int w = arr[j][2]; // 지름길을 이용했을 때 거리
                if (i == s && e <= d){ // 현재 위치에서 지름길을 사용할 수 있는 경우
                    dp[e] = Math.min(dp[e], dp[i] + w); // 지름길을 사용하여 끝점까지 가는 거리와 기존의 거리를 비교해 더 작은 값으로 업데이트
                }
            }
        }

        System.out.println(dp[d]); // 목적지까지의 최소 이동 거리 출력
    }
}