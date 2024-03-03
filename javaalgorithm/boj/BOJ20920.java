package boj;

import java.util.*;
import java.io.*;

public class BOJ20920 {
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<String, Integer> dict = new HashMap<>();

        for (int i=0; i<n; i++){
            String word = br.readLine();
            if (word.length() >= m){
                dict.put(word, dict.getOrDefault(word, 0)+1);
            }
        }
        List<String> words = new ArrayList<>(dict.keySet());

        Collections.sort(words, new Comparator<String>() {
            @Override
            // 단어들을 정렬하는데, 등장 횟수가 큰 순서대로 정렬하되,
            // 등장 횟수가 같으면 단어의 길이가 긴 순서로 정렬하고,
            // 길이가 같으면 사전 순으로 정렬함
            public int compare(String o1, String o2) {
                if (Integer.compare(dict.get(o1), dict.get(o2)) != 0){
                    return Integer.compare(dict.get(o2), dict.get(o1));
                }
                if (o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word + "\n");
        }
        System.out.println(sb);
    }
}
