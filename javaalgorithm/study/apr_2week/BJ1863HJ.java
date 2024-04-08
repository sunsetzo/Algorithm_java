package study.apr_2week;

import java.io.*;
import java.util.*;

public class BJ1863HJ {
    static int n, ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Stack<Integer> arr = new Stack<>();
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            if (!arr.isEmpty()){
                if (arr.get(arr.size() - 1) < high){
                    arr.push(high);
                } else if (arr.get(arr.size()-1) > high) {
                    while (!arr.isEmpty() && arr.get(arr.size()-1)>high){
                        arr.pop();
                        ans ++;
                    }
                    if (arr.isEmpty()){
                        if (high>0){
                            arr.push(high);
                        }
                    }else {
                        if (arr.get(arr.size()-1) < high){
                            arr.push(high);
                        }
                    }
                }
            }else {
                if (high>0){
                    arr.push(high);
                }
            }
        }
        System.out.println(ans + arr.size());
    }
}
