import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			int cnt1 = 0;
			int cnt2 = 0;
			String str1 = sc.next(); // 비교할 문자열 입력 받기
			String snt = sc.next(); // 문장 입력 받기
			for (int i = 0; i < snt.length() - str1.length() + 1; i++) {
				cnt1 = 0;
				// 문장속에 첫 번째 문자가 비교 문자열의 첫 번째 문자열과 동일한 경우에만 계산 수행
				if (str1.charAt(0) == snt.charAt(i)) {
					cnt1++; // 각 문자 비교 횟수
					for (int j = i; j < str1.length() + i - 1; j++) {
						if (str1.charAt(1 + j - i) == snt.charAt(j + 1))
							cnt1++; // 각 문자 비교 횟수
					}
				}
				if (cnt1 == str1.length()) // 모든 문자가 같다면
					cnt2++;
			}
			System.out.println("#" + test_case + " " + cnt2);
		}
	}
}