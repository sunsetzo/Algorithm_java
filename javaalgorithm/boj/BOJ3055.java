package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ3055 {
    static int r, c;
    static char[][] forest;
    static int[][] water, move;
    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};
    static Queue<int[]> w, m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        r = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

        forest = new char[r][c];
        water = new int[r][c];
        move = new int[r][c];
        w = new ArrayDeque<>();
        m = new ArrayDeque<>();



    }
}
