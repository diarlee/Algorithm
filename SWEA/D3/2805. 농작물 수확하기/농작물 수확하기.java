import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] _tmp = sc.next().split("");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(_tmp[j]);
				}
			}
			int st = N / 2; // 각 행에서 시작 열
			int blocks = 1; // 각 행에서 count하는 구역 수
			int sum = 0;
			for (int i = 0; i <= N / 2; i++) {
				for (int j = st; j < st + blocks; j++) {
					if (i == N - 1 - i) sum += arr[i][j];
					else {
						sum += arr[i][j];
						sum += arr[N - 1 -i][j];
					}
				}
				st--;
				blocks += 2;
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}