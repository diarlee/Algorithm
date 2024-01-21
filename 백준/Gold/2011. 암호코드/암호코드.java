import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		int N = code.length();
		int[][] dp = new int[N][27];
		dp[0][Character.getNumericValue(code.charAt(0))] = 1;
		for (int i = 1; i < code.length(); i++) {
			int curNum = Character.getNumericValue(code.charAt(i));
			int preNum;
			for (int j = 1; j <= 26; j++) {
				if (dp[i - 1][j] == 0) continue;
				preNum = j;
				if (10 * preNum + curNum > 26)
					dp[i][curNum] += dp[i - 1][preNum] % 1000000;
				else {
					dp[i][curNum] += dp[i - 1][preNum] % 1000000;
					dp[i][10 * preNum + curNum] += dp[i - 1][preNum] % 1000000;
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= 26; i++) {
			cnt += dp[N - 1][i];
		}
		System.out.println(cnt % 1000000);
	}
}