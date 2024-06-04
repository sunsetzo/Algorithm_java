package study.june_1week;

import java.io.*;
import java.util.*;

public class BJ1406HJ {
    static String[] input;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split("");
        m = Integer.parseInt(br.readLine());
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (String s : input){
            left.add(s);
        }

        for (int i=0; i<m; i++){
            String[] orders = br.readLine().split(" ");
            String order = orders[0];

            switch(order){
                case "L" :
                    if (!left.isEmpty()){
                        right.add(left.pop());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()){
                        left.add(right.pop());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()){
                        left.pop();
                    }
                    break;
                case "P":
                    String c = orders[1];
                    left.add(c);
                    break;
            }
        }
        while (!left.isEmpty()) right.push(left.pop());

        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) sb.append(right.pop());

        System.out.println(sb);

    }
}
