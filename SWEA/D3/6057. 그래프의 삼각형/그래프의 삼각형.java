import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] adjArr = new int[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                adjArr[x][y] = 1;
                adjArr[y][x] = 1;
            }
            int cnt = 0;
            for (int i = 1; i < N + 1; i++) {
                for (int j = i + 1; j < N + 1; j++) {
                    for (int k = j + 1; k < N + 1; k++) {
                        if (adjArr[i][j] == 1 && adjArr[j][k] == 1 && adjArr[k][i] == 1) cnt++;
                    }
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}