package study.apr_3week;

import java.io.*;
import java.util.*;

public class BJ11279HJ {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if (x == 0){
                sb.append(pq.size()==0 ? 0 : pq.poll()).append("\n");
            }else{
                pq.add(x);
            }
        }
        System.out.println(sb.toString());
    }
}
