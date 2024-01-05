import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N + 3];
		for (int i = 3; i < N + 3; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N + 3]; // dp[i] : i번째 계단을 포함할때의 최대값
		for (int i = 3; i < N + 3; i++) {
			if (i == 3) dp[i] = stairs[i];
			if (i == 4) dp[i] = stairs[i - 1] + stairs[i];
			dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);
			
		}
		System.out.println(dp[N + 2]);	
	}
}