import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	// 우하좌상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int N;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					pq.add(bfs(i, j));
				}
			}
		}
		int size = pq.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(pq.poll());
		}
	}

	static int bfs(int r, int c) {
		int cnt = 0;
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {r, c});
		visited[r][c] = true;
		cnt++;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer[] curNode = queue.poll();
				int nr, nc;
				for (int j = 0; j < 4; j++) {
					nr = curNode[0] + dr[j];
					nc = curNode[1] + dc[j];
					if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] == 1 && !visited[nr][nc]) {
						queue.add(new Integer[] {nr, nc});
						visited[nr][nc] = true;
						cnt++;
					}
					
				}
			}
		}
		return cnt;
	}
}