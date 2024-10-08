import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static List<Integer[]> bridges;
	static int[] p;
	
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
		
		// 섬 구분하기
		visited = new boolean[N][M];
		int land = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j, ++land);
				}
			}
		}
		
		
		// 섬과 섬을 연결하는 가능한 모든 다리 만들기
		bridges = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					makeBridge(i, j);
				}
			}
		}
		
		// 모든 섬을 연결하는 최소 다리 길이 구하기
		Collections.sort(bridges, new Comparator<Integer[]>(){
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[2] - o2[2];
			}
		});
		p = new int[land + 1];
		for (int i = 1; i < land; i++) {
			p[i] = i;
		}
		int ans = 0;
		int pick = 0;
		for (int i = 0; i < bridges.size(); i++) {
			int x = bridges.get(i)[0];
			int y = bridges.get(i)[1];
			if (findSet(x) != findSet(y)) {
				union(x, y);
				ans += bridges.get(i)[2];
				pick++;
			}
			if (pick == land - 1) {
				System.out.println(ans);
				return;
			}
		}
		
		System.out.println(-1);
		
	}
	
	static void bfs(int r, int c, int land) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {r, c});
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			Integer[] pos = queue.poll();
			map[pos[0]][pos[1]] = land;
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				nr = pos[0] + dr[i];
				nc = pos[1] + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 1 && !visited[nr][nc]) {
					queue.add(new Integer[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	static void makeBridge(int r, int c) {
		int land = map[r][c];
		int nr, nc;
		outer : for (int i = 0; i < 4; i++) {
			int cnt = 0;
			nr = r + dr[i];
			nc = c + dc[i];
			while(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0) {
				cnt++;
				nr += dr[i];
				nc += dc[i];
			}
			if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != land && cnt > 1) {
				Integer[] newBridge = new Integer[] {Math.min(land, map[nr][nc]), Math.max(land, map[nr][nc]), cnt};
				
				for (int j = 0; j < bridges.size(); j++) {
					if (Arrays.equals(bridges.get(j), newBridge)) {
						continue outer;
					}
				}
				bridges.add(newBridge);
			}
		}
	}
	
	static int findSet(int x) {
		if (x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}