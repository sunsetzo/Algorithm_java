package study.feb_4week;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1946HJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] info = new int[n][2];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());

                info[i] = new int[]{s1, s2};

            }
            // 서류심사 기준 오름차순 정렬
            Arrays.sort(info, (o1, o2) -> {
                return o1[0]-o2[0];
            });

            // 서류 심사 1등 기준으로 선발
            int grade = info[0][1];
            int res = 1;

            for (int i=1; i<n; i++){
                // 면접성적이 기준보다 낮으면 선발
                if (grade > info[i][1]){
                    res += 1;
                    grade = info[i][1];
                }
            }

            System.out.println(res);
        }
    }
}
