import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] wheels;
	static boolean[] equals;
	static int[] rotated;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wheels = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheels[i][j] = Integer.parseInt(tmp.substring(j, j + 1));
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wheel = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			equals = new boolean[3]; // equals[j] : j번 바퀴가 j + 1번 바퀴와 맞닿는 부분의 값이 같은지
			for (int j = 0; j < 3; j++) {
				if (wheels[j][2] == wheels[j + 1][6]) {
					equals[j] = true;
				}
			}
			
			rotated = new int[4];
			getRotated(wheel ,dir);
			for (int j = 0; j < 4; j++) {
				if (rotated[j] != 0) {
					rotate(j, rotated[j]);
				}
			}
		}
		int result = 0;
		if (wheels[0][0] == 1) result++;
		if (wheels[1][0] == 1) result += 2;
		if (wheels[2][0] == 1) result += 4;
		if (wheels[3][0] == 1) result += 8;
		System.out.println(result);
	}
	
	static void getRotated(int wheel, int dir) {
		rotated[wheel] = dir;
		int leftWheel = wheel - 1;
		int rightWheel = wheel + 1;
		if (0 <= leftWheel && rotated[leftWheel] == 0 && !equals[leftWheel]) {
			getRotated(leftWheel, dir * -1);
		}
		if (rightWheel < 4 && rotated[rightWheel] == 0 && !equals[wheel]) {
			getRotated(rightWheel, dir * -1);
		}
	}
	
	static void rotate(int wheel, int dir) {
		if (dir == 1) {
			int tmp = wheels[wheel][7];
			for (int i = 7; i >= 1; i--) {
				wheels[wheel][i] = wheels[wheel][i - 1];
			}
			wheels[wheel][0] = tmp;
		}
		if (dir == -1) {
			int tmp = wheels[wheel][0];
			for (int i = 0; i < 7; i++) {
				wheels[wheel][i] = wheels[wheel][i + 1];
			}
			wheels[wheel][7] = tmp;
		}
	}
}