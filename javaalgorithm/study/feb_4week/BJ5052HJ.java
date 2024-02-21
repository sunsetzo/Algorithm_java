package study.feb_4week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BJ5052HJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            // 문자열로 입력받아야 함
            // [1, 11, 1156, 2, 25] 순으로 정렬됨
            // 숫자로 입력받으면 [1, 2, 11, 25, 1156]으로 정렬
            String[] nums = new String[n];
            for (int i=0; i<n; i++){
                nums[i] = br.readLine();
            }
            Arrays.sort(nums);

            boolean isPossible = true;
            for (int j=1; j<n; j++){
                // 후자의 숫자가 전자의 숫자로 시작하는지 확인
                if (nums[j].startsWith(nums[j-1])){
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
