import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lIdx = 0, rIdx = 0, sum = arr[0], ans = 100000;
		while (lIdx < N && rIdx < N) {
			
			if (lIdx == rIdx && sum >= S) {
				ans = 1;
				break;
			}
			
			if (sum >= S) {
				ans = Math.min(ans, rIdx - lIdx + 1);
				sum -= arr[lIdx++];
				continue;
			}
			
			if (rIdx == N - 1) {
				break;
			}
			sum += arr[++rIdx];
		}
		
		ans = ans == 100000 ? 0 : ans;
		System.out.println(ans);
	}
}