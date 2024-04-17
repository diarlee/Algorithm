import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int H = 2001;
	static int W = 2001;
	static int[][] map = new int[H][W];
	static boolean[][] visited = new boolean[H][W];
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int x1, y1, x2, y2;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()) + 500;
			y1 = Integer.parseInt(st.nextToken()) + 500;
			x2 = Integer.parseInt(st.nextToken()) + 500;
			y2 = Integer.parseInt(st.nextToken()) + 500;
			
			for (int x = x1 * 2; x <= x2 * 2; x++) {
				map[y1 * 2][x] = 1;
				map[y2 * 2][x] = 1;
			}
			for (int y = y1 * 2; y <= y2 * 2; y++) {
				map[y][x1 * 2] = 1;
				map[y][x2 * 2] = 1;
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		if (map[1000][1000] == 1) {
			cnt--;
		}
		System.out.println(cnt);
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (0 <= nr && nr < H && 0 <= nc && nc < W && 
					map[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
}