import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int rotate = N / 4;
			char[] nums = sc.next().toCharArray();
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < rotate; i++) { // 회전
				char tmp = nums[N - 1];
				for (int j = N - 1; j >= 1; j--) { // 오른쪽으로 한 칸씩 shift
					nums[j] = nums[j - 1];
				}
				nums[0] = tmp;
				String num = "";
				for (int j = 0; j < N; j++) {
					num += nums[j];
					if ((j + 1) % rotate == 0 && !result.contains(Integer.parseInt(num, 16))) // 한 변마다 확인
						result.add(Integer.parseInt(num, 16));
					if ((j + 1) % rotate == 0) num = "";
				}
			}
			result.sort(Comparator.reverseOrder());
			System.out.println("#" + tc + " " + result.get(K - 1));
		}
	}
}