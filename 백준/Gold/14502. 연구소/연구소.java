import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, 1, 0, -1}; // 우하좌상
	static int[] dc = {1, 0, -1, 0};
	static int N;
	static int M;
	static int[][] map;
	static int blankCnt;
	static Node[] blanks;
	static Node[] sel = new Node[3];
	static boolean[][] visited;
	static int safeMax;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		blankCnt = 0;
		int[] stPos = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					blankCnt++;
				}
			}
		}
		
		blanks = new Node[blankCnt];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					blanks[cnt++] = new Node(i, j);
				}
			}
		}
		
		safeMax = 0;
		combi(0, 0);
		System.out.println(safeMax);
	}
	
	static void combi(int idx, int sidx) {
		if (sidx == 3) { 
			// 벽 3개 세움
			for (int i = 0; i < 3; i++) {
				map[sel[i].r][sel[i].c] = 1;
			}
			// 안전지역 계산
			int safeZone = blankCnt - 3;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 2) {
						safeZone -= bfs(i, j);
					}
				}
			}
			safeMax = Math.max(safeMax, safeZone);
			// 세운 벽 부숨
			for (int i = 0; i < 3; i++) {
				map[sel[i].r][sel[i].c] = 0;
			}
			return;
		}
		
		for (int i = idx; i <= blankCnt - 3 + sidx; i++) {
			sel[sidx] = blanks[i];
			combi(i + 1, sidx + 1);
		}
		
	}
	
	static int bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c)); // 바이러스가 존재하는 곳에서 시작
		visited[r][c] = true;
		int cnt = 0; // 바이러스가 확산된 칸 개수
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node curNode = queue.poll();
				int nr, nc;
				for (int j = 0; j < 4; j++) {
					nr = curNode.r + dr[j];
					nc = curNode.c + dc[j];
					if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0 &&
							!visited[nr][nc]) {
						queue.add(new Node(nr, nc));
						visited[nr][nc] = true;
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	}
	
	static class Node{
		int r;
		int c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}