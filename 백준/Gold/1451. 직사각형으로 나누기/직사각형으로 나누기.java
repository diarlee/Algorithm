import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[][] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = input.charAt(j - 1) - '0';
			}
		}
		
		sum = new long[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + arr[i][j];
			}
		}
		
		long max = 0;
		long s1, s2, s3;
		
		// ㅣㅣ
		for (int i = 1; i <= M - 2; i++) {
			s1 = getSum(1, 1, N, i);
			for (int j = i + 1; j <= M - 1; j++) {
				s2 = getSum(1, i + 1, N, j);
				s3 = getSum(1, j + 1, N, M);
				max = Math.max(max, s1 * s2 * s3);
			}
		}
		
		// =
		for (int i = 1; i <= N - 2; i++) {
			s1 = getSum(1, 1, i, M);
			for (int j = i + 1; j <= N - 1; j++) {
				s2 = getSum(i + 1, 1, j, M);
				s3 = getSum(j + 1, 1, N, M);
				max = Math.max(max, s1 * s2 * s3);
			}
		}
		
		// ㅜ
		for (int i = 1; i <= N - 1; i++) {
			s1 = getSum(1, 1, i, M);
			for (int j = 1; j <= M - 1; j++) {
				 s2 = getSum(i + 1, 1, N, j);
				 s3 = getSum(i + 1, j + 1, N, M);
				 max = Math.max(max, s1 * s2 * s3);
			}
		}
		
		// ㅗ
		for (int i = 1; i <= N - 1; i++) {
			for (int j = 1; j <= M - 1; j++) {
				s1 = getSum(1, 1, i, j);
				s2 = getSum(1, j + 1, i, M);
				s3 = getSum(i + 1, 1, N, M);
				max = Math.max(max, s1 * s2 * s3);

			}
		}
		
		// ㅏ
		for (int i = 1; i <= M - 1; i++) {
			s1 = getSum(1, 1, N, i);
			for (int j = 1; j <= N - 1; j++) {
				s2 = getSum(1, i + 1, j, M);
				s3 = getSum(j + 1, i + 1, N, M);
				max = Math.max(max, s1 * s2 * s3);
			}
		}
		
		// ㅓ
		for (int i = 1; i <= N - 1; i++) {
			for (int j = 1; j <= M - 1; j++) {
				s1 = getSum(1, 1, i, j);
				s2 = getSum(i + 1, 1, N, j);
				s3 = getSum(1, j + 1, N, M);
				max = Math.max(max, s1 * s2 * s3);
			}
		}
		
		System.out.println(max);
	}
	
	static long getSum(int r1, int c1, int r2, int c2) {
		 return sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
	}
}