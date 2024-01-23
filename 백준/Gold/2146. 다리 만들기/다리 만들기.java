import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int islandCnt;
	static int minBridge;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 해안 구하기
		visited = new boolean[N][N];
		islandCnt = 1; // islandCnt - 1 = 섬의 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					// 섬발견
					islandCnt++;
					getIslands(i, j);
				}
			}
		}
		
		// 해안에서 출발하여 다른 섬을 연결하는 가장 짧은 다리 구하기
		minBridge = 10000;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && map[i][j] != 1) {
					visited = new boolean[N][N];
					makeBridge(i, j);
				}
			}
		}
		
		System.out.println(minBridge);
	}
	
	static void getIslands(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {r, c});
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			Integer[] curPos = queue.poll();
			int nr, nc;
			boolean isInner = true; // 섬에서 내륙인가?
			for (int i = 0; i < 4; i++) {
				nr = curPos[0] + dr[i];
				nc = curPos[1] + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
					if (map[nr][nc] != 0) { // 육지로 둘러싸임
						queue.add(new Integer[] {nr, nc});
						visited[nr][nc] = true;
					} else isInner = false; // 바다가 인접
				}
			}
			if (!isInner) map[curPos[0]][curPos[1]] = islandCnt;
		}
	}
	
	static void makeBridge(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {r, c});
		visited[r][c] = true;
		int level = 0;
		while (true) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer[] curPos = queue.poll();
				int nr, nc;
				for (int j = 0; j < 4; j++) {
					nr = curPos[0] + dr[j];
					nc = curPos[1] + dc[j];
					if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
						if (map[nr][nc] == 0) {
							queue.add(new Integer[] {nr, nc});
							visited[nr][nc] = true;
						}
						else if (map[nr][nc] != 1 && map[nr][nc] != map[r][c]) {
							if (level < minBridge) minBridge = level;
							return;
						}
					}
				}
			}
			level++;
			if (queue.isEmpty()) return;
		}
	}
}