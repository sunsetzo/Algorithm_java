package study.june_1week;

import java.io.*;
import java.util.*;

public class BJ16235HJ {
    static int n, m, K, x, y, z, ans;
    static int[][] nutrient, nNutrient;
    static List<Integer>[][] soil;
    static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nutrient = new int[n][n];
        nNutrient = new int[n][n];
        soil = new ArrayList[n][n];

        for (int i=0; i<n; i++){
            Arrays.fill(nutrient[i], 5);
            for (int j=0; j<n; j++){
                soil[i][j] = new ArrayList<>();
            }
        }
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                nNutrient[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            z = Integer.parseInt(st.nextToken());
            soil[x][y] .add(z);
        }

        int new_season = 0;
        while (new_season<K){
            // 봄
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    List<Integer> trees = new ArrayList<>();
                    int next_n = 0;
                    Collections.sort(soil[i][j]);
                    for (int k : soil[i][j]){
                        if (nutrient[i][j]>=k){
                            nutrient[i][j] -= k;
                            trees.add(k+1);
                        }else{
                            next_n += (k/2);
                        }
                    }
                    nutrient[i][j] += next_n;
                    soil[i][j] = trees;
                }
            }
            // 가을
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    for (int k=0; k<soil[i][j].size(); k++){
                        if (soil[i][j].get(k)%5 == 0) {
                            for (int w=0; w<8; w++){
                                int ni = i+di[w]; int nj = j+dj[w];
                                if (0<=ni && ni<n && 0<=nj && nj<n){
                                    soil[ni][nj].add(0, 1);
                                }
                            }
                        }
                    }
                }
            }
            // 겨울
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    nutrient[i][j] += nNutrient[i][j];
                }
            }

            new_season++;

        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                ans += soil[i][j].size();
            }
        }
        System.out.println(ans);
    }
}
