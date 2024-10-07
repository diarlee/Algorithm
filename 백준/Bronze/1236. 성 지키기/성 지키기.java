import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		int rowCnt = 0;
		outer: for (int i = 0; i < N; i++) {
			inner : for (int j = 0; j < M; j++) {
				if (map[i][j] == 'X') {
					continue outer;
				}
			}
			rowCnt++;
		}
		int colCnt = 0;
		outer : for (int j = 0; j < M; j++) {
			inner : for (int i = 0; i < N; i++) {
				if (map[i][j] == 'X') {
					continue outer;
				}
			}
			colCnt++;
		}
		
		int answer;
		if (rowCnt == 0) answer = colCnt;
		else if (colCnt == 0) answer = rowCnt;
		else answer = Math.max(rowCnt, colCnt);
		System.out.println(answer);
	}
}