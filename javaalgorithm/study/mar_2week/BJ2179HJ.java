package study.mar_2week;

import java.io.*;
import java.util.*;

public class BJ2179HJ {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();
        for (int i=0; i<n; i++){
            String input = br.readLine();
            // 중복 단어 거르기 (출력에서 두 단어는 서로 달라야 하기 때문)
            if (!arr.contains(input)){
                arr.add(input);
            }
        }
        int max = Integer.MIN_VALUE;
        int ans1 = -1;
        int ans2 = -1;
        for (int i=0; i<n-1; i++){
            String str1 = arr.get(i);
            for (int j=i+1; j<n; j++){
                String str2 = arr.get(j);

                // 두 문자열이 비슷한 정도 확인
                int res = check(str1, str2);

                // 접두사의 길이가 최대인 경우가 여러 개일 때는,
                // 입력되는 순서대로 앞쪽에 있는 단어를 답으로 하기때문에, 같은 경우는 제외
                if (res > max){
                    ans1 = i;
                    ans2 = j;
                    max = res;
                }
            }
        }
        System.out.println(arr.get(ans1));
        System.out.println(arr.get(ans2));
    }
    static int check(String x, String y){
        int size = Math.min(x.length(), y.length());
        int cnt = 0;
        for (int i=0; i<size; i++){
            if (x.charAt(i) == y.charAt(i)) cnt++;
            else break;
        }
        return cnt;
    }
}
