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
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input <= 0) negative++;
            else positive++;
            one += input;
            arr[i] = input;
        }
        Arrays.sort(arr);

        if (n == 1) {
            System.out.println(one);
        } else {
            if (negative % 2 == 0) {
                for (int i = 0; i < negative; i += 2) {
                    sum += (arr[i] * arr[i + 1]);
                }
            } else {
                for (int i = 0; i < negative - 1; i += 2) {
                    sum += (arr[i] * arr[i + 1]);
                }
                sum += arr[negative - 1];
            }
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