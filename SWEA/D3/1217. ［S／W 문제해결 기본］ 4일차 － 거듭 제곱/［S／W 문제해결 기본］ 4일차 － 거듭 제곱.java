import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int N = sc.nextInt(), M = sc.nextInt();
			int[] stored = new int[M + 1];
			System.out.println("#" + tc + " " + pow(N, M, stored));
		}
	}
	// 한 번 계산한 값은 저장하면서 재귀
	public static int pow(int N, int M, int[] list) {
		if (list[M] != 0) return list[M]; 
		if (M == 1) {
			list[M] = N;
			return list[M];
		}
		if (M % 2 == 0) { // 짝수일때
			if (list[M] == 0) list[M] = pow(N, M / 2, list) * pow(N, M / 2, list);
			return list[M];
		}
		else { // 홀수일때
			if (list[M] == 0) list[M] = pow(N, M / 2, list) * pow(N, M / 2, list) * N;
			return list[M];
		}
	}
}