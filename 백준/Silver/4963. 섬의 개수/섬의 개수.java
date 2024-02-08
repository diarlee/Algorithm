import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 || h == 0) break;
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[h][w];
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	static void bfs(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {r,c});
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			Integer[] curNode = queue.poll();
			int nr, nc;
			for (int i = 0; i < 8; i++) {
				nr = curNode[0] + dr[i];
				nc = curNode[1] + dc[i];
				if (0 <= nr && nr < h && 0 <= nc && nc < w && map[nr][nc] == 1 && !visited[nr][nc]) {
					queue.add(new Integer[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}