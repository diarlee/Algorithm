import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[400][201]; // 조합 dp
		for (int i = 1; i < 400; i++) {
			for (int j = 1; j <= 200; j++) {
				if (i == j) dp[i][j] = 1;
				else if (j == 1) dp[i][j] = i;
				else if (i > j) dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 1000000000;
			}
		}
		System.out.println(dp[K + N - 1][N]);
	}
}