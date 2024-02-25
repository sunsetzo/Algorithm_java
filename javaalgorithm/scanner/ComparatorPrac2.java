package scanner;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorPrac2 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{5,40},{3,50},{1,30},{4,20},{2,10},{6,40},{6,50},{6,10},{6,20},{6,30}};

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                return o1[0]!= o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];   //첫번째 기준 오름차순 > 두번째 기준 오름차순
//                return o1[0]!= o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];   //첫번째 기준 오름차순 > 두번째 기준 내림차순
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0]-o2[0];    // 두번째 기준 오름차순 > 첫번째 기준 오름차순
//                return o1[1]!=o2[1] ? o1[1]-o2[1] : o2[0] - o1[0];      // 두번째 기준 오름차순 > 첫번째 기준 내림차순
            }
        });
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
