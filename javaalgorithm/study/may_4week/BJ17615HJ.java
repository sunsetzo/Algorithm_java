package study.may_4week;

import java.io.*;

// 총 4가지의 경우 (1. R을 모두 왼쪽/ 오른쪽 // 2. B를 모두 왼쪽/오른쪽)
/// 이동해야하는 공의 갯수 = 공의 갯수 - 연속해서 있는 Cnt

public class BJ17615HJ {
    static int n;
    static String info;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = br.readLine();

        int res = n;
        int red = 0; int blue = 0;
        for (int i=0; i<n; i++){
            if (info.charAt(i) == 'R'){
                red++;
            }else{
                blue++;
            }
        }
        int cnt = 0;
        for (int i=0; i<n; i++){
            if (info.charAt(i)=='R'){
                cnt++;
            }else{
                break;
            }
        }
        res = Math.min(res, red-cnt);

        cnt = 0;
        for (int i=n-1; i>=0; i--){
            if (info.charAt(i)=='R'){
                cnt++;
            }else{
                break;
            }
        }
        res = Math.min(res, red-cnt);

        cnt = 0;
        for (int i=0; i<n; i++){
            if (info.charAt(i)=='B'){
                cnt++;
            }else{
                break;
            }
        }
        res = Math.min(res, blue-cnt);

        cnt = 0;
        for (int i=n-1; i>=0; i--){
            if (info.charAt(i)=='B'){
                cnt++;
            }else{
                break;
            }
        }
        res = Math.min(res, blue-cnt);

        System.out.println(res);
    }
}
