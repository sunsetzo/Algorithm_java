package study.feb_4week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    char value;
    Node left;
    Node right;

    public Node(char value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class BJ1991HJ {
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new Node[n+1];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            // Java에서 char 데이터 타입은 내부적으로 ASCII 코드를 사용
            if (tree[p-'A'] == null){
                tree[p-'A'] = new Node(p);
            }
            if (l != '.'){
                tree[l-'A'] = new Node(l);
                tree[p-'A'].left = tree[l-'A'];
            }
            if (r != '.'){
                tree[r-'A'] = new Node(r);
                tree[p-'A'].right = tree[r-'A'];
            }
        }

        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
        System.out.println();
    }
    public static void preOrder(Node node){
        if (node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node){
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}
