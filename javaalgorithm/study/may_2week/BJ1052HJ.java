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
        int cnt = Integer.bitCount(n);      // n을 이진수로 변환했을 때 1의 갯수
        int idx = -1;
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
            String temp = bitN.substring(idx);
            int t = Integer.parseInt(temp, 2);

            if (t!=0){
                ans = (int) (Math.pow(2, bitN.length()-idx)-t);
            }
        }
        System.out.println(ans);
    }
}
