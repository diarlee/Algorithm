import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[N][5];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		HashSet<Integer>[] sets = new HashSet[N + 1];
		for (int i = 0; i < N; i++) {
			sets[i] = new HashSet<>();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				int num = table[i][j];
				for (int k = 0; k < N; k++) {
					if (k == i) continue;
					if (table[k][j] == num) {
						sets[i].add(k);
					}
				}
			}
		}
		
		int max = -1;
		int ans = -1;
		for (int i = 0; i < N; i++) {
			if (sets[i].size() > max) {
				max = sets[i].size();
				ans = i;
			}
		}
		
		System.out.println(ans + 1);
	}
}