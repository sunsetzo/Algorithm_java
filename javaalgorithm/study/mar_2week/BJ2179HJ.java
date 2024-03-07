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

                int res = check(str1, str2);

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
