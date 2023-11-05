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
	static int[][] maze;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1}; // 우하좌상
	static int[] dc = {1, 0, -1, 0};
	static int depth;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		visited = new boolean[N][M];
		depth = 0;
		bfs(0, 0);
	}
	
	static void bfs(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<>();
		Integer[] stPoint = {r, c};
		queue.add(stPoint);
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			Integer[] curPoint = queue.poll();
			Integer cr = curPoint[0];
			Integer cc = curPoint[1];
			if (cr == N - 1 && cc == M - 1) {
				System.out.println(maze[N - 1][M - 1]);
				break;
			}
			for (int d = 0; d < 4; d++) {
				Integer nr = cr + dr[d];
				Integer nc = cc + dc[d];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && maze[nr][nc] != 0 && !visited[nr][nc]) {
					Integer[] nextPoint = {nr, nc};
					queue.add(nextPoint);
					visited[nr][nc] = true;
					maze[nr][nc] = maze[cr][cc] + 1; // 한 단계당 깊이 1 // 같은 for문 안의 좌표들은 깊이가 같음
				}
			}
		}
	}
}