import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[2][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			table[0][i] = t;
			table[1][i] = p;
		}
		
		int[] dp = new int[N + 1];
		for (int i = N - 1; i >= 0; i--) {
			if (i + table[0][i] > N) {
				dp[i] = dp[i + 1];
			} else {
				dp[i] = Math.max(dp[i + 1], dp[i + table[0][i]] + table[1][i]);
			}
		}
		System.out.println(dp[0]);
	}
}