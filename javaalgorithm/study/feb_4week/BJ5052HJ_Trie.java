package study.feb_4week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class BJ5052HJ_Trie {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            Trie trie = new Trie();
            boolean flag = true;

            int n = Integer.parseInt(br.readLine());
            for (int i=0; i<n; i++){
                // 일관성 있는 문자열은 true, 아니면 false 반환
                if (!trie.insert(br.readLine())){
                    flag = false;
                }
            }
            if (flag){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
    }
    static class TrieNode{
        // 자식노드
        Map<Character, TrieNode> childNodes = new HashMap<>();
        // 단어의 끝인지 아닌지 체크
        boolean isLast;
    }
    static class Trie{
        //Trie 자료구조 생성 시, rootNode는 기본적으로 생성
        TrieNode root = new TrieNode();

        // 문자열 저장
        boolean insert(String num) {
            TrieNode thisNode = root;
            for (int i=0; i<num.length(); i++){
                char c = num.charAt(i);

                // 문자열의 각 단어를 자식노드마다 체크
                // 없으면 자식노드 생성
                if (thisNode.childNodes.get(c) == null){
                    thisNode.childNodes.put(c, new TrieNode());
                }

                // 새로 만들었거나, 존재하는 자식노드로 이동
                thisNode = thisNode.childNodes.get(c);

                // 동일했던 문자열이 끝나버리면 일관성이 없다는 뜻이므로 false 반환
                if (thisNode.isLast){
                    return false;
                }
            }
            // 입력받은 문자열 전체 노드를 타고 내려왔는데, 자식노드가 존재하면 일관성 X
            if (!thisNode.childNodes.isEmpty()){
                return false;
            }
            // 그 외의 경우 일관성이 깨지지 않았으므로 마지막 자식 노드에 true 넣은 후 반환
            thisNode.isLast = true;
            return true;
        }
    }
}
