package boj;

import java.util.*;
import java.io.*;

public class BOJ2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        String s = br.readLine();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';

            while(count < size && !stack.isEmpty() && stack.peek() < n) {
                stack.pop();
                count++;
            }
            stack.add(n);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() - size; i++) {
            sb.append(stack.get(i));
        }
        System.out.print(sb);
    }
}
