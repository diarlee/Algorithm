import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0}; // 북동남서
	static int[] dc = {0, 1, 0, -1};
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r, c, d);
		System.out.println(cnt);
	}
	
	static void clean(int r, int c, int d) {
		if (map[r][c] == 0) {
			map[r][c] = -1;
			cnt++;
		}
		
		int nr, nc;
		boolean flag = false; // 주변 4칸 중 청소 안한 구역이 있는지
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (map[nr][nc] == 0) {
				flag = true;
				break;
			}
		}
		
		if (!flag) {
			nr = r - dr[d];
			nc = c - dc[d];
			if (map[nr][nc] != 1) {
				clean(nr, nc , d);
			}
			if (map[nr][nc] == 1) {
				return;
			}
		} else {
			for (int i = 0; i < 4; i++) {
				d = d - 1 < 0 ? 3 : d - 1;
				nr = r + dr[d];
				nc = c + dc[d];
				if (map[nr][nc] == 0) {
					clean(nr, nc, d);
					break;
				}
			}
		}
		
	}
}