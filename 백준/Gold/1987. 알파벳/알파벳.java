import java.io.*;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static boolean[] checked;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int level;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String letters = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = letters.charAt(j);
			}
		}
		visited = new boolean[R][C];
		checked = new boolean[26];
		level = 0;
		result = 0;
		dfs(0, 0);
		System.out.println(result);
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		checked[map[r][c] - 'A'] = true;
		level++;
		result = Math.max(result, level);
		if (result == 26) return;
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc] 
					&& !checked[map[nr][nc] - 'A']) {
				dfs(nr, nc);
			}
		}
		level--;
		checked[map[r][c] - 'A'] = false;
		visited[r][c] = false;
	}
}