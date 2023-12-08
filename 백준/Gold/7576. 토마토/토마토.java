import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] boxes;
	static int total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		boxes = new int[N][M];
		total = N * M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				boxes[i][j] = Integer.parseInt(st.nextToken());
				if (boxes[i][j] == -1) total--;
			}
		}
		int result = bfs();
		System.out.println(result);
	}
	
	static int bfs() {
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		boolean[][] visited = new boolean[N][M];
		int[][] days = new int[N][M];
		Queue<Integer[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (boxes[i][j] == 1) {
					queue.offer(new Integer[]{i, j});
					visited[i][j] = true;
					days[i][j] = 0;
					total--;
					if (total == 0) {
						return 0;
					}
				}
			}
		}
		
		while (!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				nr = cur[0] + dr[i];
				nc = cur[1] + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && boxes[nr][nc] != -1) {
					queue.offer(new Integer[] {nr, nc});
					visited[nr][nc] = true;
					boxes[nr][nc] = 1;
					days[nr][nc] = days[cur[0]][cur[1]] + 1;
					total--;
					if (total == 0) {
						return days[nr][nc];
					}
					
				}
			}
		}
		return -1;
	}
}