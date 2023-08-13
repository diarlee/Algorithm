import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) { // 입력받음
				arr[i] = sc.nextInt();
			}
			int cnt = 0;
			for (int i = 2; i < N - 2; i++) {
				int[] test = new int[4];
				int min = Integer.MAX_VALUE;
				test[0] = arr[i] - arr[i - 1];
				test[1] = arr[i] - arr[i - 2];
				test[2] = arr[i] - arr[i + 1];
				test[3] = arr[i] - arr[i + 2];
				for (int j = 0; j < test.length; j++) {
					if (test[j] <= 0) {
						min = 0;
						break;
					}
					else {
						if (test[j] < min) min = test[j];
					}
				}
				cnt += min;
			}
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
}