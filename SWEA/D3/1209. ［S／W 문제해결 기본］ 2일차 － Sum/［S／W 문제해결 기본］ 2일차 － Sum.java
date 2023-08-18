import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
             
            int max = Integer.MIN_VALUE;
            int leftTopDiSum = 0; // left -> top 대각선
            int rightBottomSum = 0; // right -> botttom 대각선
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                    if (i == j) leftTopDiSum += arr[i][j];
                    if (i + j == 99) rightBottomSum += arr[i][j];
                    if (rowSum > max) max = rowSum;
                    if (colSum > max) max = colSum;
                }
            }
            if (leftTopDiSum > max) max = leftTopDiSum;
            if (rightBottomSum > max) max = rightBottomSum;
            System.out.println("#" + test_case + " " + max);
        }
    }
}