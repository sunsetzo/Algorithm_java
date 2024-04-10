package study.apr_2week;

import java.io.*;
import java.util.*;

public class BJ14719HJ {
    static int h, w, rain, wall_max, idx, wall, wall2, sum;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<w; i++){
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            sum += input;   // 블럭 높이 모두 더해 놓음
        }

        // 가장 높은 블록 & idx 찾기
        for (int i=0; i<w; i++){
            if (arr[i] > wall_max){
                wall_max = arr[i];
                idx = i;
            }
        }

        // 블럭 최대 높이의 합을 구한 후, 본 배열의 합을 빼주면 고여 있는 빗물의 양이 됨.
        for (int i=0; i<idx+1; i++){
            if (arr[i] > wall){
                wall = arr[i];
            }
            rain += wall;
        }

        for (int i=w-1; i>idx; i--){
            if (arr[i] > wall2){
                wall2 = arr[i];
            }
            rain += wall2;
        }

        System.out.println(rain - sum);
    }
}
