import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] input;
	static int[] dr = {0, 1, 0, -1}; // 우하좌상
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 2][N + 2];
		StringTokenizer st;
		input = new int[N * N + 1][4]; // 점수계산을 위해 input 정보 저장
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int stuNum = Integer.parseInt(st.nextToken());
			int[] likeStuNums = new int[4];
			for (int j = 0; j < 4; j++) {
				likeStuNums[j] = Integer.parseInt(st.nextToken());
			}
			input[stuNum] = likeStuNums;
			setPos(stuNum, likeStuNums);
		}
		System.out.println(getScore());
	}
	
	static void setPos(int stuNum, int[] likeStuNums) {
		// condi1
		int[][] nearLikeStu = new int[N + 2][N + 2];
		int[][] nearEmpty = new int[N + 2][N + 2];
		// 가장자리 정리
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				if (i == 0 || j == 0 || i == N + 1 || j == N + 1) {
					map[i][j] = -1;
					nearLikeStu[i][j] = -1;
					nearEmpty[i][j] = -1;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				if (map[i][j] == 0) {
					for (int k = 0; k < 4; k++) { // 인접칸 돌기
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (map[nr][nc] == 0) // 인접칸이 빈칸일 경우
							nearEmpty[i][j]++;
						else if (map[nr][nc] != -1) { // 인접칸에 누가 있으면
							for (int l = 0; l < 4; l++) { // 선호 학생인지 확인
								if (map[nr][nc] == likeStuNums[l])
									nearLikeStu[i][j]++;
							}
						}
					}
				}
				if (nearLikeStu[i][j] > max) max = nearLikeStu[i][j]; // 인접칸에 있는 선호학생 최대값
			}
		}
		
		List<Integer[]> maxPos = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 0 && nearLikeStu[i][j] == max) {
					maxPos.add(new Integer[]{i, j});
				}
			}
		}
		if (maxPos.size() == 1) map[maxPos.get(0)[0]][maxPos.get(0)[1]] = stuNum; // 선호학생 최대값이 한자리인 경우
		// condi2
		else { // 여러자리인 경우
			// 선호학생 최대값 자리 중에서 인접칸에 빈칸이 가장 많은 경우 찾기
			int maxEmpty = 0;
			for (int i = 0; i < maxPos.size(); i++) { 
				maxEmpty = Math.max(maxEmpty, nearEmpty[maxPos.get(i)[0]][maxPos.get(i)[1]]);
			}
			// condi3
			for (int i = 0; i < maxPos.size(); i++) {
				if (nearEmpty[maxPos.get(i)[0]][maxPos.get(i)[1]] == maxEmpty) {
					map[maxPos.get(i)[0]][maxPos.get(i)[1]] = stuNum;
					break;
				}
			}
		}
	}
	
	static int getScore() {
		int score = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int stuNum = map[i][j];
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (map[nr][nc] != -1) {
						for (int l = 0; l < 4; l++) {
							if (map[nr][nc] == input[stuNum][l])
								cnt++;
						}
					}
				}
				if (cnt == 1) score += 1;
				if (cnt == 2) score += 10;
				if (cnt == 3) score += 100;
				if (cnt == 4) score += 1000;
			}
		}
		return score;
	}
}