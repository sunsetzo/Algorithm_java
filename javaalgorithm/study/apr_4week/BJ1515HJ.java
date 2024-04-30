package study.apr_4week;

import java.io.*;

public class BJ1515HJ {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();   // 숫자의 연속에서 찾고자 하는 특정 숫자열 입력

        int p = 0;  // 입력된 문자열 `n`을 찾기 위해 사용하는 인덱스 포인터
        int num = 0; // 현재 확인하고 있는 숫자
        while (num++ <= 30000){    // 1부터 30000까지의 숫자를 확인합니다 (최대 3000자리를 고려하여 설정)
            String temp = String.valueOf(num); // 현재 숫자를 문자열로 변환
            for (int i=0; i<temp.length(); i++){ // 변환된 문자열의 각 자리수를 순회
                // 현재 숫자의 i번째 자리와 입력받은 문자열 n의 p번째 자리가 같으면, p를 증가시켜 다음 문자로 넘어감
                if (temp.charAt(i) == n.charAt(p)) p++;
                // n의 모든 문자를 순회했다면, 현재 숫자를 출력하고 프로그램 종료
                if (p == n.length()){
                    System.out.println(num);
                    System.exit(0);
                }
            }
        }
    }
}