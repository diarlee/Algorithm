import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int L;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		int[][] rows = new int[N][N];
		int[][] cols = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				rows[i][j] = Integer.parseInt(st.nextToken());
				cols[j][i] = rows[i][j];
			}
		}
		
		cnt = 0;
		for (int i = 0; i < N; i++) {
			canPass(rows[i]);
			canPass(cols[i]);
		}
		
		System.out.println(cnt);
	}
	
	static void canPass(int[] way) {
		int preHeight = 0;
		int curHeight = way[0];
		int j = 1;
		boolean[] visited = new boolean[N]; // 경사로 중복 판단
		outer : while (true) {
			if (j == N) {
				cnt++;
				break outer;
			}
			preHeight = curHeight;
			curHeight = way[j];
			if (preHeight == curHeight) {
				j++;
				continue;
			}
			if (Math.abs(preHeight - curHeight) > 1) break outer;
			if (preHeight < curHeight) {
				for (int k = j - 1; k >= j - L; k--) {
					if (k < 0 || way[k] != preHeight || visited[k]) break outer;
				}
				for (int k = j - 1; k >= j - L; k--) {
					visited[k] = true;
				}
				j++;
			} else {
				for (int k = j; k < j + L; k++) {
					if (k >= N || way[k] != curHeight || visited[k]) break outer;
				}
				for (int k = j; k < j + L; k++) {
					visited[k] = true;
				}
				j += L;
				curHeight = way[j - 1];
			}		
		}
	}
}