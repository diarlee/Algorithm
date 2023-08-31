import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static int[] list = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
	public static int N;
	public static int R;
	public static int[][] infos;
	public static int[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			R = N / 2;
			infos = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					infos[i][j] = sc.nextInt();
				}
			}
			sel = new int[R];
			List<Integer> sumResult = new ArrayList<>();
			comb(0, 0, sumResult);
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < sumResult.size() / 2; i++) { // i번째 부분집합과 2^^R - 1번째 부분집합을 합치면 전체 집합
				int differ = Math.abs(sumResult.get(i) - sumResult.get(sumResult.size() - 1 - i));
				if (differ < min) min = differ;
			}
			System.out.println("#" + tc + " " + min);
		}
	}
	
	
	public static void comb(int n, int r, List<Integer> sumResult) { // n개 중 r개 뽑아서 리스트에 담기
		if (r == R) { // 부분집합 완성
			int sel1Sum = 0; // 부분집합 시너지합 구하기
			for (int i = 0; i < R - 1; i++) {
				for (int j = i + 1; j < R; j++) {
					sel1Sum += infos[sel[i]][sel[j]];
					sel1Sum += infos[sel[j]][sel[i]];
				}
			}
			sumResult.add(sel1Sum);
			return;
		}
		if (n == N) return;
		sel[r] = list[n]; // 현재 원소 n
		comb(n + 1, r + 1, sumResult); // n 포함
		comb(n + 1, r, sumResult); // n 미포함
	}
}