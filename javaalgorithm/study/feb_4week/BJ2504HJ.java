package study.feb_4week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ2504HJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int res = 0;
        int value = 1;  // 값을 저장할 임시 변수

        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            // 열린 괄호는 stack에 넣어줌
            if (c == '('){
                stack.push(c);
                value *= 2;
            } else if (c == '[') {
                stack.push(c);
                value *= 3;

            // 닫힌 괄호를 만났을 때
            } else if (c == ')') {
                // 스택이 비어있거나, 스택 최상단의 괄호와 다르면 올바른 괄호열이 아니기 때문에 res 0으로 초기화
                if (stack.isEmpty() || stack.peek() != '('){
                    res = 0;
                    break;

                // 올바른 괄호열일 경우 결괏값에 value를 더해줌
                } else if (input.charAt(i-1) == '(') {
                    res += value;
                }
                stack.pop();
                value /= 2;
            } else if (c == ']'){
                if (stack.isEmpty() || stack.peek() != '['){
                    res = 0;
                    break;
                } else if (input.charAt(i-1) == '['){
                    res += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if (!stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(res);
        }
    }
}
