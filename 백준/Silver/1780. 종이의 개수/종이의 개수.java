import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] result = new int[3];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(N, 0, 0);
		for (int i = 0; i < 3; i++) {
			System.out.println(result[i]);
		}
	}
	
	static void recur(int N, int x, int y) {
		if (N == 1) {
			count(map[x][y]);
			return;
		}
		
		int value = map[x][y];
		boolean isAllSame = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[x + i][y + j] != value) {
					isAllSame = false;
					break;
				}
			}
		}
		
		if (isAllSame) {
			count(value);
			return;
		}
		
		for (int i = 0; i < N; i+=N/3) {
			for (int j = 0; j < N; j+=N/3) {
				recur(N/3, x+i, y+j);
			}
		}
	}
	
	static void count(int value) {
		if (value == -1) result[0]++;
		if (value == 0) result[1]++;
		if (value == 1) result[2]++;
	}
}