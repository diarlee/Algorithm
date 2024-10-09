import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] sequence = new int[1001];
		int cnt = 1;
		int idx = 1;
		while (idx <= 1000) {
			for (int j = 0; j < cnt; j++) {
				if (idx > 1000) break;
				sequence[idx++] = cnt;
			}
			cnt++;
		}
		
		int ans = 0;
		for (int i = A; i <= B; i++) {
			ans += sequence[i];
		}
		
		System.out.println(ans);
	}
}