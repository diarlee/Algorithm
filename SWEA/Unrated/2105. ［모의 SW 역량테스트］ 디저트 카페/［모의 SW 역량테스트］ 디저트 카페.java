import java.util.Scanner;

public class Solution {
	// 우하 좌하 좌상 우상
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, -1, 1};
	static int N;
	static int[][] cafes;
	static boolean[] dessert;
	static int max;
	static boolean[][] visited;
	static int stR;
	static int stC;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			cafes = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cafes[i][j] = sc.nextInt();
					
				}
			}
			dessert = new boolean[101]; // 방문한 카페의 디저트 수 체크 
			max = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					stR = i;
					stC = j;
					dfs(i, j, 0, -1, -1);
				}
			}
			if (max == 0) max = -1;
			System.out.println("#" + tc + " " + max);
		}
	}
	
	static void dfs(int r, int c, int dir, int pr, int pc) { // r, c : 현재 위치 pr, pc : 이전 위치
		dessert[cafes[r][c]] = true;
		visited[r][c] = true;
		cnt++;
		int nr = -1;
		int nc = -1;
		for (int d = dir; d < 4; d++) { // 방향 한 번 꺾으면 꺾기 이전 방향은 탐색하지 않음 // 사각형이 만들어지는 방향으로만 탐색
			nr = r + dr[d];
			nc = c + dc[d];
			if (nr == stR && nc == stC && (nr != pr || nc != pc)) { // 시작점으로 돌아올경우 (왔던길 되돌아오는 경우 제외)
				if (cnt > max) max = cnt;
				// 백트래킹
				cnt--;
				visited[r][c] = false;
				dessert[cafes[r][c]] = false;
				return;
			}
			if (0 <= nr && nr < N && 0 <= nc && nc < N && !dessert[cafes[nr][nc]] && !visited[nr][nc]) {
				dfs(nr, nc, d, r, c);
			}
		}
		// 백트래킹
		cnt--;
		visited[r][c] = false;
		dessert[cafes[r][c]] = false;
	}
}