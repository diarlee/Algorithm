import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
			
		int[] dp = new int[N + 1]; // dp[i] : nums[i]로 끝나는 연속합 중 최대값
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]); // 이전 연속에 연결 vs 새로운 연속 시작
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}