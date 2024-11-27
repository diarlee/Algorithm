import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M;
	static int[][] map = new int[5][5];
	static int[] pieces;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int max;
	static int maxCenterR;
	static int maxCenterC;
	static int maxAngle;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pieces = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			pieces[i] = Integer.parseInt(st.nextToken());
		}
		int pieceIdx = 0;
		
		for (int k = 0; k < K; k++) {
			max = 0;
			maxCenterR = 4;
			maxCenterC = 4;
			maxAngle = 4;
			// 탐사 1. 3×3 격자 선택
			for (int i = 1; i <= 3; i++) {
				for (int j = 1; j <= 3; j++) {
					// 탐사 2. 회전 선택
					for (int l = 1; l < 4; l++) {
						spin(i, j); // 90 180 270 회전
						visited = new boolean[5][5];
						int firstValue = getValue(i, j);
						boolean isMax = false;
						if (firstValue > max) {
							isMax = true;
						} 
						if (firstValue == max) {
							if (l < maxAngle) {
								isMax = true;
							} 
							if (l == maxAngle) {
								if (j < maxCenterC) {
									isMax = true;
								}
								if (j == maxCenterC) {
									if (i < maxCenterR) {
										isMax = true;
									}
								}
							}
						}
						if (isMax) {
							max = firstValue;
							maxCenterR = i;
							maxCenterC = j;
							maxAngle = l;
						}
					}
					spin(i, j); // 360도 회전
				}
			}
			
			if (max == 0) return;
			
			// 유물 획득 1. 1차 획득
			for (int i = 0; i < maxAngle; i++) {
				spin(maxCenterR, maxCenterC);
			}
			visited = new boolean[5][5];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (!visited[i][j]) {
						isGet = false;
						dfs(i, j, map[i][j], 1);
					}
				}
			}
			// 유물 획득 2. 조각 채우기
			for (int j = 0; j < 5; j++) {
				for (int i = 4; i >= 0; i--) {
					if (map[i][j] == 0) {
						map[i][j] = pieces[pieceIdx++];
					}
				}
			}
			// 유물 획득 3. 유물 연쇄 획득
			while (true) {
				boolean isEnd = true;
				visited = new boolean[5][5];
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (!visited[i][j]) {
							isGet = false;
							max += dfs(i, j, map[i][j], 1);
						}
						if (isEnd && isGet) {
							isEnd = false;
						}
					}
				}
				if (isEnd) break;
				for (int j = 0; j < 5; j++) {
					for (int i = 4; i >= 0; i--) {
						if (map[i][j] == 0) {
							map[i][j] = pieces[pieceIdx++];
						}
					}
				}
			}
			System.out.print(max + " ");
		}
	}
	
	static boolean isGet;
	
	static int dfs(int r, int c, int val, int cnt) {
		visited[r][c] = true;
		if (cnt >= 3) {
			isGet = true;
		}
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (0 <= nr && nr < 5 && 0 <= nc && nc < 5 && 
					!visited[nr][nc] && map[nr][nc] == val) {
				cnt = dfs(nr, nc, val, cnt + 1);
			}
		}
		if (isGet) {
			map[r][c] = 0;
			return cnt;
		}
		return 0;
	}
	
	static int bfs(int r, int c) {
		int value = map[r][c];
		int cnt = 0;
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {r, c});
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			Integer[] pos = queue.poll();
			cnt++;
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				nr = pos[0] + dr[i];
				nc = pos[1] + dc[i];
				if (0 <= nr && nr < 5 && 0 <= nc && nc < 5 && 
						!visited[nr][nc] && map[nr][nc] == value) {
					queue.add(new Integer[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		if (cnt >= 3) {
			return cnt;
		}
		return 0;
	}
	
	static int getValue(int r, int c) {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!visited[i][j]) {
					sum += bfs(i, j);
				}
			}
		}
		return sum;
	}
	
	static void spin(int r, int c) {
		int tmp = map[r - 1][c - 1];
		map[r - 1][c - 1] = map[r + 1][c - 1];
		map[r + 1][c - 1] = map[r + 1][c + 1];
		map[r + 1][c + 1] = map[r - 1][c + 1];
		map[r - 1][c + 1] = tmp;
		
		tmp = map[r - 1][c];
		map[r - 1][c] = map[r][c - 1];
		map[r][c - 1] = map[r + 1][c];
		map[r + 1][c] = map[r][c + 1];
		map[r][c + 1] = tmp;
	}
}