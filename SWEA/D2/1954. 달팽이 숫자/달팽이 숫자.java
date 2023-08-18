import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int num = 0;
            for (int j = 0; j < N; j++) arr[0][j] = ++num; // 첫 줄
            // 하좌상우
            int[] dr = {1, 0, -1, 0};
            int[] dc = {0, -1, 0, 1};
             
            int i = 0, j = N - 1; // 처음 방향 전환 지점
            int dCount = 0; // 방향 전환 횟수
            int dLen = N - 1; // 방향 전환 후 길이
            while (num < N * N) {
                int d1 = dCount++ % 4; // 방향 전환 방향1
                for (int l = 0; l < dLen; l++) {
                    i += dr[d1];
                    j += dc[d1];
                    arr[i][j] = ++num;
                }
                int d2 = dCount++ % 4; // 방향 전환 방향2
                for (int l = 0; l < dLen; l++) {
                    i += dr[d2];
                    j += dc[d2];
                    arr[i][j] = ++num;
                }
                dLen--; // 방향 전환 2번 수행 후 길이 -1
            }
            System.out.printf("#%d\n",test_case);
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    System.out.print(arr[r][c] + " ");
                }
                System.out.println();
            }
        }
    }
}