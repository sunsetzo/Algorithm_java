package study.feb_2week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3020HJ {
    static int n, h, cnt;
    static int[] down, up;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // down : 석순, up: 종유석 각각 입력받음
        down = new int[n/2];
        up = new int[n/2];

        for (int i=0; i<n/2; i++){
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int min = n;
        for (int i=1; i<h+1; i++){
            // 부서지는 장애물의 수
            int temp = binarySearch(0, n/2, i, down) + binarySearch(0, n/2, h-i+1, up);

            if (min == temp){
                cnt ++;
                continue;
            }
            // 부서지는 장애물 최소 수 갱신
            if (min > temp){
                min = temp;
                cnt = 1;
            }
        }
        System.out.println(min + " " + cnt);
    }
    public static int binarySearch(int start, int end, int h, int[] arr){
        // h보다 높은 장애물의 수를 찾아서 전체에서 빼줌
        while (start<end){
            int mid = (start+end)/2;

            if (arr[mid]>=h){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return arr.length - end;
    }
}
