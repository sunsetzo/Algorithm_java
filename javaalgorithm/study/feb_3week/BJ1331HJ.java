package study.feb_3week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1331HJ {
    static int nowX, nowY, prevX, prevY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> visit = new ArrayList<String>(); // 방문 위치 저장 배열
        String st = br.readLine();
        visit.add(st);

        // 첫번째 위치 저장
        int startX = st.charAt(0);
        int startY = st.charAt(1);
        prevX = startX;
        prevY = startY;

        for (int i=0; i<35; i++){
            String night = br.readLine();
            nowX = night.charAt(0);
            nowY = night.charAt(1);

            // 방문한 적 있는지 확인
            if (visit.contains(night)){
                System.out.println("Invalid");
                return;
            }

            // 나이트가 이동할 수 있는 위치인지 확인
            if (Math.abs(nowX - prevX) == 2 && Math.abs(nowY - prevY) == 1 || Math.abs(nowX - prevX) == 1 && Math.abs(nowY - prevY) == 2){
            } else {
                System.out.println("Invalid");
                return;
            }

            visit.add(night);
            // 현재위치 갱신
            prevX = nowX;
            prevY = nowY;
        }

        // 마지막 위치에서 처음 위치로 갈 수 있는지 확인
        if (Math.abs(nowX - startX) == 2 && Math.abs(nowY - startY) == 1 || Math.abs(nowX - startX) == 1 && Math.abs(nowY - startY) == 2){
        } else {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");

    }
}
