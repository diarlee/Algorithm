import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[10][N + 1];
		for (int i = 1; i < 10; i++) { // 한 자리수 일 때
			dp[i][1] = 1; 
		}
		for (int j = 2; j <= N; j++) {
			for (int i = 0; i < 10; i++) {
				if (i == 0) dp[i][j] = dp[i + 1][j - 1] % 1000000000;
				else if (i == 9) dp[i][j] = dp[i - 1][j - 1] % 1000000000;
				else dp[i][j] = (dp[i - 1][j - 1]+ dp[i + 1][j - 1]) % 1000000000;
			}
		}
		long result = 0;
		for (int i = 0; i < 10; i++) {
			result += dp[i][N];
		}
		System.out.println(result % 1000000000);
	}
}