import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static boolean IsDanJo(int num) { // 단조 증가하는 수인지 확인
		int _tmp = num;
		List<Integer> arrNum = new ArrayList<>();
		while (_tmp > 0) {
			arrNum.add(0, _tmp % 10); // 일의 자리부터 배열에 담기
			if (arrNum.size() > 1 && arrNum.get(0) > arrNum.get(1)) return false; // 낮은 자리수보다 높은 자리수 값이 더 큼
			_tmp /= 10;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			int max = -1;
			if (N == 1 && IsDanJo(nums[0]) == true) max = nums[0]; // N의 범위 확인
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int val = nums[i] * nums[j];
					if (val > max && IsDanJo(val) == true) max = val;
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}