import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] nums = new int[N];
		for (int k = 0; k < N; k++) { // 입력받음
			nums[k] = sc.nextInt(); // 5 4 3 2 1
		}

		for (int l = 1; l < N; l++) { // 배열 누적 덧셈
			nums[l] += nums[l - 1]; // 5 9 12 14 15
		}

		for (int p = 0; p < M; p++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int sum = 0;
			if (i == 1)
				sum = nums[j - 1];
			else
				sum = nums[j - 1] - nums[i - 2];
			System.out.println(sum);
		}
	}
}
