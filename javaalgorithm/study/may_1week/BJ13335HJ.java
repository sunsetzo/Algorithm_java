package study.may_1week;

import java.io.*;
import java.util.*;

public class BJ13335HJ {
    static int n, w, l, time;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        Queue<Integer> arr = new LinkedList<>();    // 트럭 무게
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> q = new LinkedList<>();      // 다리
        // 초기값 세팅 (다리에 트럭이 없는 상태)
        for (int i=0; i<w; i++){
            q.add(0);
        }

        int weight = 0;     // 다리 위에 있는 트럭의 무게
        while (!q.isEmpty()){
            time += 1;
            weight -= q.poll();     // 트럭 하나 지나감

            if (!arr.isEmpty()){
                if (arr.peek()+weight <= l){    // 다리위 트럭 무게 + 다음 트럭의 무게 <= l 일 때,
                    weight+=arr.peek();
                    q.add(arr.poll());
                }else{  // 무게가 초과되면 트럭이 못 지나감
                    q.add(0);
                }
            }
        }
        System.out.println(time);
    }
}