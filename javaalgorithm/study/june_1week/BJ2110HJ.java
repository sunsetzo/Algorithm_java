package study.june_1week;

import java.io.*;
import java.util.*;

public class BJ2110HJ {
    static int n, c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        for (int i=0; i<n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);

        long start = 1;
        long end = arr.get(n-1)-arr.get(0);
        long res = 0;
        while (start<=end){
            long mid = (start+end)/2;
            int cnt = 1;
            int cur = arr.get(0);

            for (int i=1; i<n; i++){
                if (arr.get(i) >= cur+mid){
                    cnt++;
                    cur = arr.get(i);
                }
            }
            if (cnt >= c){
                start = mid+1;
                res = mid;
            }else{
                end = mid-1;
            }
        }
        System.out.println(res);
    }
}