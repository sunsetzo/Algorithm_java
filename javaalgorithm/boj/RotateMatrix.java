import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < r; k++) {
            for (int i = 0; i < Math.min(n, m) / 2; i++) {
                int x = i;
                int y = i;
                int temp = arr[x][y];

                for (int j = i + 1; j < n - i; j++) {
                    x = j;
                    int prev = arr[x][y];
                    arr[x][y] = temp;
                    temp = prev;
                }

                for (int j = i + 1; j < m - i; j++) {
                    y = j;
                    int prev = arr[x][y];
                    arr[x][y] = temp;
                    temp = prev;
                }

                for (int j = i + 1; j < n - i; j++) {
                    x = n - j - 1;
                    int prev = arr[x][y];
                    arr[x][y] = temp;
                    temp = prev;
                }

                for (int j = i + 1; j < m - i; j++) {
                    y = m - j - 1;
                    int prev = arr[x][y];
                    arr[x][y] = temp;
                    temp = prev;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
