import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] costs;
	static boolean[] visited;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		costs = new int[N][N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		dfs(0, 0, 0, 0);
		System.out.println(min);
	}
	
	static void dfs(int st, int city, int level, int sum) {
		if (level == N - 1 && costs[city][st] != 0) {
			min = Math.min(min, sum + costs[city][st]);
			return;
		}
		if (level == N - 1) {
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (i != st && costs[city][i] != 0 && !visited[i]) {
				visited[i] = true;
				dfs(st, i, level + 1, sum + costs[city][i]);
				visited[i] = false;
			}
		}
	}
}