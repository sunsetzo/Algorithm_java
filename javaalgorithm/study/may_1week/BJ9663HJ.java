package study.may_1week;

import java.io.*;

// 첫번째 열부터 한개씩 채워나가면서 놓을 수 있는 위치일 때 재귀호출로 계속 채워나감

public class BJ9663HJ {
    static int n, cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];   // 각 원소의 index를 '열'이라 생각하고, 원소 값을 '행'으로 봄
        queen(0);
        System.out.println(cnt);
    }
    static void queen(int d){
        // 모든 원소를 다 채웠을 경우 cnt++
        if (d == n){
            cnt ++;
            return;
        }
        for (int i=0; i<n; i++){
            arr[d] = i;
            if (isPossible(d)){
                // 놓을 수 있는 위치일 경우 다음 열 재귀호출
                queen(d+1);
            }
        }
    }
    static boolean isPossible(int col){
        for (int i=0; i<col; i++){
            // 해당 열의 행과 i열의 행이 일치 할 경우 (같은 행에 존재할 경우)
            if (arr[col] == arr[i]){
                return false;
            // 대각선에 놓여있는 경우 (열의 차와 행의 차가 같을 경우 = 대각선에 놓여있는 경우)
            } else if (Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
                return false;
            }
        }
        return true;
    }
}
