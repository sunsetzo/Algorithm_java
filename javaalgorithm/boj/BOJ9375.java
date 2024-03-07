package boj;

import java.io.*;
import java.util.*;

public class BOJ9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> info = new HashMap<>();
            for (int i=0; i<n; i++){
                String[] input = br.readLine().split(" ");
                info.put(input[1], info.getOrDefault(input[1], 0)+1);
            }

            int res = 1;
            for (int val : info.values()){
                res *= val+1;
            }
            System.out.println(res -1);
        }
    }
}
