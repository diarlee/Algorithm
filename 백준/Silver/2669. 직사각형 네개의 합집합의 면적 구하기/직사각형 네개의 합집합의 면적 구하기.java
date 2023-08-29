import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[4][4];
		int maxX = 0;
		int maxY = 0;
		for (int i = 0; i < 4; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				if (j == 2 && arr[i][j] > maxX) maxX = arr[i][j];
				if (j == 3 && arr[i][j] > maxY) maxY = arr[i][j];
			}
		}
		int size = 0;
		int[][] graph = new int[maxX][maxY]; // 평면좌표를 이차원배열로 만들기
		for (int i = 0; i < 4; i++) {
			int x1 = arr[i][0];
			int y1 = arr[i][1];
			int x2 = arr[i][2];
			int y2 = arr[i][3];
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					if (graph[x][y] == 0) { // 직사각형이 있는 위치는 1 없는 위치는 0
						size++;
						graph[x][y] = 1;
					}
				}
			}
		}
		System.out.println(size);
	}
}