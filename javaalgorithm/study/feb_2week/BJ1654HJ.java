package study.feb_2week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1654HJ {
    static int k, n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        for (int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch());

    }
    //탐색 범위를 의미하는 변수들은 long으로 선언해야 합니다.
    //그렇지 않으면 1 + (2^31-1) 에서 오버플로가 발생하기 때문입니다
    public static long binarySearch(){
        long start = 1;
        long end = arr[arr.length-1];
        long mid, cnt;

        while (start<=end){
            mid = (start+end)/2;
            cnt = 0;

            for (int i=0; i<k; i++){
                cnt += arr[i]/mid;
            }

            if (cnt >= n){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return end;
    }
}
