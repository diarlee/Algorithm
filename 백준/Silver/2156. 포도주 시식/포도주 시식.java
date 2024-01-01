import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] wines = new int[N + 3];
		for (int i = 3; i <= N + 2; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N + 3]; // dp[i] : i잔까지의 최대값
		for (int i = 3; i <= N + 2; i++) {
			// i잔을 안마실때, i - 1잔을 안마실때, i - 2잔을 안마실때
			dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + wines[i]), dp[i - 3] + wines[i - 1] + wines[i]);
		}
		System.out.println(dp[N + 2]);
	}
}