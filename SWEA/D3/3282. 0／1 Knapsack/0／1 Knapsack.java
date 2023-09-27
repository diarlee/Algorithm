import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] volumes = new int[N + 1];
			int[] values = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				volumes[i] = sc.nextInt();
				values[i] = sc.nextInt();
			}
			int[][] dp = new int[N + 1][K + 1];
			for (int i = 1; i <= N; i++) {
				for (int k = 1; k <= K; k++) {
					if (volumes[i] <= k) 
						dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k -  volumes[i]] + values[i]);
					else 
						dp[i][k] = dp[i - 1][k];
				}
			}
			System.out.println("#" + tc + " " + dp[N][K]);
		}
	}
}