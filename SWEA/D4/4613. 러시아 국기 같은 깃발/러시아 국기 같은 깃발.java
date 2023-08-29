import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(), M = sc.nextInt();
			char[][] arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next().toCharArray();
			}
			int topBotCnt = 0;
			for (int j = 0; j < M; j++) { // 첫 줄 마지막 줄 색칠
				if (arr[0][j] != 'W') topBotCnt++;
				if (arr[N - 1][j] != 'R') topBotCnt++;
			}
			int midMin = Integer.MAX_VALUE;
			for (int k = 1; k <= N - 2; k++) { // 파란 줄 개수 
				for (int l = 1; l <= N - 1 - k; l++) { // 파란 줄이 k개 일 때 반복 횟수 + 파란 줄 시작 위치
					int midCnt = 0;
					for (int i = 1; i < N - 1; i++) { // 중간지점 탐색
						for (int j = 0; j < M; j++) {
							if (i < l) { // 하얀 줄이어야하는 위치
								if (arr[i][j] != 'W') midCnt++;
							}
							if (l <= i && i < l + k) { // 파란 줄이어야하는 위치
								if (arr[i][j] != 'B') midCnt++;
							}
							if (i >= l + k) { // 빨간 줄이어야하는 위치
								if (arr[i][j] != 'R') midCnt++;
							}
						}
					}
					if (midCnt < midMin) midMin = midCnt;
				}
			}
			System.out.println("#" + t + " " + (topBotCnt + midMin));
		}
	}
}