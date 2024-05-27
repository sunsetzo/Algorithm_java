package study.may_3week;

import java.io.*;
import java.util.*;

public class BJ5464HJ {
    static int n, m, ans;
    static int[] fees, weight, current;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fees = new int[n+1];    // 요금 정보
        weight = new int[m+1];  // 차량 무게 정보
        for (int i=1; i<=n; i++){
            int rs = Integer.parseInt(br.readLine());
            fees[i] = rs;
        }
        for (int i=1; i<=m; i++){
            int wk = Integer.parseInt(br.readLine());
            weight[i] = wk;
        }

        current = new int[n+1]; // 현재 차량이 어디에 주차되어 있는지
        Queue<Integer> q = new LinkedList<>();  // 주차 대기열

        outer: for (int i=0; i<2*m; i++){
            int car = Integer.parseInt(br.readLine());

            // 입차
            if (car>0){
                for (int j=1; j<n+1; j++){
                    if (current[j] == 0){
                        current[j] = car;
                        continue outer;
                    }
                }
                q.offer(car);   // 주차자리가 없으면 큐에 넣음
            }
            // 출차
            else{
                car = (-1)*car;
                for (int j=1; j<n+1; j++){
                    if (current[j] == car){ // 차가 주차되어있다면
                        current[j] = 0; // 출차시키고
                        ans += fees[j]*weight[car]; // 요금 더해주기
                        if (!q.isEmpty()) current[j] = q.poll();    // 대기 차량이 있는가?
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}