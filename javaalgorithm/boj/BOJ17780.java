package boj;

import java.io.*;
import java.util.*;

public class BOJ17780 {
    static int n, k, turn;
    static int[][] arr;
    static int[] change = {1, 0, 3, 2};
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static LinkedList<Integer>[][] chess;
    static Horse[] horse;

    static class Horse {
        int row, col, dir;

        Horse(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        chess = new LinkedList[n][n];

        // 체스판의 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                chess[i][j] = new LinkedList<>();
            }
        }

        horse = new Horse[k + 1];
        // 말의 정보 입력
        for (int info = 1; info <= k; info++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            horse[info] = new Horse(row, col, dir);
            chess[row][col].add(info);
        }

        System.out.println(game());
    }

    public static int game() {
        boolean flag = true;
        while (flag) {
            turn++;
            if (turn > 1000)
                break;

            for (int i = 1; i <= k; i++) {
                Horse h = horse[i];
                int row = h.row;
                int col = h.col;

                if (chess[row][col].get(0) != i)
                    continue;

                int nr = row + dr[h.dir];
                int nc = col + dc[h.dir];

                if (!isRange(nr, nc) || arr[nr][nc] == 2) {
                    h.dir = change[h.dir];
                    nr = row + dr[h.dir];
                    nc = col + dc[h.dir];
                }

                if (!isRange(nr, nc) || arr[nr][nc] == 2) {
                    continue;
                } else if (arr[nr][nc] == 1) {
                    for (int j = chess[row][col].size() - 1; j >= 0; j--) {
                        int tmp = chess[row][col].get(j);
                        chess[nr][nc].add(tmp);
                        horse[tmp].row = nr;
                        horse[tmp].col = nc;
                    }
                    chess[row][col].clear();
                } else {
                    for (int j = 0; j < chess[row][col].size(); j++) {
                        int tmp = chess[row][col].get(j);
                        chess[nr][nc].add(tmp);
                        horse[tmp].row = nr;
                        horse[tmp].col = nc;
                    }
                    chess[row][col].clear();
                }

                if (chess[nr][nc].size() >= 4) {
                    flag = false;
                    break;
                }
            }
        }
        return flag ? -1 : turn;
    }

    static boolean isRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}

