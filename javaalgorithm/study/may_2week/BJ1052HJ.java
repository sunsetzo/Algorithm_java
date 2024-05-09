package study.may_2week;

import java.io.*;
import java.util.*;

import static java.lang.Integer.bitCount;

public class BJ1052HJ {
    static int n, k, ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        String bitN = Integer.toBinaryString(n);    // 이진수 변환
        int cnt = Integer.bitCount(n);      // n을 이진수로 변환했을 때 1의 갯수 ( = 물병을 최대로 합칠 때, 물이 채워져 있는 물병의 갯수)
        int idx = -1;
        // 1의 갯수가 k보다 작으면, 물병을 구입하지 않아도 합칠 수 있음
        if (cnt > k){
            for (int i=0; i<bitN.length(); i++){
                if (k==0){
                    idx = i;
                    break;
                }
                if (bitN.charAt(i)=='1'){
                    k--;
                }
            }
            String temp = bitN.substring(idx);      //2의 거듭제곱으로 만들어줘야하는 이진수
            int t = Integer.parseInt(temp, 2); // Temp의 십진수값

            if (t!=0){  // 물병 사야하는 갯수 구하기
                ans = (int) (Math.pow(2, bitN.length()-idx)-t);
            }
        }
        System.out.println(ans);
    }
}
