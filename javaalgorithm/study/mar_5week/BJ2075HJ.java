package study.mar_5week;

import java.io.*;
import java.util.*;

public class BJ2075HJ {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                q.add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i=0; i<n-1; i++){
            q.poll();
        }
        System.out.println(q.poll());
    }
}
