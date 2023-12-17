import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] result;
	// 우 우하 하 좌하 좌 좌상 상 우상
	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = 2500;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) { // 상어가 있는곳에서 시작하여 안전거리 파악
					visited = new boolean[N][M];
					result[i][j] = 0;
					bfs(i, j);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (result[i][j] > max) max = result[i][j];
			}
		}
		System.out.println(max);
	}
	
	static void bfs(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[]{r, c});
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			Integer[] curNode = queue.poll();
			int cr = curNode[0];
			int cc = curNode[1];
			int nr, nc;
			for (int i = 0; i < 8; i++) {
				nr = cr + dr[i];
				nc = cc + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] == 0) {
					if (result[nr][nc] > result[cr][cc] + 1) { // 더 가까운 곳에 상어가 있을 경우 갱신
						queue.add(new Integer[] {nr, nc});
						visited[nr][nc] = true;
						result[nr][nc] = result[cr][cc] + 1;
					}
				}
			}
		}
	}
}