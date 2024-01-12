import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[0] = 1;
		for (int i = 2; i <= N; i+=2) {
			if (i == 2) dp[i] = 3;
			else
			dp[i] = 4 * dp[i - 2] - dp[i - 4];
		}
		System.out.println(dp[N]);
	}
}