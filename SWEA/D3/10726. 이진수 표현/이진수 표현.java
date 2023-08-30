import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); 
			int M = sc.nextInt();
			int[] bits = new int[30];
			int idx = 29;
			while (M > 0) {
				bits[idx--] = M % 2;
				M /= 2;
			}
			String ans = "ON";
			for (int i = 29; i > 29 - N; i--) {
				if (bits[i] != 1) {
					ans = "OFF";
					break;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
// Integer.toBinaryString(1) -> 1