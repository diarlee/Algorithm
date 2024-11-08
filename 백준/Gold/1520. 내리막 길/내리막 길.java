import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}
		dfs(0, 0);
		System.out.println(visited[0][0]);
	}
	
	static int dfs(int r, int c) {
		if (r == M - 1 && c == N - 1) {
			return 1;
		}
		if (visited[r][c] != -1) {
			return visited[r][c];
		}
		visited[r][c] = 0;
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (0 <= nr && nr < M && 0 <= nc && nc < N && map[nr][nc] < map[r][c]) {
				visited[r][c] += dfs(nr, nc);
			}
		}
		return visited[r][c];
	}
}