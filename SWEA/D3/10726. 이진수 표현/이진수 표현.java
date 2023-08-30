import java.util.Scanner;

public class Solution {
	// M & 하위 N비트만 1인 수 == 하위 N비트만 1인 수 : M의 하위 N비트가 다 1이다!
	// 하위 N비트만 1인 수  : 1 << N - 1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); 
			int M = sc.nextInt();
			String ans = "ON";
			if ((M & ((1 << N) - 1)) != ((1 << N) - 1)) { // 이진수 비교 // 출력하면 십진수로
				ans = "OFF";
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}