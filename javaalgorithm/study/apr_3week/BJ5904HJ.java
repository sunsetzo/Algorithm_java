package study.apr_3week;

import java.io.*;

public class BJ5904HJ {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        System.out.println(findMoo(n));

    }
    static char findMoo(int n){
        int length = 3; // 초기 문자의 길이
        int k = 0;
        // n을 찾기 위해 전체 길이 만들기
        while (n > length){
            k++;
            length = 2*length+(k+3);    // 다음 단계의 길이 (기존길이*2 + m + (o*(k+2))
        }

        // 역으로 추적하여 n번째 문자 찾기
        while (k>0){
            int prev = (length-(k+3))/2;    //이전 단계의 길이
            // 이전 단계의 문자열에 속하는 경우
            if (n <= prev){
                length = prev;
            // 마지막 이전 단계의 문자열에 속하는 경우
            } else if (n > prev+(k+3)) {
                n -= prev + (k+3);
                length = prev;
            // 중간 추가 부분에 속하는 경우
            } else {
                if (n == prev+1)return 'm';
                else return 'o';

            }
            k --;
        }
        // 초기 "moo"에서의 위치 결정
        if (n==1) return 'm';
        else return 'o';
    }
}