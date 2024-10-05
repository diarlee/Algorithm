import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static ArrayList<Integer[]> cctvs;
	static boolean[][] monitored;
	static int walls;
	static int answer;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0}; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvs = new ArrayList<>();
		walls = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new Integer[] {i, j, map[i][j]});
				}
				if (map[i][j] == 6) walls++;
			}
		}
		
		monitored = new boolean[N][M];
		answer = N * M;
		perm(0, 0);
		System.out.println(answer);
	}
	
	static void perm(int idx, int total) {
		if (idx == cctvs.size()) {
			answer = Math.min(answer, N * M - walls - total);
			if (N * M - walls - total == 7) {
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						System.out.print(monitored[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			return;
		}
		Integer[] cur = cctvs.get(idx);
		monitor(cur[0], cur[1], cur[2], idx, total);
	}	
	
	
	static void monitor(int r, int c, int cctvNum, int idx, int total) {	
		if (cctvNum == 1) {
			for (int i = 0; i < 4; i++) {
				// 한 방향 쭉 감시
				ArrayList<Integer[]> visited = new ArrayList<>();
				check(r, c ,i, visited);
				// 다음 cctv로 넘어감
				perm(idx + 1, total + visited.size());
				// 백트래킹
				for (int j = 0; j < visited.size(); j++) {
					Integer[] pos = visited.get(j);
					monitored[pos[0]][pos[1]] = false;
				}
				
			}
		} else if (cctvNum == 2) {
			for (int i = 0; i < 2; i++) {
				ArrayList<Integer[]> visited = new ArrayList<>();
				if (!monitored[r][c]) {
					monitored[r][c] = true;
					visited.add(new Integer[] {r,c});
				}
				check(r + dr[i], c + dc[i], i, visited);
				check(r + dr[i + 2], c + dc[i + 2], i + 2, visited);

				perm(idx + 1, total + visited.size());
				
				for (int j = 0; j < visited.size(); j++) {
					Integer[] pos = visited.get(j);
					monitored[pos[0]][pos[1]] = false;
				}
			}
			
			
		} else if (cctvNum == 3) {
			for (int i = 0; i < 4; i++) {
				ArrayList<Integer[]> visited = new ArrayList<>();
				if (!monitored[r][c]) {
					monitored[r][c] = true;
					visited.add(new Integer[] {r,c});
				}
				check(r + dr[i], c + dc[i], i, visited);
				int ni = (i + 1) % 4;
				check(r + dr[ni], c + dc[ni], ni, visited);
				
				perm(idx + 1, total + visited.size());
				
				for (int j = 0; j < visited.size(); j++) {
					Integer[] pos = visited.get(j);
					monitored[pos[0]][pos[1]] = false;
				}
			}	
			
		} else if (cctvNum == 4) {
			for (int i = 0; i < 4; i++) {
				ArrayList<Integer[]> visited = new ArrayList<>();
				if (!monitored[r][c]) {
					monitored[r][c] = true;
					visited.add(new Integer[] {r,c});
				}
				check(r + dr[i], c + dc[i], i, visited);
				int ni = (i + 1) % 4;
				check(r + dr[ni], c + dc[ni], ni, visited);
				int nni = (i + 2) % 4;
				check(r + dr[nni], c + dc[nni], nni, visited);
				
				perm(idx + 1, total + visited.size());
				
				for (int j = 0; j < visited.size(); j++) {
					Integer[] pos = visited.get(j);
					monitored[pos[0]][pos[1]] = false;
				}
				
			}
		} else if (cctvNum == 5) {
			ArrayList<Integer[]> visited = new ArrayList<>();
			if (!monitored[r][c]) {
				monitored[r][c] = true;
				visited.add(new Integer[] {r,c});
			}
			for (int i = 0; i < 4; i++) {
				check(r + dr[i], c + dc[i], i, visited);
			}
			
			perm(idx + 1, total + visited.size());
			
			for (int i = 0; i < visited.size(); i++) {
				Integer[] pos = visited.get(i);
				monitored[pos[0]][pos[1]] = false;
			}
		}
	}
	static void check(int nr, int nc, int dir, ArrayList<Integer[]> visited) {
		while (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 6) {
			if (!monitored[nr][nc]) {
				monitored[nr][nc] = true;
				visited.add(new Integer[] {nr, nc});
			}
			nr += dr[dir];
			nc += dc[dir];
		}
	}
}