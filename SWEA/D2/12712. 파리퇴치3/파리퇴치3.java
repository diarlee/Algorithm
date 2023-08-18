import java.io.File;
import java.util.Scanner;
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
            int M = sc.nextInt();
            int[][] arr = new int[N + 2 * M - 2][N + 2 * M - 2]; // index 벗어날 경우 대비하여 입력보다 더 큰  배열 생성
            for (int i = M - 1; i < N + M - 1; i++) {
                for (int j = M - 1; j < N + M - 1; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = M - 1; i < N + M - 1; i++) {
                for (int j = M - 1; j < N + M - 1; j++) {
                    int rowSum = 0; 
                    int colSum = 0;
                    int leftSum = 0;
                    int rightSum = 0;
                    for (int k = -M + 1; k < M; k++) { // arr[i][j] 위치에서 가로 세로 대각선 탐색
                        rowSum += arr[i][j+k];
                        colSum += arr[i+k][j];
                        leftSum += arr[i+k][j+k];
                        rightSum += arr[i-k][j+k];
                    }
                    int plusSum = rowSum + colSum - arr[i][j];
                    if (plusSum > max) max = plusSum;
                    int multiSum = leftSum + rightSum - arr[i][j];
                    if (multiSum > max) max = multiSum;
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}