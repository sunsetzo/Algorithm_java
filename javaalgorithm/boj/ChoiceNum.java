import java.util.*;

public class ChoiceNum {

    private static int[] lst;
    private static boolean[] visit;
    private static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        lst = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            lst[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            visit[i] = true;
            dfs(lst[i]);
        }

        Collections.sort(ans);

        System.out.println(ans.size());
        for (int num : ans) {
            System.out.println(num);
        }
    }

    private static void dfs(int x) {
        Stack<Integer> stack = new Stack<>();
        stack.push(x);

        while (!stack.isEmpty()) {
            int q = stack.pop();

            if (!visit[lst[q]]) {
                stack.push(lst[q]);
                visit[q] = true;
            } else {
                if (!ans.contains(q)) {
                    ans.add(q);
                }
            }
        }
    }
}
