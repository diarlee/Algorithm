import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] map;
	static int pCnt; // 사람 수
	static int[] peopleR; // 사람들의 행 위치
	static int[] peopleC; // 사람들의 열 위치
	static int[] K; // 계단 값
	static int[] stairsR; // 계단들의 행 위치
	static int[] stairsC; // 계단들의 열 위치
	static boolean[] visited;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			pCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) pCnt++;
				}
			}
			peopleR = new int[pCnt + 1];
			peopleC = new int[pCnt + 1];
			K = new int[3];
			stairsR = new int[3];
			stairsC = new int[3];
			visited = new boolean[pCnt + 1];
			pCnt = 1;
			int sCnt = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						peopleR[pCnt] = i;
						peopleC[pCnt] = j;
						pCnt++;
						continue;
					} 
					if (map[i][j] == 0) continue;
					else {
						K[sCnt] = map[i][j];
						stairsR[sCnt] = i;
						stairsC[sCnt] = j;
						sCnt++;
					}
				}
			}
			min = Integer.MAX_VALUE;
			combi(1);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	static void combi(int idx) { // 수열 만들기
		if (idx == pCnt) { // 수열 완성
			int cnt = 0;
			for (int i = 1; i < pCnt; i++) { // true : 1번 계단, false : 2번 계단
				if (visited[i]) cnt++; 
			}
			int[] stair1 = new int[cnt]; 
			int[] stair2 = new int[pCnt - 1 - cnt];
			getTime(stair1, stair2);
			return;
		}
		visited[idx] = true;
		combi(idx + 1);
		visited[idx] = false;
		combi(idx + 1);
	}
	
	// stair1 : 1번 계단에 배정된 사람들의 계단까지의 소요 시간
	// stair2 : 2번 계단에 배정된 사람들의 계단까지의 소요 시간
	static void getTime(int[] stair1, int[] stair2) { 
		int cnt1 = 0; 
		int cnt2 = 0;
		for (int i = 1; i < pCnt; i++) {  // 계단까지의 거리 구하기
			if (visited[i]) { 
				stair1[cnt1++] = (int) Math.abs(peopleR[i] - stairsR[1]) + Math.abs(peopleC[i] - stairsC[1]);
			}
			if (!visited[i]) {  
				stair2[cnt2++] = (int) Math.abs(peopleR[i] - stairsR[2]) + Math.abs(peopleC[i] - stairsC[2]);
			}
		}
		Arrays.sort(stair1);
		Arrays.sort(stair2);
		int time = 0;
		int idx1 = 0, idx2 = 0; // 각 계단에 배정된 사람 인덱스
		Queue<Integer> queue1 = new LinkedList<>(); // 계단 1
		Queue<Integer> queue2 = new LinkedList<>(); // 계단 2
		int latest = 0; // 계단에서 마지막으로 내려오는 사람의 시간
		while (idx1 != stair1.length || idx2 != stair2.length) {
			time++;
			while (!queue1.isEmpty() && queue1.peek() == time) { // 1번 계단에서 내림
				queue1.poll();
			}
			while (!queue2.isEmpty() && queue2.peek() == time) { // 2번 계단에서 내림
				queue2.poll();
			}
			while (idx1 < stair1.length && stair1[idx1] + 1 <= time && queue1.size() < 3) { // 1번 계단에 올림
				queue1.add(time + K[1]);
				idx1++;
				if (time + K[1] > latest) latest = time + K[1];
			}
			while (idx2 < stair2.length && stair2[idx2] + 1 <= time && queue2.size() < 3) { // 2번 계단에 올림
				queue2.add(time + K[2]);
				idx2++;
				if (time + K[2] > latest) latest = time + K[2];
			}
		}
		if (latest < min) {
			min = latest;
		}
	}
}