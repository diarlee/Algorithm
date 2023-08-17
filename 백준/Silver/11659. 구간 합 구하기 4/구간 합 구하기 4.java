import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] nums = new int[N]; // input 받음
		for (int k = 0; k < N; k++) 
			nums[k] = sc.nextInt();
		int[] cumNums = new int[N]; // input 누적합 구하기
		cumNums[0] = nums[0];
		for (int k = 1; k < N; k++)
			cumNums[k] = cumNums[k - 1] + nums[k];
		for (int k = 0; k < M; k++) {
			int i = sc.nextInt(), j = sc.nextInt();
			if (i == 1) System.out.println(cumNums[j - 1]);
			else System.out.println(cumNums[j - 1] - cumNums[i - 2]);
		}
	}
}
