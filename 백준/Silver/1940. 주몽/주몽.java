import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
		Arrays.sort(arr); // 정렬
		int st = 0, ed = arr.length - 1; // 투 포인터 // 양쪽 끝에서 시작
		int sum = 0, cnt = 0;
		while (st < ed) {
			sum = arr[st] + arr[ed];
			if (sum < M) st++;
			if (sum > M) ed--;
			if (sum == M) {
				cnt++;
				st++;
				ed--;
			}
		}
		System.out.println(cnt);
	}
}
