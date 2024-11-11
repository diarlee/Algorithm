import java.util.*;

class Solution {
    static int N;
    static int[][] map;
    static int[][][] dp;

    public int solution(String numbers) {
        N = numbers.length();
        map = new int[10][10];
        map[0] = new int[] {1, 7, 6, 7, 5, 4, 5, 3, 2, 3};
        map[1] = new int[] {7, 1, 2, 4, 2, 3, 5, 4, 5, 6};
        map[2] = new int[] {6, 2, 1, 2, 3, 2, 3, 5, 4, 5};
        map[3] = new int[] {7, 4, 2, 1, 5, 3, 2, 6, 5, 4};
        map[4] = new int[] {5, 2, 3, 5, 1, 2, 4, 2, 3, 5};
        map[5] = new int[] {4, 3, 2, 3, 2, 1, 2, 3, 2, 3};
        map[6] = new int[] {5, 5, 3, 2, 4, 2, 1, 5, 3, 2};
        map[7] = new int[] {3, 4, 5, 6, 2, 3, 5, 1, 2, 4};
        map[8] = new int[] {2, 5, 4, 5, 3, 2, 3, 2, 1, 2};
        map[9] = new int[] {3, 6, 5, 4, 5, 3, 2, 4, 2, 1};
        
        // DP 배열 초기화
        dp = new int[N + 1][10][10];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        // 시작 위치 설정
        dp[0][4][6] = 0;

        // DP 점화식 계산
        for (int i = 0; i < N; i++) {
            int target = numbers.charAt(i) - '0';
            for (int l = 0; l < 10; l++) {
                for (int r = 0; r < 10; r++) {
                    if (dp[i][l][r] == Integer.MAX_VALUE) continue;

                    // 왼손 이동
                    if (target != r) {
                        int newCost = dp[i][l][r] + map[l][target];
                        dp[i + 1][target][r] = Math.min(dp[i + 1][target][r], newCost);
                    }

                    // 오른손 이동
                    if (target != l) {
                        int newCost = dp[i][l][r] + map[r][target];
                        dp[i + 1][l][target] = Math.min(dp[i + 1][l][target], newCost);
                    }
                }
            }
        }

        // 최솟값 찾기
        int minCost = Integer.MAX_VALUE;
        for (int l = 0; l < 10; l++) {
            for (int r = 0; r < 10; r++) {
                minCost = Math.min(minCost, dp[N][l][r]);
            }
        }

        return minCost;
    }
}
