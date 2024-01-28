import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 1]; // dp[i] : i장 구매시 최대 금액
		for (int i = 1; i <= N; i++) {
			int half = i / 2;
			dp[i] = p[i];
			for (int j = 1; j <= half; j++) { // i장이 되는 조합 찾기
				dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
}