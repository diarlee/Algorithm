import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N + 1];
			for (int i = 1; i <= N; i++) {
				if (i <= 3) dp[i] = 1;
				else if (i <= 5) dp[i] = 2;
				else dp[i] = dp[i - 5] + dp[i - 1];
			}
			System.out.println(dp[N]);
		}
	}
}