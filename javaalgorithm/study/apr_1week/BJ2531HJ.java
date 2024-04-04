package study.apr_1week;

import java.io.*;
import java.util.*;

public class BJ2531HJ {
    static int n, d, k, c, ans;
    static int[] convey;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        convey = new int[n];

        for (int i=0; i<n; i++){
            convey[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d+1]; // 초밥 종류별 카운트 (초밥 번호가 1부터 시작하므로 +1)
        int total = 0; // 현재 선택된 초밥의 종류 수

        // 초기 윈도우 설정
        for (int i=0; i<k; i++){
            if (sushi[convey[i]] == 0) total++;
            sushi[convey[i]]++;
        }
        // 쿠폰 초밥 처리
        if (sushi[c]==0) ans = total+1;
        else ans = total;

        // 슬라이딩 윈도우 이동
        for (int i=1; i<n; i++){
            if (ans <= total){
                if (sushi[c]==0) ans = total +1;
                else ans = total;
            }
            // 왼쪽 초밥 제거
            int left = i-1;
            sushi[convey[left%n]]--;
            if (sushi[convey[left%n]] == 0) total--;

            // 오른쪽 초밥 추가
            int right = (i+k-1)%n;
            if (sushi[convey[right]]==0) total++;
            sushi[convey[right]]++;

            // 쿠폰 초밥 처리
            if (sushi[c]==0 && ans<total+1){
                ans = total+1;
            }
        }
        System.out.println(ans);
    }
}