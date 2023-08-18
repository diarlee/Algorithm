import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        int[][] arr = new int[9][9];
        for (int test_case = 1; test_case <= T; test_case++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int check = 1;
            for (int i = 0; i < 9; i++) {
                Set<Integer> row = new HashSet<>();
                Set<Integer> col = new HashSet<>();
                 
                for (int j = 0; j < 9; j++) {
                    row.add(arr[i][j]); // row 탐색
                    col.add(arr[j][i]); // col 탐색
                    if (i % 3 == 0 && j % 3 == 0) { // 작은격자 탐색 // 3 * 3의 젤 왼쪽 위에서 시작
                        Set<Integer> part = new HashSet<>();
                        int[] dr = {0, 0, 0, 1, 1, 1, 2, 2, 2};
                        int[] dc = {0, 1, 2, 0, 1, 2, 0, 1, 2};
                        for (int k = 0; k < 9; k++) { 
                            part.add(arr[i + dr[k]][j + dc[k]]);
                        }
                        if (part.size() != 9) {
                            check = 0;
                        }
                    }
                }
                if (row.size() != 9 || col.size() != 9) {
                    check = 0;
                }
            }
            System.out.println("#" + test_case + " " + check);
        }
    }
}