package study.may_5week;

import java.io.*;
import java.util.*;

// 투포인터+이분탐색
// 자료형 주의
public class BJ2473HJ {
    static int n;
    static long[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n];
        for (int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long start = 0; long s = 0; long e = 0;
        long mix = Long.MAX_VALUE;

        for (int i=0; i<n-2; i++){
            int x = i+1; int y = n-1;
            while (x<y){
                long sum = arr[i]+arr[x]+arr[y];
                if (Math.abs(sum) < mix){
                    mix = Math.abs(sum);
                    s = arr[x]; e = arr[y];
                    start = arr[i];
                }
                if (sum == 0){break;}
                else if (sum>0) {
                    y--;
                }else{
                    x++;
                }
            }
        }
        ArrayList<Long> ans = new ArrayList<>();
        ans.add(start); ans.add(s); ans.add(e);
        Collections.sort(ans);
        for (int i=0; i<3; i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}