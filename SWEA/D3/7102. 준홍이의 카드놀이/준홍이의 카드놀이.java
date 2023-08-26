import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					int sum = i + j;
					// 숫자 합한 결과 count
					if (!map.containsKey(sum)) { 
						map.put(sum, 1);
					} else {
						int _tmp = map.get(sum);
						map.put(sum, _tmp + 1);
					}
				}
			}
			int max = 0;
			for (int key : map.keySet()) {
				if (map.get(key) > max) {
					max = map.get(key);
				}
			}
			System.out.print("#" + test_case);
			for (int key : map.keySet()) {
				if (map.get(key) == max)
					System.out.print(" " + key);
			}
			System.out.println();
		}
	}
}