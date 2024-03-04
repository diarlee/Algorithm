import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] video;
	static String result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		result = "";
		compress(N, 0, 0);
		System.out.println(result);
	}
	
	static void compress(int N, int x, int y) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += video[x + i][y + j];
			}
		}
		if (sum == 0) {
			result += "0";
			return;
		}
		if (sum == N * N) {
			result += "1";
			return;
		}
		result += "(";
		compress(N/2, x, y);
		compress(N/2, x, y+N/2);
		compress(N/2, x+N/2, y);
		compress(N/2, x+N/2, y+N/2);
		result += ")";
	}
}