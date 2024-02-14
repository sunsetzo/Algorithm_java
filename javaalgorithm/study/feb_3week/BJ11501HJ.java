package study.feb_3week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11501HJ {
    static int t, n;
    static int[] stock;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            stock = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                stock[j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long ans = 0;
            // 역순으로 탐색
            // 값이 커지는 시점은 최댓값이 갱신되는 때
            // 값이 작아지는 시점은 이익에 (최댓값-주가)를 더해주면됨
            for (int k=n-1; k>=0; k--){
                if (stock[k] > max){
                    max = stock[k];
                } else {
                    ans += max-stock[k];
                }
            }
            System.out.println(ans);

        }
    }
}
