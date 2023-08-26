import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String[] input = sc.next().split("");
			int N = input.length;
			int[] memory = new int[N];
			for (int i = 0; i < N; i++) 
				memory[i] = Integer.parseInt(input[i]);
			int cnt = 0, idx = 0, curValue = 0;
			while (idx < N) { // 값이 연속해서 나오면 고칠 필요 X
				if (curValue == 0 && memory[idx] != curValue) { // 값이 연속하지 않을 경우 고침
					cnt++;
					curValue = 1;
				}
				if (curValue == 1 && memory[idx] != curValue) { // 값이 연속하지 않을 경우 고침
					cnt++;
					curValue = 0;
				}
				idx++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}