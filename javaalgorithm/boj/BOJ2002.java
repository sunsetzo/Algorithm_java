package boj;

import java.io.*;
import java.util.*;

public class BOJ2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> before = new HashMap<>();
        int[] after = new int[n];

        for (int i=0; i<n; i++){
            before.put(br.readLine(), i);
        }

        for (int i=0; i<n; i++){
            after[i] = before.get(br.readLine());
        }

        int ans = 0;
        for (int i=0; i<n-1; i++){
            for (int j=i; j<n; j++){
                if (after[i] > after[j]){
                    ans++;
                    break;
                }
            }
        }
        System.out.print(ans);
    }
}
