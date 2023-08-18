import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int K = sc.nextInt();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt(); // 입력받음
                }
            }
            int cnt = 0;
            // row 방향 탐색
            for (int i = 0; i < N; i++) {
                int check = 0;
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 0) check = 0;
                    check += arr[i][j];
                    if (j == N - 1) {
                        if (check == K) cnt++;
                    } else {
                        if (check == K && arr[i][j + 1] != 1) {
                        cnt++;
                        check = 0;
                        }
                    }
                }
            }
            // col 방향 탐색
            for (int j = 0; j < N; j++) {
                int check = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i][j] == 0) check = 0;
                    check += arr[i][j];
                    if (i == N - 1) {
                        if (check == K) cnt++;
                    } else {
                        if (check == K && arr[i + 1][j] != 1) {
                        cnt++;
                        check = 0;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}