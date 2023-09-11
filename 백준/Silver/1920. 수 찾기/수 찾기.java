import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int left = 0;
			int right = N - 1;
			int num = Integer.parseInt(st.nextToken());
			int check = 0;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (arr[mid] == num) {
					check = 1;
					System.out.println(check);
					break;
				}
				if (arr[mid] > num) right = mid - 1;
				else if (arr[mid] < num) left = mid + 1;
			}
			if (check == 0) System.out.println(check);
		}
	}
}