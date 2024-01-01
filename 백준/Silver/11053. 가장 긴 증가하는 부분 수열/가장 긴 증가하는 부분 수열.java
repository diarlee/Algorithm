import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 1]; // 1 ~ i로 구성된 수열에서 nums[i]로 끝나는 가장 긴 증가하는 부분 순열의 길이
		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j <= i; j++) {
				if (nums[j] < nums[i] && dp[j] > max) {
					max = dp[j];
				}
				dp[i] = max + 1;
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (dp[i] > max) max = dp[i];
		}
		System.out.println(max);
	}
}