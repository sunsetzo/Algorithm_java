package study.feb_2week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ19939HJ {
    static int n, k, sum, res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 바구니에 순차적(한개씩 늘어나게)으로 공을 넣음
        for (int i=1; i<=k; i++){
            sum+=i;
        }
        n -= sum;
        // 바구니에 공의 개수가 같은 경우가 있음
        if (n<0){
            res = -1;
        } else {
            // 바구니에 든 각 공의 갯수가 1개씩 차이남 (n-(n-k+1))
            if (n%k == 0){
                res = k-1;
            // 공이 남으면 공이 가장 많이 든 바구니부터 채워나가야함
            // (n+1)-(n-k+1)
            }else{
                res = k;
            }
        }
        System.out.println(res);
    }
}
