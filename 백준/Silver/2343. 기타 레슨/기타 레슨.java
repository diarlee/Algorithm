import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > left) left = arr[i]; // 최소 동영상 하나
			right += arr[i]; // 최대 동영상 전체
		}
		int cnt;
		int size;
		int mid;
		int min = Integer.MAX_VALUE;
		while (left <= right) {
			mid = (left + right) / 2;
			size = mid;
			cnt = M - 1; // 녹화 시작 때마다 count
			for (int i = 0; i < N; i++) {
				size -= arr[i];
				if (size < 0) { // 새로운 녹화 시작
					cnt--;
					size = mid - arr[i];
				}
			}
			if (cnt >= 0) { // 다 담을 수 있음
				right = mid - 1;
			}
			if (cnt < 0) { // 다 담을 수 없음
				left = mid + 1;
			}
		}
		System.out.println(left);
	}
}