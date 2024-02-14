package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    static int n, m;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        trees = new int[n];
        int start = 0;
        int end = -1;
        for (int i=0; i<n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, trees[i]);
        }

        while (start<=end){
            int mid = (start+end)/2;
            long h = 0;
            for (int tree : trees) {
                if (tree>mid){
                    h += (tree-mid);
                }
            }
            if (h>=m){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }
        System.out.println(end);
    }
}
