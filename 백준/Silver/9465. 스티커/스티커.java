import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] stickers = new int[2][N + 1];
			StringTokenizer st;
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[2][N + 1]; // dp[i][j] : i행 j열 위치까지의 최대값
			for (int i = 1; i <= N; i++) {
				if (dp[0][i - 1]> dp[1][i - 1] + stickers[0][i]) dp[0][i] = dp[0][i - 1];
				if (dp[0][i - 1] <= dp[1][i - 1] + stickers[0][i]) dp[0][i] = dp[1][i - 1] + stickers[0][i];
				if (dp[0][i - 1] + stickers[1][i] < dp[1][i - 1]) dp[1][i] = dp[1][i - 1];
				if (dp[0][i - 1] + stickers[1][i] >= dp[1][i - 1]) dp[1][i] = dp[0][i - 1] + stickers[1][i];
			}
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
	}
}