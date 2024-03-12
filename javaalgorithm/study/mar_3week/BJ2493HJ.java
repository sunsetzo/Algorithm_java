package study.mar_3week;

import java.io.*;
import java.util.*;

public class BJ2493HJ {
    static int n;
    // idx : 탑의 위치, height : 탑의 높이
    static class Node{
        int idx;
        int height;
        Node(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            int h = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()){
                sb.append(0+" ");
                stack.add(new Node(i, h));
            }else{
                while (true){
                    // 스택이 다 비면, 입력받은 탑의 높이보다 높은 탑이 없다는 뜻이므로
                    // 정답에 0을 입력 && stack에 현재 탑의 높이와 위치 추가
                    if (stack.isEmpty()){
                        sb.append(0+" ");
                        stack.push(new Node(i, h));
                        break;
                    }
                    // 스택 최상단 값을 가져옴 (pop 시키면 안됨)
                    Node node = stack.peek();
                    if (h<node.height){
                        sb.append(node.idx+" ");
                        stack.push(new Node(i, h));
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}