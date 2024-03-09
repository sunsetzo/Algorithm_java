package boj;

import java.io.*;
import java.util.*;

public class BOJ1927 {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if (x > 0) {
                q.add(x);
            } else if (x ==0) {
                if (q.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(q.poll());
                }
            }
        }
    }
}
