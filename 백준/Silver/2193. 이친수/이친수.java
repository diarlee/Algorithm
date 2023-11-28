import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// dp[0][i] : i자리 이친수 중 0으로 끝나는 개수
		// dp[1][i] : i자리 이친수 중 1로 끝나는 개수
		// dp[2][i] : i자리 이친수의 개수
		long[][] dp = new long[3][N + 1];
		dp[0][1] = 0;
		dp[1][1] = 1;
		dp[2][1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
			dp[1][i] = dp[0][i - 1];
			dp[2][i] = dp[0][i] + dp[1][i];
		}
		System.out.println(dp[2][N]);
	}
}