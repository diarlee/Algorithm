import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static int[] gyuCards;
	public static int[] inCards;
	public static int win;
	public static int lose;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] nums = new int[19];
			gyuCards = new int[9];
			for (int i = 0; i < 9; i++) {
				int n = sc.nextInt();
				gyuCards[i] = n;
				nums[n] = 1;
			}
			inCards = new int[9];
			for (int n = 1, i = 0; n <= 18; n++) {
				if (nums[n] == 0) inCards[i++] = n;
			}
			win = 0; 
			lose = 0;
			perm(0);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}
	
	public static void perm(int idx) {
		if (idx == 9) { // 순열완성
			int gyuScore = 0;
			int inScore = 0;
			for (int i = 0; i < 9; i++) { // 완성된 수열 하나당 카드게임 진행
				if (gyuCards[i] > inCards[i]) {
					gyuScore += (gyuCards[i] + inCards[i]);
				}
				if (gyuCards[i] < inCards[i]) {
					inScore += (gyuCards[i] + inCards[i]);
				}
			}
			// 카드게임 결과
			if (gyuScore > inScore) win++;
			if (gyuScore < inScore) lose++;
			return;
		}
		
		for (int i = idx; i < 9; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx); // 원상복귀
		}
	}
	
	public static void swap(int a, int b) {
		int tmp = inCards[a];
		inCards[a] = inCards[b];
		inCards[b] = tmp;
	}
}