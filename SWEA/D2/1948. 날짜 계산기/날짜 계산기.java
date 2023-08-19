import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// 달별 날짜 누적 합 구하기
		int[] month = new int[13];
		month[1] = 31;
		month[2] = 28;
		month[3] = 31;
		month[4] = 30;
		month[5] = 31;
		month[6] = 30;
		month[7] = 31;
		month[8] = 31;
		month[9] = 30;
		month[10] = 31;
		month[11] = 30;
		month[12] = 31;
		int[] cumMonth = new int[13];
		for (int i = 1; i <= 12; i++)
			cumMonth[i] = month[i - 1] + cumMonth[i - 1];
		for (int t = 1; t <= T; t++) {
			int firMonth = sc.nextInt(), firDay = sc.nextInt();
			int secMonth = sc.nextInt(), secDay = sc.nextInt();
			int result = cumMonth[secMonth] + secDay - cumMonth[firMonth] - firDay + 1;
			System.out.println("#" + t + " " + result);
		}
	}
}