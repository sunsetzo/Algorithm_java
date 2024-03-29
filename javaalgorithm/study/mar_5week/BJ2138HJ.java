package study.mar_5week;

import java.io.*;
import java.util.*;

// 누르는 순서를 신경쓸 필요 없이 0번 스위치부터 N-1번 스위치까지
// 순차적으로 돌면서 해당 스위치를 눌러도 될지 말지만 결정하면 됨

// 0번째 스위치를 누른 경우와 누르지 않은 경우로 나눠서 그리디탐색

public class BJ2138HJ {
    static int n;
    static int[] current, goal, another;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String input1 = br.readLine();
        String input2 = br.readLine();
        current = new int[n]; goal = new int[n];
        for (int i=0; i<n; i++){
            current[i] = input1.charAt(i)-'0';
            goal[i] = input2.charAt(i)-'0';
        }

        // 배열을 복사하여 0번째 스위치를 누른상태로 변경
        another = Arrays.copyOf(current, n);
        another[0] = 1-another[0];
        another[1] = 1-another[1];

        int res1 = switches(current, goal);
        int res2 = switches(another, goal);

        // 0번 스위치를 누르고 시작한것이기 때문에 +1
        if (res2 != -1) res2++;

        if (res1 == -1){
            System.out.println(res2);
        }else if(res2 == -1){
            System.out.println(res1);
        }else{
            System.out.println(Math.min(res1, res2));
        }

    }
    static int switches(int[] now, int[] next){
        int cnt = 0;
        for (int i=0; i<n-1; i++){
            if (now[i] != next[i]){
                cnt ++;
                now[i] = 1-now[i];
                now[i+1] = 1-now[i+1];
                if (i != n-2){
                    now[i+2] = 1-now[i+2];
                }
            }
        }
        return now[n-1]!=next[n-1] ? -1 : cnt;
    }
}