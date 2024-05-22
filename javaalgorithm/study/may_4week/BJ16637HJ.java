package study.may_4week;

import java.io.*;

public class BJ16637HJ {
    static int n;
    static String info;
    static int res = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = br.readLine();

        func(Integer.parseInt(String.valueOf(info.charAt(0))), 0);
        System.out.println(res);
    }
    static int calculation(String element, int x, int y){
        if (element.equals("+")){
            return x+y;
        } else if (element.equals("-")){
            return x-y;
        } else if (element.equals("*")){
            return x*y;
        }
        return 0;
    }
    static void func(int value, int idx){
        if (idx == n-1){
            // 끝까지 계산되면 최댓값 갱신
            res = Math.max(res, value);
            return;
        }
        // 사칙연산을 기준으로 값을 계산한 후, 재귀 (현재 위치에서 계산한값 vs 그 뒤에 오는 숫자를 먼저 계산한값 비교)
        if (idx+2 < n){
            int temp = calculation(String.valueOf(info.charAt(idx+1)), value, Integer.parseInt(String.valueOf(info.charAt(idx+2))));
            func(temp, idx+2);
        }
        if (idx+4 < n){
            int tmp = calculation(String.valueOf(info.charAt(idx+3)), Integer.parseInt(String.valueOf(info.charAt(idx+2))), Integer.parseInt(String.valueOf(info.charAt(idx+4))));
            func(calculation(String.valueOf(info.charAt(idx+1)), value, tmp), idx+4);
        }
    }
}
