package study.mar_4week;

import java.io.*;
import java.util.*;

public class BJ1744HJ {
    static int n, negative, positive, one, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        // 입력받으면서 양수와 음수의 갯수를 체크
        // 모두 다 더했을 경우를 계산
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input <= 0) negative++;
            else positive++;
            one += input;
            arr[i] = input;
        }
        // 정렬
        Arrays.sort(arr);

        // n 이 1일 경우 따로 체크
        if (n == 1) {
            System.out.println(one);
        } else {
            // 음수의 갯수가 짝수인 경우 두개씩 곱해준 후 더한 값이 최대
            if (negative % 2 == 0) {
                for (int i = 0; i < negative; i += 2) {
                    sum += (arr[i] * arr[i + 1]);
                }
            // 홀수인 경우, 음의 절댓값이 큰 것 끼리 곱해준 후 더해줘야 최대
            } else {
                for (int i = 0; i < negative - 1; i += 2) {
                    sum += (arr[i] * arr[i + 1]);
                }
                sum += arr[negative - 1];
            }
            // 양수의 갯수가 짝수인 경우도 마찬가지이나,
            // 1인 경우는 더해주는 것이 값이 더 크기 때문에 조건을 한번 더 분기
            if (positive % 2 == 0) {
                for (int i = n - 1; i > negative; i -= 2) {
                    if (arr[i] == 1 || arr[i - 1] == 1) {
                        sum += arr[i] + arr[i - 1];
                    } else {
                        sum += (arr[i] * arr[i - 1]);
                    }
                }
            } else {
                for (int i = n - 1; i > negative + 1; i -= 2) {
                    if (arr[i] == 1 || arr[i - 1] == 1) {
                        sum += arr[i] + arr[i - 1];
                    } else {
                        sum += (arr[i] * arr[i - 1]);
                    }
                }
                sum += arr[negative];
            }
            System.out.println(Math.max(one, sum));
        }

    }
}