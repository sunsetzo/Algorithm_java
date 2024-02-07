package study.feb_2week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10816HJ {
    static int n, m;
    static int[] cards;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        cards = new int[n];
        for (int i=0; i<n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(cards);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            int lower = lowerNum(num);
            int upper = upperNum(num);

            sb.append(upper-lower).append(" ");
        }

        System.out.println(sb);

    }
    // 하한선 구하기 (해당하는 숫자의 가장 작은 idx)
    public static int lowerNum(int num){
        int start = 0;
        int end = cards.length;

        while (start<end){
            int mid = (start+end)/2;
            // 상한선과 하한선 구하는 로직의 차이점
            if (num <= cards[mid]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
    // 상한선 구하기 (해당하는 숫자의 idx +1)
    public static int upperNum(int num){
        int start = 0;
        int end = cards.length;

        while (start<end){
            int mid = (start+end)/2;
            // 상한선과 하한선 구하는 로직의 차이점
            if (num < cards[mid]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
}
