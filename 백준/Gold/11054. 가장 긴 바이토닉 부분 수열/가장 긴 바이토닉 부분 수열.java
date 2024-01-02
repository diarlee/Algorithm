import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dpL = new int[N];
		for (int i = 0; i < N; i++) {
			dpL[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && dpL[j] >= dpL[i]) {
					dpL[i] = dpL[j] + 1;
				}
			}
		}
		int[] dpR = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			dpR[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (nums[j] < nums[i] && dpR[j] >= dpR[i]) {
					dpR[i] = dpR[j] + 1;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dpL[i] + dpR[i] - 1);
		}
		System.out.println(max);
	}
}