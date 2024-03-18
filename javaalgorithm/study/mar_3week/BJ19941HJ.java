package study.mar_3week;

import java.io.*;
import java.util.*;

public class BJ19941HJ {
    static int n, k, ans;
    static String[] input;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        input = br.readLine().split("");
        for (int i=0; i<n; i++){
            // 사람일 때
            if (input[i].equals("P")){
                // 사람기준 K만큼 떨어진 거리
                for (int j=i-k; j<=i+k; j++){
                    // 범위를 벗어나면 pass
                    if (j<0 || j>=n) continue;
                    if (input[j].equals("H")){
                        // 중복 체크되는 것을 막기 위해 다른 문자열로 바꿔줌
                        input[j] = "A";
                        ans ++;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
