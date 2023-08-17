import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] condi = br.readLine().split(" ");
		int N = Integer.parseInt(condi[0]);
		int M = Integer.parseInt(condi[1]);
		int[][] arr = new int[N][N]; // 입력받기
		for (int i = 0; i < N; i++) {
			String[] nums = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(nums[j]);
			}
		}
		int[][] sumArr = new int[N][N]; // 누적합 구하기

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 && j == 0)
					sumArr[i][j] = arr[i][j];
				else if (i == 0)
					sumArr[i][j] = sumArr[i][j - 1] + arr[i][j];
				else if (j == 0)
					sumArr[i][j] = sumArr[i - 1][j] + arr[i][j];
				else
					sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + arr[i][j];
			}
		} 
		for (int k = 0; k < M; k++) { // 구간합 구하기
			String[] range = br.readLine().split(" ");
			int x1 = Integer.parseInt(range[0]);
			int y1 = Integer.parseInt(range[1]);
			int x2 = Integer.parseInt(range[2]);
			int y2 = Integer.parseInt(range[3]);
			int total = 0;
			if (x1 == x2 && y1 == y2) total = arr[x1 - 1][y1 - 1];
			else if (x1 == 1 && y1 == 1) total = sumArr[x2 - 1][y2 - 1];
			else if (x1 == 1) total = sumArr[x2 - 1][y2 - 1] - sumArr[x2 - 1][y1 - 2];
			else if (y1 == 1) total = sumArr[x2 - 1][y2 - 1] - sumArr[x1 - 2][y2 - 1];
			else total = sumArr[x2 - 1][y2 - 1] - sumArr[x2 - 1][y1 - 2] - sumArr[x1 - 2][y2 - 1]
					+ sumArr[x1 - 2][y1 - 2];
			bw.write(total + "\n");
		}
		br.close();
		bw.close();
	}
}