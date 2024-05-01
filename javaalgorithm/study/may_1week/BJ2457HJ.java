package study.may_1week;

import java.io.*;
import java.util.*;

public class BJ2457HJ {
    static int n, cnt;
    static class Node implements Comparable<Node>{
        int start; int end;
        Node(int start, int end){
            this.start = start; this.end = end;
        }

        @Override
        // 시작날짜 오름차순, 종료날짜 내림차순
        public int compareTo(Node node){
            if (this.start == node.start) {
                return node.end - this.end;
            }
            return this.start-node.start;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Node[] info = new Node[n];
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            info[i] = (new Node(sm*100+ sd, em*100+ ed));   // 날짜를 숫자로 만들어줌
        }
        Arrays.sort(info);
        int max = 0; int now = 301;
        int idx = 0;
        while (now < 1201){
            boolean chk = false;
            for (int i=idx; i<info.length; i++){
                if (info[i].start > now) break;
                if (max < info[i].end){ // 종료일이 더 뒷날인 것을 찾는 과정
                    chk = true;
                    idx ++;
                    max = info[i].end;
                }
            }
            if (chk){
                now = max;
                cnt ++;
            }else break;    // 안해주면 시간초과
        }
        System.out.println(now<1201? 0:cnt);
    }
}
