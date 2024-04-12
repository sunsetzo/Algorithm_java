package boj;

import java.io.*;
import java.util.*;

public class BOJ13144 {
    static int n;
    static long ans;
    static int[] arr, cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        cnt = new int[100001];
        for (int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1;
        int end = 0;
        // 현재 위치에서 시작하여 조건을 만족할때까지 end를 늘려나감.
        while (start <= n){
            // 처음쓰는 숫자인지 + 범위를 안넘기는지 체크
            while (end+1 <= n && cnt[arr[end+1]]==0){
                end ++;
                cnt[arr[end]]++;    // 해당 숫자를 썼다고 표시
            }
            ans += end-start+1;
            cnt[arr[start]]--;  // start를 한칸 옮기기 때문에 이전위치의 Cnt를 --;
            start++;    // 계산이 끝났기 때문에 한칸 옮겨줌.
        }
        System.out.println(ans);
    }
}