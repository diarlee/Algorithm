import java.util.Scanner;

public class Solution {
	static int[][] arr;
	static int[] dr = {0, 1, 0, -1}; // 우하좌상
	static int[] dc = {1, 0, -1, 0};
	static int[][] visited; // day마다 방문한 지점 기록
	
	static void dfs(int i, int j) { // i, j : 탐색지점
		visited[i][j] = arr[i][j];
		arr[i][j] = 0; // i, j 방문 처리 후 i, j 주위 탐색
		for (int d = 0; d <= 3; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (arr[nr][nc] != 0) dfs(nr, nc);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			arr = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			visited = new int[N + 2][N + 2];
			int max = 1; // 요정이 먹은 부분이 없는 1개의 덩어리에서 시작
			for (int day = 1; day <= 100; day++) {
				int cnt = 0; // day마다 덩어리 count
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (arr[i][j] <= day) arr[i][j] = 0; // d번째 날 d인 칸 먹음
					}
				}
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (arr[i][j] != 0) {
							dfs(i, j); // dfs 시작 = 덩어리 1개
							cnt++; 
						}
					}
				}
				// day에 방문했던 지점들 복구
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (visited[i][j] != 0) {
							arr[i][j] = visited[i][j];
							visited[i][j] = 0;
						}
					}
				}
				if (cnt > max) max = cnt;
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}