package study.june_1week;

import java.io.*;

public class BJ17609HJ {
    static int t;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++){
            String input = br.readLine();
            System.out.println(palindrome(0, input.length()-1, input, 0));
        }
    }
    static int palindrome(int start, int end, String s, int chk){
        // 확인횟수가 2이상이면 회문이 아니므로 바로 2를 retrun
        if (chk>=2) return 2;

        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                // 왼쪽 문자를 지웠을때랑, 오른쪽 문자를 지웠을 때를 비교해서 더 작은 경우를 Return
                return Math.min(palindrome(start+1, end, s, chk+1), palindrome(start, end-1, s, chk+1));
            }
        }
        return chk;
    }
}
