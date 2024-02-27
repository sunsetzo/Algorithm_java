package study.mar_1week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1541HJ {
    static String[] info;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최소값을 만들기 위해서는 + 기준으로 괄호를 묶어줘야함.
        // 따라서 "-"로 split해서 배열 저장
        info = br.readLine().split("-");

        for (int i=0; i<info.length; i++){
            int sum = 0;
            String[] cal = info[i].split("\\+");
            for (int j=0; j<cal.length; j++){
                sum += Integer.parseInt(cal[j]);
            }
            // 처음 숫자는 무조건 더해줘야 함
            if (i==0){
                res += sum;
            // "-"를 기준으로 split되었기 때문에 계산된 값은 모두 빼줘야함
            } else {
                res -= sum;
            }
        }
        System.out.println(res);
    }
}
