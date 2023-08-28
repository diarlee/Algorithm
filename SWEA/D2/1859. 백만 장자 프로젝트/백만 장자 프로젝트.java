import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int max = 0, maxIdx = 0;
			long profit = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				if (max < arr[i]) { // 처음 나온 최대값이 max
					max = arr[i];
					maxIdx = i;
				}
			}
			int idx = 0;
			while (idx < N) {
				if (idx < maxIdx && arr[idx] < max) { // 최대값 이전에 구입하여 최대값에 파는 경우
					profit += (max - arr[idx]);
				}
				if (arr[idx] == max) { // 최대값을 만날 경우 초기화
					max = 0;
					maxIdx = 0;
					for (int i = idx + 1; i < N; i++) { // 새로운 최대값 구하기
						if (max < arr[i]) {
							max = arr[i];
							maxIdx = i;
						}
					}
				}
				idx++;
			}
			System.out.println("#" + t + " " + profit);
		}
	}
}