import java.util.*;
import java.io.*;

public class Main {
	static int M;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] cnts;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		visited = new boolean[N][M];
		cnts = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(cnts[i], 10000);
		}
		int result = N == 1 && M == 1 ? 0 : bfs();
		System.out.println(result);
	}
	
	static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0));
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			int nr, nc;
			for (int j = 0; j < 4; j++) {
				nr = curNode.r + dr[j];
				nc = curNode.c + dc[j];
				if (0 <= nr && nr < N && 0 <= nc && nc < M
						&& curNode.cnt + map[nr][nc] < cnts[nr][nc]) {
					queue.add(new Node(nr, nc, curNode.cnt + map[nr][nc]));
					cnts[nr][nc] = curNode.cnt + map[nr][nc];
				}
			}
		}
		return cnts[N - 1][M - 1];
	}
	
	static class Node{
		int r;
		int c;
		int cnt;
		
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}