import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][11];
		for (int i = 1; i <= N; i++) {
			long sum = 0;
			for (int j = 0; j <= 10; j++) {
				if (i == 1 && j != 10) {
					dp[i][j] = 1;
					sum += dp[i][j];
				}
				else if (j == 0){
					dp[i][j] = dp[i - 1][10];
					sum += dp[i][j];
				}
				else if (j == 10) {
					dp[i][j] = sum % 10007; 
					sum = 0;
				}
				else {
					dp[i][j] = (dp[i][j - 1] + 10007 - dp[i - 1][j - 1]) % 10007;
					sum += dp[i][j];
				}
			}
		}
		System.out.println(dp[N][10]);
	}
}