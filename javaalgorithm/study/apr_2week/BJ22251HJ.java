package study.apr_2week;

import java.io.*;
import java.util.*;

// 반전시켜서 만들 수 있는 수로 확인

public class BJ22251HJ {
    static int n, k, p, x;
    // 표시등에 대한 정보 (0~9)
    static int[][] display = {{1, 1, 1, 0, 1, 1, 1},
                            {0, 0, 1, 0, 0, 0, 1},
                            {0, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 0, 1, 1},
                            {1, 0, 1, 1, 0, 0, 1},
                            {1, 1, 0, 1, 0, 1, 1},
                            {1, 1, 0, 1, 1, 1, 1},
                            {0, 1, 1, 0, 0, 0, 1},
                            {1, 1, 1, 1, 1, 1, 1},
                            {1, 1, 1, 1, 0, 1, 1}};
    static long cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int[] digit = transferDigit(x); // k자리 수로 만들어 주기
        check(0, digit);    // 확인하는 함수
        System.out.println(cnt);
    }
    static int[] transferDigit(int x){
        int[] res = new int[k];
        for (int i=k-1; i>=0; i--){
            res[i] = x%10;
            x /= 10;
        }
        return res;
    }
    static void check(int num, int[] digit){
        for (int i=1; i<=n; i++){
            if (i==x)continue;  // 같은 경우는 pass
            if (reverse(i, digit)) cnt ++;  // true일때만 cnt +1
        }
    }
    static boolean reverse(int target, int[] digit){
        int[] target_digit = transferDigit(target);     // target 숫자도 디지털 형식으로 변형

        int diff = 0;
        for (int i=0; i<k; i++){
            for (int j=0; j<7; j++){
                if (display[digit[i]][j] != display[target_digit[i]][j]){
                    diff ++;
                    if (diff > p) return false;     // p개 이내의 표시등만 변경해야하기 때문
                }
            }
        }
        return true;
    }
}