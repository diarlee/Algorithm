import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger[] dp = new BigInteger[N + 1];
		if (N < 3) dp[N] = BigInteger.valueOf(N);
		else {
			dp[1] = BigInteger.valueOf(1);
			dp[2] = BigInteger.valueOf(2);
			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 2].add(dp[i - 1])).remainder(BigInteger.valueOf(10007));
			}
		}
		System.out.println(dp[N]);
	}
}