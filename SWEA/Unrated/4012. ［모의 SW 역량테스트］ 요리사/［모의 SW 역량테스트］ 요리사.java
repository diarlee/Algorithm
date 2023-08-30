import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
	public static int N;
	public static int[][] bd;
	public static int[] sl;
	public static int[] sx;
	public static int totsum;
	public static int mini;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			bd = new int[N][N];
			sl = new int[N / 2];
			sx = new int[N / 2];
			mini = Integer.MAX_VALUE;
			totsum = 0;
			for (int i = 0; i < N; i++) {
				String[] tempLine = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(tempLine[j]);
					bd[i][j] = temp;
					totsum += temp;
				}
			}
			fc(0, 0);
			System.out.println("#" + tc + " " + mini);
		}
	}

	public static void fc(int idx, int sidx) {
		if (sidx == N / 2) {
			int s1 = 0;
			int s2 = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < i; j++) {
					s1 += bd[sl[i]][sl[j]]+bd[sl[j]][sl[i]] ;
				}
			}
			for (int i = 0, k = 0; i < N; i++) {
				if (k < N / 2 && sl[k] == i) {
					k++;
					continue;
				}
				for (int j = 0, l = 0; j<i ; j++) {
					if (l < N / 2 && sl[l] == j) {
						l++;
						continue;
					}
					s2 += bd[i][j]+bd[j][i];
				}
			}
			mini = Math.min(Math.abs(s2 - s1), mini);
			return;
		}
		for (int i = idx; i <= (N / 2) + sidx; i++) {
			sl[sidx] = i;
			fc(i + 1, sidx + 1);
		}
	}
}