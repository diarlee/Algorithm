import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(), M = sc.nextInt();
			char[][] arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next().toCharArray();
			}
			int stR = 0, stC = 0; 
			outter : for (int i = 0; i < N; i++) {
				for (int j = M - 1; j >= 0; j--) {
					if (arr[i][j] == '1') {
						stR = i; 
						stC = j - 55;
						break outter;
					}
				}
			}
			char[] code = new char[7];
			int idx = 0;
			int[] decoded = new int[8];
			int decodedIdx = 0;
			for (int j = stC; j < stC + 56; j++) {
				code[idx++] = arr[stR][j];
				if (idx == 7) { // 암호 decoding
					decoded[decodedIdx++] = whatNumber(code);
					idx = 0;
				}
			}
			System.out.println("#" + tc + " " + isCorrectCode(decoded));
		}
	}
	
	public static int whatNumber(char[] code) {
		char[] code0 = {'0', '0', '0', '1', '1', '0', '1'};
		char[] code1 = {'0', '0', '1', '1', '0', '0', '1'}; 
		char[] code2 = {'0', '0', '1', '0', '0', '1', '1'};
		char[] code3 = {'0', '1', '1', '1', '1', '0', '1'};
		char[] code4 = {'0', '1', '0', '0', '0', '1', '1'};
		char[] code5 = {'0', '1', '1', '0', '0', '0', '1'};
		char[] code6 = {'0', '1', '0', '1', '1', '1', '1'};
		char[] code7 = {'0', '1', '1', '1', '0', '1', '1'};
		char[] code8 = {'0', '1', '1', '0', '1', '1', '1'};
		char[] code9 = {'0', '0', '0', '1', '0', '1', '1'};
		if (Arrays.equals(code, code0)) return 0;
		else if (Arrays.equals(code, code1)) return 1;
		else if (Arrays.equals(code, code2)) return 2;
		else if (Arrays.equals(code, code3)) return 3;
		else if (Arrays.equals(code, code4)) return 4;
		else if (Arrays.equals(code, code5)) return 5;
		else if (Arrays.equals(code, code6)) return 6;
		else if (Arrays.equals(code, code7)) return 7;
		else if (Arrays.equals(code, code8)) return 8;
		else return 9;
	}
	
	public static int isCorrectCode(int[] decoded) {
		int oddSum = 0;
		int evenSum = 0;
		for (int i = 0; i < 8; i++) {
			if (i % 2 == 0) oddSum += decoded[i];
			else evenSum += decoded[i];
		}
		if ((oddSum * 3 + evenSum) % 10 == 0) return oddSum + evenSum;
		else return 0;
	}
}