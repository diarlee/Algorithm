import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		long[][] adjArr = new long[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) adjArr[i][j] = 0;
				else adjArr[i][j] = Integer.MAX_VALUE;
			}
		}
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (adjArr[s][e] > w) adjArr[s][e] = w;
		}
		
		for (int K = 1; K <= n; K++) {
			for (int S = 1; S <= n; S++) {
				for (int E = 1; E <= n; E++) {
					if (S == E) continue;
					adjArr[S][E] = Math.min(adjArr[S][E], adjArr[S][K] + adjArr[K][E]);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (adjArr[i][j] == Integer.MAX_VALUE) adjArr[i][j] = 0;
				System.out.print(adjArr[i][j] + " ");
			}
			System.out.println();
		}
	}
}